import com.aop.service.WeaponService;
import com.aop.service.impl.CglibProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * cglib动态代理给任意类加额外功能
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_change.xml")
public class Spring_Cglib_Test {
    @Autowired
    @Qualifier("weaponServiceImpl_proxy")
    WeaponService weaponService;

    @Test
    public void cglib() {
        //创建cglib工厂
        Enhancer enhancer = new Enhancer();
        //设置代理的目标对象
        enhancer.setSuperclass(weaponService.getClass());
        //设置任意代理类实例
        enhancer.setCallback(new CglibProxy(weaponService));
        //获取weaponService代理类实例
        WeaponService weaponServiceProxy = (WeaponService) enhancer.create();
        //调用任意方法
        weaponServiceProxy.changeWeapon(1, 1);
    }
}
