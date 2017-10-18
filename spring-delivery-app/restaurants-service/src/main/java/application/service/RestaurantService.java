package application.service;

import application.domain.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {

    void upload(List<Restaurant> restaurantList);

    Page<Restaurant> displayAll(Pageable pageable);

    Restaurant getRestaurantById(Long restaurantId);

    void createRestaurant(Restaurant restaurant);

    void deleteRestaurant(Long restaurantId);
}
