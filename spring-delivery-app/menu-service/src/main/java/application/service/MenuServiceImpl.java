package application.service;

import application.domain.Menu;
import application.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public void updateMenu(Menu menu) {
        repository.save(menu);
    }

    @Override
    public void saveMenus(List<Menu> menus) {
        repository.save(menus);
    }

    @Override
    public Menu getLatestMenu(Long restaurantId) {
        return repository.findTopByRestaurantIdOrderByTimeOfDayDesc(restaurantId);
    }

    @Override
    public Page<Menu> getHistoryMenuByRestaurant(Long restaurantId, Pageable pageable) {
        return repository.findMenusByRestaurantId(restaurantId, pageable);
    }
}
