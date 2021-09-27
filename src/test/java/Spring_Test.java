import com.sql.bean.Role;
import com.sql.dao.RoleDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//使用spring——test运行
@RunWith(SpringJUnit4ClassRunner.class)
//指定spring配置文件
@ContextConfiguration(locations = "classpath:spring_jdbc.xml")
public class Spring_Test {
    @Autowired
    private RoleDao roleDao;

    @Test
    public void dfdf() {
        List<Role> list = roleDao.selectAllRole();
        list.forEach(System.out::println);
    }
}
