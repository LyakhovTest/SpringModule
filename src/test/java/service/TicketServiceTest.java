package service;

import basicIntegration.BasicIntegrationTest;
import model.Event;
import model.Ticket;
import model.User;
import org.junit.Test;
import storage.Storage;

public class TicketServiceTest extends BasicIntegrationTest {
    TicketService ticketService = context.getBean("ticketService", TicketService.class);
    Storage storage = context.getBean("storageBean", Storage.class);

//    @Test(expected = Exception.class)
//    public void createAndDeleteEventTest() throws Exception {
//        User newUser = storage.addUser("bent", "Tescha@sutaya.ei");
//        Event newEvent = storage.addEvent("Theatre");
//        Ticket newTicket = ticketService.bookingTicket(newEvent.getId(),newUser.getId(), Ticket.Category.STANDARD, 13);
//        Ticket newTicket1 = ticketService.bookingTicket(newEvent.getId(),newUser.getId(), Ticket.Category.STANDARD, 13);
//    }
}

