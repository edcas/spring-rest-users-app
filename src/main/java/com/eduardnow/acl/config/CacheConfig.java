package com.eduardnow.acl.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableCaching
public class CacheConfig {

    private static final String REDIS_SERVER = String.format("redis://%s:%d", "127.0.0.1", 6379);

    @Bean
    public CacheManager getCache(RedissonClient client) {
        Map<String, CacheConfig> config = new HashMap<>();
        config.put("users", new CacheConfig());
        config.put("username", new CacheConfig());

        return new RedissonSpringCacheManager(client);
    }

    @Bean(destroyMethod = "shutdown")
    public RedissonClient redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress(REDIS_SERVER);

        return Redisson.create(config);
    }

}
