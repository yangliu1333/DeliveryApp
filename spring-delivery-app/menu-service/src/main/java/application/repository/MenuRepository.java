package application.repository;

import application.domain.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MenuRepository extends JpaRepository<Menu, Long>{


    Menu findTopByRestaurantIdOrderByTimeOfDayDesc(Long restaurantId);

    Page<Menu> findMenusByRestaurantId(Long restaurantId, Pageable pageable);

}
