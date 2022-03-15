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
}
