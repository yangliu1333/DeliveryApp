package application.service;

import application.clients.MenuServiceClient;
import application.domain.Restaurant;
import application.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private MenuServiceClient client;

    @Override
    public void upload(List<Restaurant> restaurantList) {
        repository.save(restaurantList);
    }

    @Override
    public Page<Restaurant> displayAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        Restaurant restaurant = repository.findOne(restaurantId);
        restaurant.setCurrentMenu(client.getMenu(restaurant.getMenuId()));
        return restaurant;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        repository.delete(restaurantId);
    }
}
