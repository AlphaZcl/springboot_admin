package top.zhuchl.admin.springboot_admin.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import top.zhuchl.admin.springboot_admin.SpringbootAdminApplicationTests;

/**
 * @Author AlphaZcl
 * @Date 2021/11/11
 **/
@Slf4j
public class RedisTemplateTest extends SpringbootAdminApplicationTests {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Test
    public void testRedisConnect(){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String factory = redisTemplate.getConnectionFactory().getClass().getName();
        log.info("RedisConnectionFactory : {}",factory);
        opsForValue.set("hello","world");
        String s = opsForValue.get("hello");
        opsForValue.set("zcl","sss");
        log.info(s);
    }
}
