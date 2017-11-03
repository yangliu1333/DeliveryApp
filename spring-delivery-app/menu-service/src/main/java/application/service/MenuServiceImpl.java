package application.service;

import application.domain.Dish;
import application.domain.Menu;
import application.repository.DishRepository;
import application.repository.MenuRepository;
import application.events.MessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private MessagePublisher messagePublisher;

    @Override
    public void saveMenu(Menu menu) {
        menuRepository.save(menu);
        messagePublisher.publishMenuChange("SET_CURRENT", menu.getRestaurantId(), menu.getId());
    }

    @Override
    public void saveMenusBulk(List<Menu> menus) {
        menuRepository.save(menus);
        for (Menu menu : menus) {
            //ensure that only one menu will be set current
            if (menu.getSetCurrentMenu()) {
                messagePublisher.publishMenuChange("SET_CURRENT", menu.getRestaurantId(), menu.getId());
            }

        }
    }

    @Override
    public Menu getLatestMenu(Long restaurantId) {
        return menuRepository.findTopByRestaurantIdOrderByTimeOfDayDesc(restaurantId);
    }

    @Override
    public Page<Menu> getHistoryMenuByRestaurant(Long restaurantId, Pageable pageable) {
        return menuRepository.findMenusByRestaurantId(restaurantId, pageable);
    }

    @Override
    public Menu getMenu(Long menuId) {

        return menuRepository.findOne(menuId);
    }

    @Override
    public void deleteMenu(Long menuId) {
        menuRepository.delete(menuId);
    }

    @Override
    public Page<Dish> getDishes(Long restaurantId, Pageable pageable) {
        return dishRepository.findDishesByRestaurantId(restaurantId, pageable);
    }
}
