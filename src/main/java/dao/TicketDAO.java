package dao;

import model.Ticket;
import model.User;
import storage.Storage;

public class TicketDAO {
    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Ticket findTicketById(long id) {
        return storage.getTicketById(id);
    }

    public Ticket bookingTicket(long eventId, long userId, Ticket.Category category, int place) {
        return storage.addTicket(eventId, userId, category, place);
    }
}
