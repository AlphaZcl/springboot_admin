package top.zhuchl.admin.springboot_admin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @Author AlphaZcl
 * @Date 2021/11/15
 **/
@Endpoint(id="myservice")
@Component
public class MyServiceEndPoint {

    @ReadOperation
    public Map<?,?> getDockerInfo(){
        return Collections.singletonMap("docker Info","docker started...");
    }

    @WriteOperation
    public void stop(){

    }

}
