package top.zhuchl.admin.springboot_admin.actuator.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author AlphaZcl
 * @Date 2021/11/15
 **/
@Component
public class MyComHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        int errCode = check();
        Map<String, Object> details = new HashMap<>();
        Health health = null;
        if(errCode != 0){
            details.put("RspCod","999999");
            details.put("RspMsg","连接超时");
            health= Health.outOfService().withDetails(details).build();
        }else{
            details.put("RspCod","000000");
            details.put("RspMsg","检测成功");
            details.put("count",5);
            health = Health.up().withDetails(details).build();
        }
        return health;
    }

    /**
     * 健康状态检查
     * @return
     */
    private int check() {
        return 0;
    }
}
