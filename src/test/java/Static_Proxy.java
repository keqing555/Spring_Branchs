import com.aop.service.WeaponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 在不改变源代码的情况下添加事务
 * 新增静态代理类
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring_change.xml")
public class Static_Proxy {
    @Autowired
    @Qualifier("weaponServiceImpl_proxy")
    private WeaponService proxyWeaponService;

    /**
     * 还不能实现回滚
     */
    @Test
    public void sfdd() {
        proxyWeaponService.changeWeapon(1, 1);
    }
}
