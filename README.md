# Bidding System
## About
This is a demo project to demonstrate the working of a bidding system that enables the users to place the bid for running auctions through api.
It is made using **Java 1.8, Spring Boot, Spring Data JPA, Lombok. Database is H2.**

## Assumptions
1. Bidder/Seller login and registration functionality is not implemented. In place order api request bidder id will be passed. Database design is however done in such a way that user functionality can be extended.
2. This application will support only reading auctions from the database.
3. Start and stop the auction is not implemented.

## Configurations
### Configuration Files
Folder **src/main/resources/** contains config files for Bidding System Spring Boot application.
- **src/main/resources/application.properties** - main configuration file. 
- **src/main/resources/data.sql** - This file contains mysql queries that will be executed as soon as the application starts.

## Build Project
1. Clone the project and navigate to the root path
2. Set Username and Password in the **application.properties** file.
3) Invoke `mvn clean install -DskipTests`

## Run Project
Invoke following command `java -jar target/bidding-system-0.0.1-SNAPSHOT.jar`

## API Description
1. **Get Auctions on the basis of status API**
  - URI - http://localhost:8080/api/auction?status=RUNNING
  - Method - GET
2. **Place Bid**(itemId is the primary key id from the item table)
  - URI - http://localhost:8080/api/auction/{itemId}/bid
  - Method - POST
  - Request Body - {"bidAmount":2400,"userId":1}
  - Request Headers
    - Content-Type:application/json
  
