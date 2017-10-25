package application.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig {

    @Autowired
    private ServiceConfig serviceConfig;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public JedisConnectionFactory getJedisConnectionFactory() {
        JedisConnectionFactory factory =  new JedisConnectionFactory();
        factory.setHostName(serviceConfig.getRedisServer());
        factory.setPort(serviceConfig.getRedisPort());
        return factory;
    }

    @Bean
    public RedisTemplate getRedisTemplate() {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(getJedisConnectionFactory());
        return template;
    }
}
