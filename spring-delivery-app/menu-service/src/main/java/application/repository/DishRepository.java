package application.repository;

import application.domain.Dish;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
    Page<Dish> findDishesByRestaurantId(Long restaurantId, Pageable pageable);
}
