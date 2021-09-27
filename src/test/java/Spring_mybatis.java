import com.sql.bean.Role;
import com.sql.dao.RoleDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Spring_mybatis {
    private RoleDao roleDao;

    @Before
    public void before() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring_mybatis.xml");
        roleDao = (RoleDao) appContext.getBean("roleDao");
    }
    @Test
    public void fjkdfjs(){
        List<Role> list = roleDao.selectAllRole();
        list.forEach(System.out::println);
    }
}
