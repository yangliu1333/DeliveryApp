package application.service;

import application.domain.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuService {

    void updateMenu(Menu menu);

    void saveMenus(List<Menu> menus);

    Menu getLatestMenu(Long restaurantId);

    Page<Menu> getHistoryMenuByRestaurant(Long restaurantId, Pageable pageable);
}
