package application;

import application.config.ServiceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.client.RestTemplate;

@EnableBinding(Sink.class)
@SpringBootApplication
public class RestaurantServiceApplication {
//    @Autowired
//    private ServiceConfig serviceConfig;
//
//    @Bean
//    public JedisConnectionFactory getJedisConnectionFactory() {
//        JedisConnectionFactory factory =  new JedisConnectionFactory();
//        factory.setHostName(serviceConfig.getRedisServer());
//        factory.setPort(serviceConfig.getRedisPort());
//        return factory;
//    }
//
//    @Bean
//    public RedisTemplate getRedisTemplate() {
//        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//        template.setConnectionFactory(getJedisConnectionFactory());
//        return template;
//    }
//
//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }

    public static void main(String[] args) {
        SpringApplication.run(RestaurantServiceApplication.class, args);
    }


}
