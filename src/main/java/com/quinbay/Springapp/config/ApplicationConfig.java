package com.quinbay.Springapp.config;

import com.quinbay.Springapp.dto.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Jedis;

@Configuration
public class ApplicationConfig
{

        @Bean
        JedisConnectionFactory jedisConnectionFactory(){
            JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
            jedisConnectionFactory.setHostName("localhost");
            jedisConnectionFactory.setPort(6379);
            return jedisConnectionFactory;
        }

        @Bean
        public RedisTemplate<String , Student> redisTemplate(){
            RedisTemplate<String,Student> template = new RedisTemplate<String, Student>();
            template.setConnectionFactory(jedisConnectionFactory());
            template.setKeySerializer(new StringRedisSerializer());
            return template;
        }
    }


