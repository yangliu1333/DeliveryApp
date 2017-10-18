package application.rest;

import application.domain.Restaurant;
import application.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private static final String DEFAULT_PAGE = "0";
    private static final String DEFAULT_SIZE = "10";

    @Autowired
    private RestaurantService service;

    //for developers to upload restaurants in batch
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public void uploadRestaurants(@RequestBody List<Restaurant> restaurantList) {
        service.upload(restaurantList);
    }

    //for restaurant vendor to create a new restaurant
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createRestaurant(@RequestBody Restaurant restaurant) {
        service.createRestaurant(restaurant);
    }

    //for front-end to display all restaurants
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Page<Restaurant> display(@RequestParam(required = false, defaultValue = DEFAULT_PAGE) int page,
                                    @RequestParam(required = false, defaultValue = DEFAULT_SIZE) int size) {
        return service.displayAll(new PageRequest(page, size));
    }

    //for front-end to display a single restaurant detail
    @RequestMapping(value = "/{restaurantId}", method = RequestMethod.GET)
    public Restaurant getRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        return service.getRestaurantById(restaurantId);
    }

    @RequestMapping(value = "delete/{restaurantId}", method = RequestMethod.DELETE)
    public void deleteRestaurant(@PathVariable("restaurantId") Long restaurantId) {
        service.deleteRestaurant(restaurantId);
    }

}
