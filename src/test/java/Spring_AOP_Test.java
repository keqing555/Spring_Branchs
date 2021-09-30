import com.aop.service.WeaponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_aop.xml")
public class Spring_AOP_Test {
    @Autowired
    @Qualifier("weaponServiceImpl_proxy")
    private WeaponService weaponService;

    /**
     * Spring AOP测试
     */
    @Test
    public void aop() {
        weaponService.changeWeapon(1, 1);
    }
}
