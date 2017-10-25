package application.events;

import application.clients.MenuServiceClient;
import application.repository.MenuRedisRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

@Slf4j
@EnableBinding(Sink.class)
public class MenuChangeHandler {

    private static final String SET_CURRENT_ACTION = "SET_CURRENT";

    @Autowired
    private MenuServiceClient client;

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void menuChangeHandler(MenuChangeModel change) {
        if (SET_CURRENT_ACTION.equals(change.getAction())) {
            log.info("handling a menu change: " + change.getAction());
            client.updateMenuInRedis(change.getRestaurantId(), change.getMenuId());
        }
    }
}
