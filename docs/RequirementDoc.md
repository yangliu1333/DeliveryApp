# Product Requirement Document
This document describes the purpose, functions, and use cases of the Delivery App.

## Product Overview
This app is intended to facilitate the meal ordering and pickup process on CMU campus. The app allows the delivering restaurants to post daily menus and track orders. Students are able to see the menu, pre-order, and comment on the meal.

#### Student user side:
* Place orders: users can see the menus posted by restaurants and order meals. 
* Manage orders: users can cancel orders or change quantities(based on availability). 
* Track delivery status: users can track the time when driver leaves for campus, the estimated arrival time, length of stay, and time of leaving.
* See amount of extra meals: users can check the amount of extra meals prepared by restaurants that were not picked-up.
* Reputation rating system: to prevent the abuse of the system, only users with a qualified reputation level can place orders(pending).

#### Restaurant and staff side:
* Post daily menus: restaurants can post and update the dishes offered on a given day and the amount of meals offered.
* Take orders: restaurants can keep track of the total amount of orders placed, cancelled, and picked up.
* Update activities: restaurants can post the location information, expected arriving time, and expected leaving time.
* Pickup verification: delivery personnel will scan the QR code of users picking up the meals and verify order information.
* Track extra meals: when extra meals were picked up, the amount of extra meals prepared will be reduced. The delivery personnel will be alerted when no extra meals were available for users haven't ordered.


## Use Case:
| Number | 1  |
|:----------------|:----|
| Name   | User log in  |
| Description     | User log in with WeChat authentication (or other authentication methods). After logging in, the user will be directed to the "browse menu" page. |

| Number | 2  |
|:----------------|:----|
| Name   | Place order  |
| Description     | When a user has decided to order a meal, the user can place order on the "browse menu" page, or on the "menu detail" page. |

| Number | 3  |
|:----------------|:----|
| Name   | Check orders  |
| Description     | When a user would like to see current orders and/or previous orders, the user will see order details from "My order" page. |

| Number | 4  |
|:----------------|:----|
| Name   | Edit order  |
| Description     | When a user would like to change the quantity of order prior to the deadline, the user will be able to edit the pick-up location, quantity, or cancel the order in "My order". |

| Number | 5  |
|:----------------|:----|
| Name   | Browse menu  |
| Description     | A user will see all restaurants and their menus for today. The can see the availability of any meal (e.g. plenty, low, sold out). |

| Number | 6  |
|:----------------|:----|
| Name   | Cehck menu details  |
| Description     | A user can see menu details including picture (optional) and comments by clicking on a menu on when browsing the menu. |

| Number | 7  |
|:----------------|:----|
| Name   | Pick up orders  |
| Description     | When a user goes to pick up the order, the user will scan the QR code of the restaurant, and confirm pick up on the next screen. |

| Number | 8  |
|:----------------|:----|
| Name   | Leave comments  |
| Description     | When a user has picked up the order, the user will be prompted to leave comments on the confirmation page for the menu. |

#### Rules:
* A user can place one or more orders per meal period.
* Comments given to a meal will be tagged with each individual dish included in the meal. 
* When a user has NOT picked up meals for too many times (e.g. 10) within a period of time, the system will ban this user from placing orders. 
* The amount of meals left will be both updated automatically when pickups are confirmed and manually updated by restaurant staff.

