package application.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceConfig {
    @Value("${spring.redis.host}")
    private String redisServer;

    @Value("${spring.redis.port}")
    private String redisPort;

    public String getRedisServer() {
        return redisServer;
    }

    public int getRedisPort() {
        return Integer.valueOf(redisPort);
    }
}
