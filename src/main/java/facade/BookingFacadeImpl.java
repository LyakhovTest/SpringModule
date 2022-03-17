package facade;

import model.Event;
import model.Ticket;
import model.User;
import service.EventService;
import service.TicketService;
import service.UserService;
import java.util.Date;
import java.util.List;

public class BookingFacadeImpl implements BookingFacade{
    private UserService userService;
    private EventService eventService;
    private TicketService ticketService;

    public BookingFacadeImpl(UserService userService, EventService eventService, TicketService ticketService) {
        this.userService = userService;
        this.eventService = eventService;
        this.ticketService = ticketService;
    }

    @Override
    public User getUserById(long userId) {
      return userService.findUserById(userId);
    }

    @Override
    public User getUserByEmail(String email) {
        return userService.findUserByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public User createUser(String name, String email ) {
        return userService.createUser(name,email);
    }

    @Override
    public User updateUser(User user) {
        return userService.updateUser(user);
    }

    @Override
    public boolean deleteUser(long userId) {
        return userService.deleteUser(userId);
    }

    @Override
    public Event createEvent(String event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return eventService.updateEvent(event);
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return eventService.deleteEvent(eventId);
    }

    @Override
    public Event getEventById(long eventId) {
        return eventService.findEventById(eventId);
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.bookingTicket(eventId, userId, category, place);
    }

    public Ticket getTicketById(long tickedId){
        return ticketService.getTicketById(tickedId);
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public boolean cancelTicket(long ticketId) {
        return ticketService.cancelTicket(ticketId);
    }

}
