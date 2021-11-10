package top.zhuchl.admin.springboot_admin.VO;

import lombok.Data;
import top.zhuchl.admin.springboot_admin.DO.Person;

import java.util.List;

/**
 * @Author AlphaZcl
 * @Date 2021/11/10
 **/
@Data
public class PersonVO {

    private Long currentPage;

    private Long size;

    private Long total;

    private List<Person> personList;
}
