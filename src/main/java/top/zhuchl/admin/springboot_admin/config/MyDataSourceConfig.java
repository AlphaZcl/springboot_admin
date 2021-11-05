package top.zhuchl.admin.springboot_admin.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @Author AlphaZcl
 * @Date 2021/11/3
 **/
@Configuration
public class MyDataSourceConfig {

    /**
     * 自动绑定配置文件属性
     * @return
     */
    @ConfigurationProperties("spring.datasource")//绑定
    @Bean
    public DataSource dataSource() throws SQLException {

        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl("jdbc:mysql://172.16.116.131:3306/dev01mysql01?setSSl=false");
        druidDataSource.setFilters("stat,wall,slf4j");


        return druidDataSource;
    }

    /**
     * druid的监控页
     *
     * @return
     */
    @Bean("statView")
    public ServletRegistrationBean<StatViewServlet> myServlet(){
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean =
                new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        return servletRegistrationBean;
    }

    @Bean("webStatFilter")
    public FilterRegistrationBean<WebStatFilter> myFilter(){
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean =
                new FilterRegistrationBean<>(new WebStatFilter());
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
