import com.psi.bean.Role;
import com.psi.bean.Weapon;
import com.psi.dao.RoleDao;
import com.psi.util.MyApplicationContext;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    RoleDao roleDao;

    @Test
    public void dfdf() {
        //初始化spring的核心容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringCfg.xml");
        roleDao = (RoleDao) applicationContext.getBean("roleDao");
        System.out.println(roleDao);
        Role role = roleDao.getRoleByRid(1);
        //单例模式下，会获取到一模一样的对象，多例模式下不一样
        RoleDao roleDao2 = (RoleDao) applicationContext.getBean("roleDao");
        System.out.println(roleDao2);
    }

    /**
     * 自定义容器获取实例对象
     */
    @Test
    public void sgsg() {
        MyApplicationContext myApplicationContext = new MyApplicationContext("Bean");
        roleDao = (RoleDao) myApplicationContext.getBean("roleDao");
        Role role = roleDao.getRoleByRid(1);
    }

    /**
     * 多种创建实例方法
     */
    @Test
    public void sggs() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("SpringCfg.xml");
        //普通工厂方法创建实例
        RoleDao roleDao1=(RoleDao)applicationContext.getBean("roleDao1");
        //静态工厂哪个方法创建实例
        RoleDao roleDao2=(RoleDao)applicationContext.getBean("roleDao2");
        //指定工厂方法创建的实例
        RoleDao roleDao3=(RoleDao)applicationContext.getBean("roleDao3");
        roleDao1.getRoleByRid(1);
        roleDao2.getRoleByRid(1);
        roleDao3.getRoleByRid(1);
    }

    /**
     * springDI
     * setter依赖注入
     */
    @Test
    public void daw(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("SpringCfg.xml");
        Role role=(Role)applicationContext.getBean("role1");
        System.out.println(role);
    }
    /**
     * 构造注入
     */
    @Test
    public void sgls(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("SpringCfg.xml");
        Role role=(Role)applicationContext.getBean("role2");
        System.out.println(role);
    }
}
