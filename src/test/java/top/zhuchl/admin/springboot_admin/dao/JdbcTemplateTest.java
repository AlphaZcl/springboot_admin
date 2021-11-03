package top.zhuchl.admin.springboot_admin.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import top.zhuchl.admin.springboot_admin.DO.UserInfo;
import top.zhuchl.admin.springboot_admin.SpringbootAdminApplicationTests;

/**
 * @Author AlphaZcl
 * @Date 2021/11/3
 **/
@Slf4j
public class JdbcTemplateTest extends SpringbootAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Test
    public void testConnect(){
        String qsql = "select count(*) from user_info where user_acco = '00001'";
        int count = jdbcTemplate.queryForObject(qsql,Integer.class);
        if(count<1){
            UserInfo userInfo = new UserInfo(0,1,"00001","test","11111111111","zclys06@163.com");
            String sql = "insert into user_info(address_id,user_acco,user_name,phone_no,email) values(?,?,?,?,?)";
            Object[] args = {userInfo.getAddressId(),userInfo.getUserAcco(),userInfo.getUserName(),userInfo.getPhoneNo(),userInfo.getEmail()};
            jdbcTemplate.update(sql,args);
        }
        log.info("count:{}",count);
    }
}
