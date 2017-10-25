package application.service;

import application.clients.MenuServiceClient;
import application.domain.Menu;
import application.domain.Restaurant;
import application.repository.MenuRedisRepository;
import application.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private MenuServiceClient client;

    @Override
    public void upload(List<Restaurant> restaurantList) {
        restaurantRepository.save(restaurantList);
    }

    @Override
    public Page<Restaurant> displayAll(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findOne(restaurantId);
        if (restaurant != null) {
            restaurant.setCurrentMenu(client.getLatestMenu(restaurantId));
        }
        return restaurant;
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        restaurantRepository.delete(restaurantId);
    }
}
