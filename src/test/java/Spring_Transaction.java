import com.aop.service.WeaponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_transaction.xml")
public class Spring_Transaction {
    @Autowired
    @Qualifier("weaponServiceImpl_spring_transaction")
    private WeaponService weaponService;

    /**
     * Spring事务测试
     * 可以实现回滚
     */
    @Test
    public void trans() {
        weaponService.changeWeapon(1, 1);
    }

}
