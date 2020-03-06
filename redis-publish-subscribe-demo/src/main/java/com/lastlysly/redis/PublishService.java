package com.lastlysly.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2020-03-05 16:12
 **/
@Component
public class PublishService {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    /**
     * 发布方法
     * @param channel 消息发布订阅 主题
     * @param message 消息信息
     */
    public void publish(String channel, Object message) {
        // 该方法封装的 connection.publish(rawChannel, rawMessage);
        stringRedisTemplate.convertAndSend(channel, message);
    }
}
