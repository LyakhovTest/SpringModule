package storage;

import model.*;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    static Integer userCount =1;
    static Integer eventCount=1;
    static Integer ticketCount=1;

    private Map<Integer, User> userMap;
    private Map<Integer, Event> eventMap;
    private Map<Integer, Ticket> ticketMap;

    {
        userMap = new HashMap<>();
        userMap.put(userCount,new UserImpl(userCount,"Tiger","Koshka@kotopes.com"));
        userCount++;
        userMap.put(userCount, new UserImpl(userCount,"Atas", "Tescha@sutalaya.ei"));
        userCount++;

        eventMap= new HashMap<>();
        eventMap.put(eventCount, new EventImpl(eventCount,"Film", new Date()));
        eventCount++;
        eventMap.put(eventCount, new EventImpl(eventCount,"Firework", new Date()));
        eventCount++;

        ticketMap = new HashMap<>();
        ticketMap.put(ticketCount, new TicketImpl(ticketCount,1,1, Ticket.Category.STANDARD, 13));
        ticketCount++;
        ticketMap.put(ticketCount, new TicketImpl(ticketCount,1,2, Ticket.Category.STANDARD, 14));
        ticketCount++;
        ticketMap.put(ticketCount, new TicketImpl(ticketCount,2,1, Ticket.Category.BAR, 1));
        ticketCount++;
        ticketMap.put(ticketCount, new TicketImpl(ticketCount,2,2, Ticket.Category.PREMIUM, 23));
        ticketCount++;
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

    public User addUser(String name, String email) {
        User user = userMap.values().stream().filter(user1->user1.getEmail()==email).findAny().orElse(null);
        if(user!=null){
            try {
                throw new Exception("ОШИБКА СОЗДАНИЯ ПОЛЬЗОВАТЕЛЯ: пользователь" +
                        " с таким именем уже существует");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        User newUser =  new UserImpl(userCount, name, email);
        userMap.put(userCount,newUser);
        return newUser;
    }

    public Event addEvent(String name) {
        Event event = new EventImpl(eventCount,name, new Date());
        eventMap.put(eventCount, event);
        return event;
    }

    public Ticket addTicket(long eventId, long userId, Ticket.Category category, int place) {
        Ticket ticket = new TicketImpl(ticketCount,eventId,userId, category, place);
        ticketMap.put(ticketCount, ticket);
        return ticket;
    }
}
