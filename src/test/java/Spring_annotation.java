import com.sql.bean.Role;
import com.sql.config.MySpringConfig;
import com.sql.service.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MySpringConfig.class})
public class Spring_annotation {
    //注解在成员变量位置上，作用给成员变量设置初始值（根据类型从容器中取出实例注入到属性值中），
    // 要求自动注入实例时，容器中该类型的实例只能有一个；
    @Autowired
    private RoleService roleService;

    @Test
    public void dsgs() {
        Role role = roleService.selectRoleByRid(1);
        System.out.println(role);
    }
}
