import com.aop.service.WeaponService;
import com.aop.service.impl.JdkProxy;
import com.aop.service.impl.WeaponServiceImpl_proxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

/**
 * jdk任意代理类测试
 * jdk动态代理缺点：只能给实现接口的类中的任意方法加额外功能
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_change.xml")
public class JdkProxy_Test {
    @Autowired
    @Qualifier("weaponServiceImpl_proxy")
    private WeaponService weaponService;

    @Test
    public void jdk() {
        //获取任意代理类实例
        //第一个参数：目标对象的类加载器
        //第二个参数：目标对象实现的接口
        //第三个参数：重写目标方法的接口实例InvocationHandler
        ClassLoader classLoader = weaponService.getClass().getClassLoader();
        Class<?>[] interfaces = weaponService.getClass().getInterfaces();
        JdkProxy jdkProxy = new JdkProxy(weaponService);
        WeaponService weaponProxy = (WeaponService) Proxy.newProxyInstance(classLoader, interfaces, jdkProxy);
        //调用任意方法
        weaponProxy.changeWeapon(1, 1);

    }
}
