# Delivery Web App

<!-- ## How to run web interface
* install maven that suits your platform
* `cd DeliveryApp/spring-delivery-app/web-app`
* `mvn clean spring-boot:run`
 -->
## Functionality

#### User:
* Place orders: users can see the menus posted by restaurants and order meals. 
* Manage orders: users can cancel orders or change quantities(based on availability). 
* Track delivery status: users can track the time when driver leaves for campus, the estimated arrival time, length of stay, and time of leaving.
* See amount of extra meals: users can check the amount of extra meals prepared by restaurants that were not picked-up.
* Reputation rating system: to prevent the abuse of the system, only users with a qualified reputation level can place orders(pending).

#### Restaurant:
* Post daily menus: restaurants can post and update the dishes offered on a given day and the amount of meals offered.
* Take orders: restaurants can keep track of the total amount of orders placed, cancelled, and picked up.
* Update activities: restaurants can post the location information, expected arriving time, and expected leaving time.
* Pickup verification: delivery personnel will scan the QR code of users picking up the meals and verify order information.
* Track extra meals: when extra meals were picked up, the amount of extra meals prepared will be reduced. The delivery personnel will be alerted when no extra meals were available for users haven't ordered.

## Avalable Services APIs
#### Restaurant Service
1. list restaurants with their basic information
2. get a restaurant detailed infomation including its menu
3. bulk upload restaurants (for testing)
4. delete a restaurant

#### Menu Service:
1. upload a menu with existing dishes or newly-defined dishes and they have the option to set this menu as the current menu or not. If it's set to current menu, restaurant service will call menu service to get the latest menu
2. set a historical menu to be the current menu
3. list historical menus with restaurant id
4. delete a menu with their id
5. builk upload menus (for testing)

## Pending Services
#### Config Service
* use git repository to store all config file
* available for other service to query configuration\

#### Eureka Server
* Service registration and discovery

#### Auth Service
* use OAuth2 for authentication and authorization
* define available resources for each type of user

## Architecture

### Technology stack
* Frontend stack: Spring MVC, JSP/thymleaf, Bootstrap/Matirialize.
* Backend stack: Spring Boot, Spring Cloud, Spring Data, Rabbit MQ (or Kafka), MySQL (or other RDBMS), MongoDB (or other NoSQL), Docker, and Redis.

- Spring Boot will be served as stand-alone REST microservice.
- Spring Cloud will be used for registration and discovery for REST microservices.
- Spring Data will replace traditional ORM to serve as lightweight database access layer.
- Redis serve as a cache layer for popular data in RDBMS to provide quick access to restaurant listing and menu items listing.
- RabbitMQ provide two message brocker paradigms: P2P channel is used for competing message consumers to consume which is suitable for order processing while Pub/Sub channel allows all message subscribers to handle messages which is suitable for location updating.
- All microservices, databases, cache store and spring cloud intance will be dockerized.


### Architecture diagram
![diagram](https://github.com/benjasy1993/DeliveryApp/blob/master/images/diagram.jpg "Architecture Diagram")


## Members

* Leo Liu 
* Lidi Zheng 
* Young Liu 
* Shaoqian Yang 

## References

* [Bootstrap templates](https://startbootstrap.com/template-categories/all/)
* [Spring Boot tutorial](https://spring.io/guides/gs/spring-boot/)
* [Dependency management tutorial](https://maven.apache.org/guides/introduction/introduction-to-dependency-mechanism.html)
* [Build web application with Spring Boot](http://www.springboottutorial.com/creating-web-application-with-spring-boot)
* [Write integration tests for Spring Boot application](http://www.springboottutorial.com/integration-testing-for-spring-boot-rest-services)
* [Spring Security](http://www.baeldung.com/security-spring)

## How to create your own microservice
### Option 1
* use intellij idea as IDE
* import project
* choose `DeliveryApp/spring-delivery-app`
* choose `Create project from existing model`
* `next` all the way down until you open the project
* create your child module like this
![submodule](https://github.com/benjasy1993/DeliveryApp/blob/master/images/submodule.jpg "create a sub module")

### Option 2
* `cd DeliveryApp/spring-delivery-app`
* create your maven project under this folder
* add such content into your project pom file
```
<parent>
        <artifactId>spring-delivery-app</artifactId>
        <groupId>com.delivery.app</groupId>
        <version>1.0-SNAPSHOT</version>
</parent>
```
* add such content into pom file in the parent project (spring-delivery-app)
```
<modules>
        <module>your-own-microservice</module>
</modules>
```
* If you have any problem, follow the content-service module example

