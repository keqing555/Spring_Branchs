import com.aop.service.WeaponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_change.xml")
public class change {
    @Autowired  //给成员变量设置初始值
    @Qualifier("weaponServiceImpl")     //搭配Autowired使用，通过指定实例的别名来注入实例
    private WeaponService weaponService;

    @Autowired
    @Qualifier("weaponServiceImpl_poxy")
    private WeaponService poxyWeaponService;

    /**
     * 在业务中添加事务
     */
    @Test
    public void sfds() {
        weaponService.changeWeapon(1, 2);
    }

    /**
     * 在不改变源代码的情况下添加事务
     * 新增静态代理类
     */
    @Test
    public void sfdd() {
    poxyWeaponService.changeWeapon(1,2);
    }
}
