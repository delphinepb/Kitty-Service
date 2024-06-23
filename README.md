# README: Microservice Kitty

Welcome to the Kitty Microservice project! This document will guide you through the configuration, structure and use of the project. It is intended to help you understand the code and functionality of the microservice.

---

## Table of contents

1. [Introduction](#introduction)
2. [Project structure](#project-structure)
3. [Configuration and installation](#setup-and-installation)
6. [API endpoints](#api-endpoints)

---

## Introduction

We are looking to develop a microservice to manage customer kitty funds. This microservice will allow merchants to add amounts to a customer's kitty each time they make a purchase. Customers can check the status of their kitty at any time. A kitty is considered available if the customer has made at least 3 purchases and the amount in the kitty is at least €10.

## Project Structure

```text
bforbank-cagnotte-microservice/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/bforbank/cagnotteservice/
│   │   │       ├── controller/
│   │   │       ├── entity/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       └── CagnotteServiceApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   │       └── schema.sql
│   └── test/
│       └── java/
│           └── com/bforbank/cagnotteservice/
├── .gitignore
├── README.md
└── pom.xml
``` 

controller/: Contains REST controllers.
entity/: Contains JPA entities.
repository/: Contains JPA repositories.
service/: Contains business logic.
CagnotteServiceApplication.java: Main application class.
application.properties: Application configuration.
data.sql: Initial data setup.
test/: Unit and integration tests.

## Configuration and installation

```text
git clone https://github.com/username/bforbank-cagnotte-microservice.git
cd bforbank-cagnotte-microservice
```


### API Endpoints

This section details the different endpoints available for interacting with the kitty management microservice. Each endpoint is accompanied by examples of requests and descriptions of the parameters and possible responses.
#### 1. Create a kitty
- **URL** : `/api/kitties`
- **Method HTTP** : `POST`
- **Description** : Create a new kitty for a customer.
- **Body** :
  ```json
  {
      "clientId": "12345",
      "initialAmount": 20.0
  }
  ```

#### 2. Add funds to a Kitty
- **URL** : `/api/kitties/{kittyId}/add-funds`
- **Method HTTP** : `POST`
- **Description** : Add funds to an existing kitty.
- **Parameters of URL** :
  - `{kittyId}` : Kitty identifier.
- **Body** :
  ```json
  {
      "amount": 10.0
  }
  ```

#### 3. Get the details of a Kitty

- **URL** : `/api/kitties/{kittyId}`
- **Method HTTP** : `GET`
- **Description** : Retrieves the details of a specific kitty.
- **Paramètres of URL** :
  - `{kittyId}` : Kitty identifier.

#### 4. Check Kitty Availability

- **URL** : `/api/kitties/{kittyId}/available`
- **Method HTTP** : `GET`
- **Description** : Check that the kitty is available (at least 3 checkouts and €10).
- **Parameters of URL** :
  - `{kittyId}` :  Kitty identifier.

#### 5. List of Customer Kitty's

- **URL** : `/api/clients/{clientId}/kitties`
- **Method HTTP** : `GET`
- **Description** : Retrieves the list of prize pools associated with a customer.
- **Parameters d'URL** :
  - `{clientId}` :  Client identifier.

#### 6. Delete a Kitty

- **URL** : `/api/kitties/{kittyId}`
- **Method HTTP** : `DELETE`
- **Description** : Deletes an existing kitty.
- **Parameters of URL** :
  - `{kittyId}` : Kitty identifier.

#### Examples of HTTP requests

##### Create a Kitty

```http
POST /api/kitties HTTP/1.1
Content-Type: application/json

{
    "clientId": "12345",
    "initialAmount": 20.0
}
```

##### Add funds to a Kitty

```http
POST /api/kitties/1/add-funds HTTP/1.1
Content-Type: application/json

{
    "amount": 10.0
}
```

##### Get the details of a Kitty

```http
GET /api/kitties/1 HTTP/1.1
```

##### Check Kitty Availability

```http
GET /api/kitties/1/availability HTTP/1.1
```

##### List of Customer Kitty's

```http
GET /api/clients/12345/kitties HTTP/1.1
```

##### Delete a Kitty

```http
DELETE /api/kitties/1 HTTP/1.1
```

These endpoints enable customers' kitty funds to be managed efficiently, their availability to be checked and the funds added to these kitty funds to be managed smoothly.