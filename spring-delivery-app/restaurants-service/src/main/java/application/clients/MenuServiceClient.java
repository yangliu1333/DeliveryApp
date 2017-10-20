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

    public Menu getLatestMenu(Long restaurantId) {
        ResponseEntity<Menu> entity = restTemplate.exchange(
                "http://localhost:8002/menu/{restaurantId}",
                HttpMethod.GET,
                null,
                Menu.class,
                restaurantId);
        return entity.getBody();
    }

}
