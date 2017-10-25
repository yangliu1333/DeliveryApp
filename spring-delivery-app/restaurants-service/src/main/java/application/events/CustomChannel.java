package application.events;


import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface CustomChannel {

    @Input("inboundMenuChange")
    SubscribableChannel menu();
}
