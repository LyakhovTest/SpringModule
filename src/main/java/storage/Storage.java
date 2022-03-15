package storage;

import model.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Map<Integer, User> userMap;
    private Map<Integer, Event> eventMap;
    private Map<Integer, Ticket> ticketMap;

    {
        userMap = new HashMap<>();
        userMap.put(1,new UserImpl(1,"Tiger","Koshka@kotopes.com"));
        userMap.put(2, new UserImpl(2,"Atas", "Tescha@sutalaya.ei"));

        eventMap= new HashMap<>();
        eventMap.put(1, new EventImpl(1,"Film", new Date()));
        eventMap.put(2, new EventImpl(2,"Firework", new Date()));

        ticketMap = new HashMap<>();
        ticketMap.put(1, new TicketImpl(1,1,1, Ticket.Category.STANDARD, 13));
        ticketMap.put(2, new TicketImpl(2,1,2, Ticket.Category.STANDARD, 14));
        ticketMap.put(3, new TicketImpl(3,2,1, Ticket.Category.BAR, 1));
        ticketMap.put(4, new TicketImpl(4,2,2, Ticket.Category.PREMIUM, 23));
    }

    public User getuserById(long id) {
       return userMap.values().stream().filter(user->user.getId()==id).findAny().orElse(null);

    }

    public Ticket getTicketById(long id) {
        return ticketMap.values().stream().filter(ticket->ticket.getId()==id).findAny().orElse(null);
    }

    public Event getEventById(long id) {
        return eventMap.values().stream().filter(event->event.getId()==id).findAny().orElse(null);
    }
}
