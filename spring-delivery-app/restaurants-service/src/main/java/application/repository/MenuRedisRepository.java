package application.repository;

import application.domain.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class MenuRedisRepository {
    private static final String HASH_NAME = "MENU";
    private HashOperations hashOperations;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    private void init() {
        hashOperations = redisTemplate.opsForHash();
    }

    public Menu getMenu(Long restaurantId) {
        return (Menu) hashOperations.get(HASH_NAME, restaurantId);
    }

    public void putMenu(Long restaurantId, Menu menu) {
        hashOperations.put(HASH_NAME, restaurantId, menu);
    }

    public void purge() {
        hashOperations.keys(HASH_NAME).forEach(s -> {
            hashOperations.delete(HASH_NAME, s);
        });
    }

}
