package application.service;

import application.domain.Menu;
import application.repository.MenuRepository;
import application.events.MessagePublisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Autowired
    private MessagePublisher messagePublisher;

    @Override
    public void saveMenu(Menu menu) {
        repository.save(menu);
        messagePublisher.publishMenuChange("SET_CURRENT", menu.getRestaurantId(), menu.getId());
    }

    @Override
    public void saveMenusBulk(List<Menu> menus) {
        repository.save(menus);
        for (Menu menu : menus) {
            //ensure that only one menu will be set current
            if (menu.getSetCurrentMenu()) {
                messagePublisher.publishMenuChange("SET_CURRENT", menu.getRestaurantId(), menu.getId());
            }

        }
    }

    @Override
    public Menu getLatestMenu(Long restaurantId) {
        return repository.findTopByRestaurantIdOrderByTimeOfDayDesc(restaurantId);
    }

    @Override
    public Page<Menu> getHistoryMenuByRestaurant(Long restaurantId, Pageable pageable) {
        return repository.findMenusByRestaurantId(restaurantId, pageable);
    }

    @Override
    public Menu getMenu(Long menuId) {

        return repository.findOne(menuId);
    }
}
