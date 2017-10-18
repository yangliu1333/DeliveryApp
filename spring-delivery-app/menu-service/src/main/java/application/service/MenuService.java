package application.service;

import application.domain.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MenuService {

    void updateMenu(Menu menu);

    Menu getLatestMenu(Long restaurantId);

    Page<Menu> getHistoryMenuByRestaurant(Long restaurantId, Pageable pageable);
}
