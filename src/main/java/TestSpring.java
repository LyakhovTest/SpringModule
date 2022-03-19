import facade.BookingFacade;
import model.Ticket;
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

//        UserService userService = context.getBean("userService", UserService.class);
//        userService.createUser("bent", "Tescha@sutaya.ei");
//        System.out.println(userService.findUserById(3));
//
//        EventService eventService = context.getBean("eventService", EventService.class);
//        eventService.createEvent("Theatre");
//        System.out.println(eventService.findEventById(2));
//
//        TicketService ticketService = context.getBean("ticketService", TicketService.class);
//        ticketService.bookingTicket(3, 3, Ticket.Category.BAR, 10);
//        System.out.println(ticketService.findTicketById(4));


        BookingFacade bookingFacade = context.getBean("bookingFacadeBean",BookingFacade.class);
        bookingFacade.createUser("bent", "Tescha@sutaya.ei");
        bookingFacade.createEvent("Theatre");
        //bookingFacade.bookTicket(3, 3, 10, Ticket.Category.BAR);
    }
}