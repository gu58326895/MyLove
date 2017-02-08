package com.darcytech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by guxiaoli on 2017/2/8.
 */
@Configuration
public class RedisConfig {

    @Autowired
    private RedisProperties redisProperties;

    /*private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        RedisProperties.Pool pool = redisProperties.getPool();
        poolConfig.setMaxTotal(pool.getMaxActive());
        poolConfig.setMaxIdle(pool.getMaxIdle());
        poolConfig.setMinIdle(pool.getMinIdle());
        poolConfig.setMaxWaitMillis(pool.getMaxWait());
        return poolConfig;
    }*/

    @Bean
    public RedisConnectionFactory connectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisProperties.getHost());
        factory.setDatabase(redisProperties.getDatabase());
        factory.setPort(redisProperties.getPort());
        factory.setDatabase(redisProperties.getDatabase());
        factory.setPassword(redisProperties.getPassword());
        factory.setTimeout(redisProperties.getTimeout());
       // factory.setPoolConfig(jedisPoolConfig());
        return factory;
    }

    @Bean
    public StringRedisTemplate redisTemplate() {
        return new StringRedisTemplate(connectionFactory());
    }


}
