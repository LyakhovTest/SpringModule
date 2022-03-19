package storage;

import model.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    private Long userSec =0L;
    private Long eventSec =0L;
    private Long ticketSec =0L;

    private Map<Long, User> userMap = new HashMap<>();
    private Map<Long, Event> eventMap = new HashMap<>();
    private Map<Long, Ticket> ticketMap = new HashMap<>();

    public int getUsersCount(){
        return userMap.size();
    }

    public void deleteAllUsers(){
        userMap.clear();
    }

    {
//        userMap.put(userCount,new UserImpl(userCount,"Tiger","Koshka@kotopes.com"));
//        userCount++;
//        userMap.put(userCount, new UserImpl(userCount,"Atas", "Tescha@sutalaya.ei"));
//        userCount++;
//

//        eventMap.put(eventCount, new EventImpl(eventCount,"Film", new Date()));
//        eventCount++;
//        eventMap.put(eventCount, new EventImpl(eventCount,"Firework", new Date()));
//        eventCount++;
//

//        ticketMap.put(ticketCount, new TicketImpl(ticketCount,1,1, Ticket.Category.STANDARD, 13));
//        ticketCount++;
//        ticketMap.put(ticketCount, new TicketImpl(ticketCount,1,2, Ticket.Category.STANDARD, 14));
//        ticketCount++;
//        ticketMap.put(ticketCount, new TicketImpl(ticketCount,2,1, Ticket.Category.BAR, 1));
//        ticketCount++;
//        ticketMap.put(ticketCount, new TicketImpl(ticketCount,2,2, Ticket.Category.PREMIUM, 23));
//        ticketCount++;
    }

    public User addUser(String name, String email) {
        User user = userMap.values().stream().filter(user1->user1.getEmail().equals(email)).findAny().orElse(null);
        if(user!=null){
            try {
                throw new Exception("ОШИБКА СОЗДАНИЯ ПОЛЬЗОВАТЕЛЯ: пользователь" +
                        " с таким именем уже существует");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ++userSec;
        User newUser =  new UserImpl(userSec, name, email);
        userMap.put(userSec,newUser);
        return newUser;
    }

    public User getUserById(long id) {
       return userMap.values().stream().filter(user->user.getId()==id).findAny().orElse(null);
    }

    public User getUserByEmail(String email) {
        return userMap.values().stream().filter(user->user.getEmail().equals(email)).findAny().orElse(null);
    }

    public User updateUser(User user) {
        return userMap.put(user.getId(), user);
    }

    public Event getEventById(long id) {
        return eventMap.values().stream().filter(event->event.getId()==id).findAny().orElse(null);
    }

    public Event addEvent(String name) {
        Event event = new EventImpl(eventSec,name, new Date());
        eventMap.put(eventSec, event);
        return event;
    }

    public Event updateEvent(Event event) {
        return eventMap.put(event.getId(), event);
    }

    public boolean deleteEvent(long eventId) {
        Event oldEvent = eventMap.values().stream().filter(event->event.getId()==eventId).findAny().orElse(null);
        if(oldEvent==null)return false;
        return eventMap.remove(eventId, oldEvent);
    }

    public Ticket getTicketById(long id) {
        return ticketMap.values().stream().filter(ticket->ticket.getId()==id).findAny().orElse(null);
    }

    public Ticket addTicket(long eventId, long userId, Ticket.Category category, int place) throws Exception {
        Ticket checkFreeTicket = ticketMap.values().stream().filter(ticket->ticket.getEventId()==eventId)
                .filter(ticket->ticket.getPlace()==place).findAny().orElse(null);
        if(checkFreeTicket!=null) {
                throw new Exception("ОШИБКА БРОНИРОВАНИЯ БИЛЕТА: билет" +
                        " на данное мероприятие забронирован");
        }
        Ticket ticket = new TicketImpl(ticketSec,eventId,userId, category, place);
        ticketMap.put(ticketSec, ticket);
        return ticket;
    }


    public boolean deleteUser(long userId) {
        User oldUser = userMap.values().stream().filter(user->user.getId()==userId).findAny().orElse(null);
        if(oldUser==null)return false;
        return userMap.remove(userId, oldUser);
    }

    public boolean cancelTicket(long ticketId) {
        Ticket oldTicket = ticketMap.values().stream().filter(ticket->ticket.getId()==ticketId).findAny().orElse(null);
        if(oldTicket==null)return false;
        return ticketMap.remove(ticketId, oldTicket);
    }
}
