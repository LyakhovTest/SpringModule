package facade;

import basicIntegration.BasicIntegrationTest;
import facade.BookingFacade;
import model.Event;
import model.Ticket;
import model.User;
import org.junit.Test;
import storage.Storage;

import static org.junit.Assert.*;

public class BoockingFacadeTest extends BasicIntegrationTest {

    BookingFacade bookingFacade = context.getBean("bookingFacadeBean",BookingFacade.class);

    @Test
    public void bookingTicketTest(){
        //Given
        User createUser = storage.addUser("bent", "Tescha@sutaya.ei");
        Event createEvent = storage.addEvent("Theatre");
        //When
        Ticket newTicket = bookingFacade.bookTicket(createUser.getId(), createEvent.getId(), 10, Ticket.Category.BAR);
        //Then
        Ticket checkTicket = bookingFacade.getTicketById(newTicket.getId());
        assertNotNull(newTicket);
        assertNotNull(checkTicket);

        assertEquals(createUser.getId(), checkTicket.getUserId());
        assertEquals(createEvent.getId(), checkTicket.getEventId());
    }

    @Test
    public void bookingBusyTicketTest() {
        //Given
        User createUser = storage.addUser("bent", "Tescha@sutaya.ei");
        Event createEvent = storage.addEvent("Theatre");
        //When
        Ticket newTicket = bookingFacade.bookTicket(createUser.getId(), createEvent.getId(), 10, Ticket.Category.BAR);
        Ticket resetTicket = bookingFacade.bookTicket(createUser.getId(), createEvent.getId(), 10, Ticket.Category.BAR);
        //Then
        assertEquals(newTicket, storage.getTicketById(newTicket.getId()));
    }
    @Test
    public void cancelTicketTest() throws Exception {
        //Given
        User createUser = storage.addUser("bent", "Tescha@sutaya.ei");
        Event createEvent = storage.addEvent("Theatre");
        Ticket newTicket = bookingFacade.bookTicket(createUser.getId(), createEvent.getId(), 10, Ticket.Category.BAR);
        //When
        bookingFacade.cancelTicket(newTicket.getId());
        //Then
        assertNull(bookingFacade.getTicketById(newTicket.getId()));
    }
}
