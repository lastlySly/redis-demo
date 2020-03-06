package com.lastlysly.redis.config;

import com.lastlysly.redis.listener.MySubscribeListener1;
import com.lastlysly.redis.listener.MySubscribeListener2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2020-03-05 15:51
 **/
@Configuration
public class RedisConfig {

    /**
     * 注册StringRedisTemplate
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public StringRedisTemplate getRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }

    /**
     * 添加监听主题
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
        RedisMessageListenerContainer redisMessageListenerContainer = new RedisMessageListenerContainer();
        redisMessageListenerContainer.setConnectionFactory(redisConnectionFactory);
        // 添加订阅者监听类，数量不限.PatternTopic定义监听主题,这里监听test-topic主题
        redisMessageListenerContainer.addMessageListener(new MySubscribeListener1(), new PatternTopic("test-topic"));
        redisMessageListenerContainer.addMessageListener(new MySubscribeListener2(), new PatternTopic("my-topic"));
        return redisMessageListenerContainer;
    }
}
