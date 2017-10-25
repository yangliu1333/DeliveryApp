package application.clients;

import application.domain.Menu;
import application.repository.MenuRedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MenuServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private MenuRedisRepository repository;

    public Menu getLatestMenu(Long restaurantId) {

        Menu menu = repository.getMenu(restaurantId);
//        if (menu == null) {
//            menu = getLatestMenuRest(restaurantId);
//            repository.putMenu(restaurantId, menu);
//        }
        return menu;
    }

    private Menu getLatestMenuRest(Long restaurantId) {
        ResponseEntity<Menu> entity = restTemplate.exchange(
                "http://localhost:8002/menu/{restaurantId}/latest",
                HttpMethod.GET,
                null,
                Menu.class,
                restaurantId);
        return entity.getBody();
    }

    private Menu getMenuByMenuIdRest(Long menuId) {
        ResponseEntity<Menu> entity = restTemplate.exchange(
                "http://localhost:8002/menus/{menuId}",
                HttpMethod.GET,
                null,
                Menu.class,
                menuId);
        return entity.getBody();
    }

    public void updateMenuInRedis(Long restaurantId, Long menuId) {
        repository.putMenu(restaurantId, getMenuByMenuIdRest(menuId));
    }
}
