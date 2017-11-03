package application.service;

import application.domain.Dish;
import application.domain.Menu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MenuService {

    void saveMenu(Menu menu);

    void saveMenusBulk(List<Menu> menus);

    Menu getLatestMenu(Long restaurantId);

    Page<Menu> getHistoryMenuByRestaurant(Long restaurantId, Pageable pageable);

    Menu getMenu(Long menuId);

    void deleteMenu(Long menuId);

    Page<Dish> getDishes(Long restaurantId, Pageable pageable);
}
