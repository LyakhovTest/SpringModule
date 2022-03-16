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


    @Override
    public void sayHello(){
        System.out.println("Hello my dear");
    }

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
    public Event createEvent(String event) {
        return eventService.createEvent(event);
    }

    @Override
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    public boolean deleteEvent(long eventId) {
        return false;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
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
        return null;
    }

    @Override
    public boolean deleteUser(long userId) {
        return false;
    }

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Ticket.Category category) {
        return ticketService.bookingTicket(eventId, userId, category, place);
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
        return false;
    }

}
