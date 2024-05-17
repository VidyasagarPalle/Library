Instruction to run the application in mysql database
----------------------------------------------------
This application developed with using H2 database.
To run with MYSQL database, please update  application.properties file as below.

#spring.jpa.hibernate.ddl-auto=update
#spring.datasource.url=jdbc:mysql://localhost:3306/testdb?useSSL=false&allowPublicKeyRetrieval=true
#spring.datasource.username=
#spring.datasource.password=
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
#spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
#spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect


After updating the properties , Please re-run the application.



Inserting library data
----------------------------------------------
curl --location --request POST 'http://localhost:8080/libraries/create' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Central Library",
  "startTime": "08:00:00",
  "endTime": "18:00:00"
}'


Get library details 
--------------------------------------------------
curl --location --request GET 'http://localhost:8080/libraries/getAllLibraryDetails' \
--header 'Content-Type: application/json'


Inserting Rack data
---------------------------------------------
curl --location --request POST 'http://localhost:8080/rack/create' \
--header 'Content-Type: application/json' \
--data-raw '{
  "library": {
    "id": 1
  },
  "rowNumber": 2,
  "columnNumber": 3
}'


Get rack details
------------------------------------------
curl --location --request GET 'http://localhost:8080/rack/getAllRackDetails' \
--header 'Content-Type: application/json'

Inserting book data
=========================================

curl --location --request POST 'http://localhost:8080/book/create' \
--header 'Content-Type: application/json' \
--data-raw '{
  "rack": {
    "id": 1
  },
  "name": "hello1",
  "description": "helloooooo"
}'


Get book details
------------------------------------------
curl --location --request GET 'http://localhost:8080/book/getAllBookDetails' \
--header 'Content-Type: application/json' \
--data-raw '{
	  "AccountId" : "0017200000UpaMrAAJ",
	  "KycStatus" : "Approved",
	  "Comments" : "your documents verified successfully"
	}'