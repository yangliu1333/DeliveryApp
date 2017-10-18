package application.repository;

import application.domain.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Long>{

    Menu findDistinctByRestaurantIdOrderByDateAscTimeOfDayAsc(Long restaurantId);

    Page<Menu> findMenusByRestaurantId(Long restaurantId, Pageable pageable);
}
