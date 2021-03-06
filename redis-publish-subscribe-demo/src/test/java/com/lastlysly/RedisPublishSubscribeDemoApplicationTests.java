package com.lastlysly;

import com.lastlysly.redis.PublishService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
class RedisPublishSubscribeDemoApplicationTests {

    @Autowired
    private PublishService service;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            service.publish("test-topic", "hello~~~" + i);
            service.publish("my-topic", "my-topic~~~" + i);
        }
    }

}
