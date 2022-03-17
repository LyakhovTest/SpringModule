package service;

import dao.TicketDAO;
import model.Ticket;
import model.User;

public class TicketService {
    private TicketDAO ticketDAO;

    public void setTicketDAO(TicketDAO ticketDAO) {
        this.ticketDAO = ticketDAO;
    }

    public Ticket findTicketById(long id){
        return ticketDAO.findTicketById(id);
    }

    public Ticket bookingTicket(long eventId, long userId, Ticket.Category category, int place) {
        return ticketDAO.bookingTicket(eventId, userId, category, place);
    }

    public boolean cancelTicket(long ticketId) {
        return ticketDAO.cancelTicket(ticketId);
    }

    public Ticket getTicketById(long tickedId) {
        return ticketDAO.getTicketById(tickedId);
    }
}
