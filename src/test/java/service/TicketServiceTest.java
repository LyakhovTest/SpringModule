package service;

import basicIntegration.BasicIntegrationTest;
import model.Event;
import model.Ticket;
import model.User;
import org.junit.Test;
import storage.Storage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TicketServiceTest extends BasicIntegrationTest {
    TicketService ticketService = context.getBean("ticketService", TicketService.class);
    Storage storage = context.getBean("storageBean", Storage.class);

    @Test
    public void createTicketTest() throws Exception {
        //When
        User createUser = storage.addUser("bent", "Tescha@sutaya.ei");
        Event createEvent = storage.addEvent("Theatre");
        Ticket newTicket = ticketService.bookingTicket(createUser.getId(), createEvent.getId(), Ticket.Category.BAR, 10);
        //Then
        assertEquals(createUser.getId(), newTicket.getUserId());
        assertEquals(createEvent.getId(), newTicket.getEventId());
    }
}

