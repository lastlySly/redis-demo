package com.lastlysly.redis.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

/**
 * @author lastlySly
 * @GitHub https://github.com/lastlySly
 * @create 2020-03-05 16:10
 **/
public class MySubscribeListener2 implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        // 缓存消息是序列化的，需要反序列化。然而new String()可以反序列化，但静态方法valueOf()不可以
        System.out.println(new String(bytes) + "主题发布222：" + new String(message.getBody()));
    }
}
