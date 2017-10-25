package application.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Slf4j
@Component
public class MessagePublisher {

    @Autowired
    private MessageChannel output;

    public void publishMenuChange(String action, Long restaurantId, Long menuId) {
        MenuChangeModel change = new MenuChangeModel(
                MenuChangeModel.class.getTypeName(),
                restaurantId,
                menuId,
                action
        );
        output.send(MessageBuilder.withPayload(change).build());
        log.info("publish menu change: menuId: " + menuId + " restaurantId: " + restaurantId);
    }

}
