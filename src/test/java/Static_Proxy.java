import com.aop.service.WeaponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 新增静态代理类Proxy
 * 在不改变源代码的情况下添加事务
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring_change.xml")
public class Static_Proxy {
    @Autowired
    @Qualifier("proxyWeaponServiceImpl")
    private WeaponService proxyWeaponService;

    /**
     * 还不能实现回滚
     * 可以回滚了，原因在于WeaponService的实例要注入静态代理类的实现类，
     * 而之前错误的注入了被代理类的实现类
     */
    @Test
    public void sfdd() {
        proxyWeaponService.changeWeapon(1, 1);
    }
}
