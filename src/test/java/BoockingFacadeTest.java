import facade.BookingFacade;
import model.Ticket;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BoockingFacadeTest {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );
    @Test
    public void newUserBoockingNewEventTicketTest(){
        BookingFacade bookingFacade = context.getBean("bookingFacadeBean",BookingFacade.class);
        bookingFacade.createUser("bent", "Tescha@sutaya.ei");
        bookingFacade.createEvent("Theatre");
        Ticket newTicket = bookingFacade.bookTicket(3, 3, 10, Ticket.Category.BAR);
        assertNotNull(newTicket);
        Long newTicketId = newTicket.getId();
        bookingFacade.cancelTicket(newTicketId);
        assertEquals(bookingFacade.getTicketById(newTicketId), null);
    }
}
