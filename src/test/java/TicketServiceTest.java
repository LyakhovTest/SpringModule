import model.Ticket;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.TicketService;

public class TicketServiceTest {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );
    static TicketService ticketService = context.getBean("ticketService", TicketService.class);
//    @Rule
//    public ExpectedException thrown= ExpectedException.none();
//    @Test(expected = Exception.class)
//    public void createAndDeleteEventTest() {
//        thrown.expect(Exception.class);
//        Ticket newTicket = ticketService.bookingTicket(1,1, Ticket.Category.STANDARD, 13);
//
//    }

    @Test(expected = Exception.class)
    public void createAndDeleteEventTest() {
        Ticket newTicket = ticketService.bookingTicket(1,1, Ticket.Category.STANDARD, 13);
    }
}

