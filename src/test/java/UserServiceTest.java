import facade.BookingFacade;
import model.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

import static org.junit.Assert.assertEquals;

public class UserServiceTest {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );
    static UserService userService = context.getBean("userService", UserService.class);
    @Test
    public void newUserTest() {
        User newUser = userService.createUser("Kolya", "Bang@Gang");
        User realUser = userService.findUserByEmail("Bang@Gang");
        assertEquals(newUser, realUser);
    }
}
