import com.aop.service.WeaponService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring_change.xml")
public class change {
    @Autowired  //给成员变量设置初始值
    private WeaponService weaponService;

    @Test
    public void sfds(){
        weaponService.changeWeapon(1,3);
    }
}
