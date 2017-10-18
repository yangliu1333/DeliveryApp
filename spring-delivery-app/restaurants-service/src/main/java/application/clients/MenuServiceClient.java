package application.clients;

import application.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MenuServiceClient {

    @Autowired
    private RestTemplate restTemplate;

    public Menu getMenu(String menuId) {
        ResponseEntity<Menu> entity = restTemplate.exchange(
                "http://localhost:8002/menu/{menuId}",
                HttpMethod.GET,
                null,
                Menu.class,
                menuId);
        return entity.getBody();
    }

}
