package top.zhuchl.admin.springboot_admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Select;
import top.zhuchl.admin.springboot_admin.DO.Person;

/**
 * @Author AlphaZcl
 * @Date 2021/11/9
 **/
public interface PersonMapper extends BaseMapper<Person> {

    @Select("SELECT id,name,email,age FROM PERSONINF WHERE age >= #{age}")
    IPage<Person> selectPageVo(IPage<?> page, Integer age);
}
