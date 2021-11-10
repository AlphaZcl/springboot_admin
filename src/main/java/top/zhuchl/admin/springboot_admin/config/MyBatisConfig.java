package top.zhuchl.admin.springboot_admin.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author AlphaZcl
 * @Date 2021/11/10
 **/
@Configuration
@MapperScan("top.zhuchl.admin.springboot_admin.mapper")
public class MyBatisConfig {


    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor  mybatisPlusInterceptor = new MybatisPlusInterceptor ();
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        //数据库类型
        paginationInnerInterceptor.setDbType(DbType.MYSQL);
        //设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInnerInterceptor.setOverflow(false);
        //页面最大条数
        paginationInnerInterceptor.setMaxLimit(30l);
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }
}
