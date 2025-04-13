# this is a simple NATS subscriber - made in a 3-Layered architectural style in Java and PostgreSQL

## Project Description

This is a 3-layered Java application that subscribes to a local NATS message bus, processes the incoming messages, and persists them into a PostgreSQL database. The architecture follows the API → Service → Data layer separation for clarity and maintainability.

## Architecture Overview

## 1. **API Layer** (API.Main)
- Subscribes to the NATS server on subject `messages`
- Receives messages and forwards them to the Service layer

## 2. **Service Layer** (Buisness.MessageProcessor)
- Handles JSON parsing, basic validation, and passing to the Data layer

## 3. **Data Layer** 
    ## Data.Entity.Message
    - Represents the structure of an incoming message

    ## Data.Service.MessageRepository 
    - Connects to PostgreSQL and inserts messages into the `messages` table
    
    ## Data.Service.test.DBCheck 
    - Checks connection with DB server, left in for testing purpouses


## 4. **Model**
🛠️ Setup Instructions

## Prerequisites

- Java 17+
- Maven
- PostgreSQL
- NATS Server (running locally)

##  PostgreSQL Setup

1. **Run the provided SQL script** to create the database and table:
   ```bash
   psql -U postgres -f setup.sql