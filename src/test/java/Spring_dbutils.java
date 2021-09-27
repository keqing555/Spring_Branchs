import com.sql.bean.Role;
import com.sql.dao.RoleDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

public class Spring_dbutils {
    private RoleDao roleDao;

    @Before
    public void before() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_dbutils.xml");
        roleDao = (RoleDao) applicationContext.getBean("roleDao");
    }
    @Test
    public void sfdsf(){
        Role role = roleDao.selectRoleByRid(1);
        System.out.println(role);
    }
    @Test
    public void dfdgf(){
        List<Role> list=roleDao.selectAllRole();
        list.forEach(System.out::println);
    }
}
