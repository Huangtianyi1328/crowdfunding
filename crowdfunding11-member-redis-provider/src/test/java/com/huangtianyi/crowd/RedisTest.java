package com.huangtianyi.crowd;

import com.huangtianyi.crowd.handler.RedisHandler;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    // private Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Test
    public void testSet() {

        ValueOperations<String, String> operations = redisTemplate.opsForValue();

        //operations.set("REDIS_CODE_PREFIX_13138338882", "1111");
        redisTemplate.delete("REDIS_CODE_PREFIX_13138338882");
    }


}