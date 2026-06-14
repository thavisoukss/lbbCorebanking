# LBB Corebanking Service

## Overview

Spring Boot 3.4.2 microservice (Java 17) that acts as a **middleware adapter** between the LBB API Gateway and an external core banking system. It wraps all core banking API calls, injects authentication headers, and auto-injects the core banking business date before submitting transactions.

- **Base URL (dev):** `http://localhost:8082`
- **Controller prefix:** `/api/corebanking`
- **Upstream core banking URL (dev):** `http://172.16.4.112:8443/api/v1`

---

## Architecture

```
Client / API Gateway
       |
CorebankingController   (REST layer)
       |
CoreBankingService      (business logic, date injection)
       |
ApiClient               (HTTP client wrapper using RestTemplate)
       |
External Core Banking System (172.16.4.112:8443)
```

| Layer | File | Role |
|---|---|---|
| Controller | `controller/CorebankingController.java` | Routes HTTP requests, returns responses |
| Service | `service/CoreBankingService.java` | Builds request, injects date, calls ApiClient |
| HTTP Client | `domain/ApiClient.java` | Generic GET/POST via RestTemplate with error handling |
| Converter | `service/ConvertObject.java` | Converts exchange rate ApiResponse → ExchangeRateRes |
| Config | `config/RestTemplateConfig.java` | Timeout config: connect 5s, read 10s |

---

## API Endpoints

All endpoints are under `/api/corebanking` and use `POST` unless noted.

| Endpoint | Method | Description | Upstream Path |
|---|---|---|---|
| `/test` | GET | Health check | — |
| `/checkBalance` | POST | Account balance inquiry | `GET /dep/acctdashboardinfobal/{acctNo}` |
| `/openAccount` | POST | Open savings/current account | `POST /dep/acct` |
| `/termAccountInquery` | POST | Term deposit account inquiry | `GET /dep/accttd/{acctNo}` |
| `/openTDAccount` | POST | Open a Term Deposit account | `POST /dep/accttd` |
| `/getStatement` | POST | Get transaction history (paginated) | `GET /dep/tranhist` |
| `/getStatementDetailIN` | POST | Statement detail for deposit tx | `GET /dep/tranhist/{seqNo}` |
| `/getStatementDetailOut` | POST | Statement detail for outgoing tx | `GET /gft/internaltransfers/{ref}~{date}` |
| `/reversal` | POST | Reverse a transaction | `POST /dep/ReversalTran` |
| `/internalTransfer` | POST | Internal fund transfer | `POST /dep/transfertransaction` |
| `/buyGoldFundTransfer` | POST | Buy gold (internal transfer) | `POST /gft/internaltransfers` |
| `/topup` | POST | Top up (internal transfer) | `POST /gft/internaltransfers` |
| `/widthDraw` | POST | Withdrawal (internal transfer) | `POST /gft/internaltransfers` |
| `/getRate` | POST | Get exchange rate | `GET /csd/xrate` |

---

## Date Injection (Important)

For all write transactions (`buyGoldFundTransfer`, `internalTransfer`, `topup`, `widthDraw`), the service **does NOT use the client-supplied date**. Instead it:

1. Calls `GET /csd/coreregistryqry` to fetch the core banking system's current business date (`RunBatchRes`).
2. Parses the date via `OffsetDateTime` and formats it as `yyyy-MM-dd'T'HH:mm:ssXXX`.
3. Injects this date into `tranDate`, `drValueDate`, `crValueDate`, `instructedDate`, and `paymentOrdDetailRec.tranDate`.

This is done in `CoreBankingService.getDate()` → called by `buyGoldTransferDate()`, `internalTransferData()`, `topUpDate()`, `widthDrawDate()`.

---

## Authentication (Upstream API)

Every request to the core banking system includes:
- `Content-Type: application/json`
- `x-api-key: <COREBANKING_API_KEY>`
- `Authorization: Bearer <COREBANKING_TOKEN>`

Configured via `application-dev.yml` environment variables:
```
COREBANKING_URL
COREBANKING_API_KEY
COREBANKING_TOKEN
```

---

## Configuration

| Property | Default (dev) |
|---|---|
| `SERVER_PORT` | `8082` |
| `COREBANKING_URL` | `http://172.16.4.112:8443/api/v1` |
| `API_CLIENT_CONNECT_TIMEOUT` | `5000` ms |
| `API_CLIENT_READ_TIMEOUT` | `10000` ms |
| `DB_URL` | `jdbc:oracle:thin:@//localhost:1521/xe` |

Active profile: `dev` (set in `application.yml`). Prod profile in `application-prod.yml`.

---

## Domain Model Packages

Each feature has its own package under `domain/model/`:

| Package | Purpose |
|---|---|
| `checkBalance` | Balance inquiry request/response |
| `openaccount` | Open savings/current account |
| `openaccount/td` | Open Term Deposit account |
| `termdeposit` | Term deposit inquiry |
| `statement` | Transaction history list |
| `statementdeailin` | Statement detail — incoming transactions |
| `statmentdetialout` | Statement detail — outgoing transfers (note: typo in package name) |
| `exchangerate` | Exchange rate request/response |
| `buygold` | Buy gold fund transfer |
| `fundtransfer` | Internal fund transfer |
| `topup` | Top up transaction |
| `widthdraw` | Withdrawal transaction (note: typo in package name) |
| `reversal` | Transaction reversal |
| `runbatch` | Batch date query (`/csd/coreregistryqry`) |

---

## Build & Run

```bash
# Run with Maven wrapper (dev profile active by default)
./mvnw spring-boot:run

# Build JAR
./mvnw clean package -DskipTests

# Docker
docker build -t lbb-corebanking .
```

Logs are written to `logs/app-service.log` (Log4j2, config: `src/main/resources/log4j2.xml`).

---

## Key Notes

- `BearerTokenInterceptor` exists but is **commented out** in `RestTemplateConfig` — auth is set per-request in `CoreBankingService` headers instead.
- Oracle JDBC (`ojdbc8`) and JPA are included but the visible service logic makes no direct DB queries — the DB may be used by other parts not yet present or for future use.
- `domain/model/a.java` appears to be a scratch/test file.
- `buyGoldFundTransfer`, `topup`, and `widthDraw` all call the same upstream path `/gft/internaltransfers` — distinguished by the `tranType` field in the request body.
