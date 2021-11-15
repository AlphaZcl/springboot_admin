package top.zhuchl.admin.springboot_admin.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author AlphaZcl
 * @Date 2021/11/15
 **/
@Component
public class MyCustHealthIndicator extends AbstractHealthIndicator {

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String, Object> details = new HashMap<>();
        if(1==2){
            builder.status(Status.UP);
            details.put("RspCod","000000");
            details.put("RspMsg","检测成功");
            details.put("count",5);
        }else{
            builder.status(Status.OUT_OF_SERVICE);
            details.put("RspCod","999999");
            details.put("RspMsg","连接超时");
        }

        builder.withDetails(details);
    }
}
