import cn.walmt.entity.User;
import cn.walmt.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by walmt on 2018/3/14.
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/spring_jedis.xml");
        UserService userService = context.getBean(UserService.class);
        User user = new User();
        user.setUsername("老王");
        user.setPassword("hahaha1");
//        userService.insertUser(user);
        userService.getUser("老王");
//        userService.updateUser(user);
//        userService.deleteUser("老王");
    }
}
