# Delivery Web App Design Doc

## Functionality
* Main dashboard can show restaurants and menu.
* User log-in and sign-up (through third party accounts).
* User can manage their orders: place order, cancel order, see order detail.
* User can track his/her order in real time (location update in real time).
* Optional: User can add each other as friend. In friends dashboard, they can see their friends' update and comment on these posts.
* Optional: User can order together with friend, support split payment and order sharing.
* Optional: User can comment on the order and share the post to the friends dashboard.

## Architecture

### Technology stack
* Frontend stack: J2EE Servelet, JSP, Bootstrap
* Backend stack: Spring Boot, Spring Cloud, Spring Data, Rabbit MQ (or other AMQP), MySQL (or other RDBMS), MongoDB (or other NoSQL), Docker, and Redis.

- Spring Boot will be serve as stand-alone REST microservice.
- Spring Cloud will be used for registration and discovery for REST microservices.
- Spring Data will replace traditional ORM to serve as lightweight database access layer.
- Redis serve as a cache layer for popular data in RDBMS to provide quick access to restaurant listing and menu items listing.
- All microservices, databases, cache store and spring cloud intance will be dockerized.


### Architecture diagram
![diagram](https://github.com/benjasy1993/DeliveryApp/blob/master/images/diagram.jpg "Architecture Diagram")


## Members

* Yinong Wu (front-end)
* Leo Liu (back-end)
* Young Liu (back-end)
* Shaoqian Yang (back-end)