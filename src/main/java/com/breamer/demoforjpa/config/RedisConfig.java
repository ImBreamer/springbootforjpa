package com.breamer.demoforjpa.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置
 * @author breamer
 * @date 2018/7/26 10:57
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    private final JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    public RedisConfig(JedisConnectionFactory jedisConnectionFactory) {
        this.jedisConnectionFactory = jedisConnectionFactory;
    }

    @Bean
    @Override
    public CacheManager cacheManager() {
        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(jedisConnectionFactory).build();
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return (target, method, params) -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(target.getClass().getName());
            stringBuilder.append(":");
            stringBuilder.append(method.getName());
            for (Object obj : params) {
                stringBuilder.append(":");
                stringBuilder.append(String.valueOf(obj));
            }
            return String.valueOf(stringBuilder);
        };
    }

   @Bean
   public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory jedisConnectionFactory){
       //设置序列化
       @SuppressWarnings("unchecked")
       Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
       ObjectMapper om = new ObjectMapper();
       om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
       om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
       jackson2JsonRedisSerializer.setObjectMapper(om);
       // 配置redisTemplate
       RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
       redisTemplate.setConnectionFactory(jedisConnectionFactory);
       RedisSerializer stringSerializer = new StringRedisSerializer();
       // key序列化
       redisTemplate.setKeySerializer(stringSerializer);
       // value序列化
       redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
       // Hash key序列化
       redisTemplate.setHashKeySerializer(stringSerializer);
       // Hash value序列化
       redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
       redisTemplate.afterPropertiesSet();
       return redisTemplate;
   }
}
