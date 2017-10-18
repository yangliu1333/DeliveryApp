package application.config;

import org.springframework.web.client.RestTemplate;

//@Configuration
public class ApplicationConfig {
//    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
