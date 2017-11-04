## Available Services

#### Restaurant Service
1. list Restaurants with their basic information
2. get a restaurant detailed infomation including its menu
3. bulk upload restaurants (for testing)
4. delete a restaurant

#### Menu Service:
1. upload a menu with existing dishes or newly-defined dishes and they have the option to set this menu as the current menu or not. If it's set to current menu, restaurant service will call menu service to get the latest menu
2. set a historical menu to be the current menu
3. list historical menus with restaurant id
4. delete a menu with their id
5. bulk upload menus (for testing)

## Pending Services

#### Config Service
* use git repository to store all config file
* available for other service to query configuration\

#### Eureka Server
* Service registration and discovery

#### Auth Service
* use OAuth2 for authentication and authorization
* define available resources for each type of user