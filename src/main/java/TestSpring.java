import facade.BookingFacade;
import model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.EventService;
import service.TicketService;
import service.UserService;

/**
 * @author Neil Alishev
 */
public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        UserService userService = context.getBean("userService", UserService.class);
        System.out.println(userService.findUserById(1));
        TicketService ticketService = context.getBean("ticketService", TicketService.class);
        System.out.println(ticketService.findTicketById(4));
        EventService eventService = context.getBean("eventService", EventService.class);
        System.out.println(eventService.findEventById(2));
//
//        BookingFacade bookingFacade = context.getBean("bookingFacadeBean",BookingFacade.class);
//        bookingFacade.sayHello();
    }
}