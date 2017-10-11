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
* Frontend stack: J2EE Servelet, JSP, CSS
* Backend stack: Spring Boot, Rabbit MQ (or other AMQP), MySQL (or other RDBMS), MongoDB (or other NoSQL) and Redis.

### Architecture diagram
![diagram](https://github.com/benjasy1993/DeliveryApp/images/diagram.jpg "Architecture Diagram")


## Members

* Yinong Wu (front-end)
* Leo Liu (back-end)
* Young Liu (back-end)
* Shaoqian Yang (back-end)