# Taxi Service
 The goal of this project is to create a taxi service. The project implements driver authentification with different functionality. To use all features you need to create new driver and log in, after that you can:
 - create new car/manufacturer
 - display all drivers/cars/cars by driver/manufacturers
 - add driver to car.

## Implementation details and technologies
Project based on 3-layer architecture:
- Presentation layer (controllers)
- Application layer (services)
- Data access layer (DAO)

### Technologies
* Apache Tomcat - version 9.0.46
* MySQL - version 8.0.22
* JDBC
* Servlet
* JSTL
* JSP
* HTML, CSS

## Setup
1. Configure Apache Tomcat
 * Use taxi_service:war exploded
 * Leave @Application contex@ : "/" 
2. Install MySQL and MySQL Workbench
3. Then in MySQL Workbench create and open new connection with your credentials or use the existing one, open src/main/resources/init_db.sql, File->Open SQL script and execute this script Query->Execute.
4. In the /util/ConnectionUtil.java class change the USERNAME (root) and PASSWORD (1111) properties to the ones you specified when installing MySQL:
( dbProperties.put ("user", "root");
dbProperties.put ("password", "1111"); )
5. After starting the project, click on "Create a new Driver" to add the first driver.
