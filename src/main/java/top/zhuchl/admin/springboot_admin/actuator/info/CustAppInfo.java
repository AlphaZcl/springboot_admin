package top.zhuchl.admin.springboot_admin.actuator.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author AlphaZcl
 * @Date 2021/11/15
 **/
@Component
public class CustAppInfo implements InfoContributor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Object> detailInfos = new HashMap<>();
        detailInfos.put("signCount",redisTemplate.opsForValue().get("/world/signIn"));
        detailInfos.put("zcl",redisTemplate.opsForValue().get("zcl"));
        builder.withDetails(detailInfos);
    }
}
