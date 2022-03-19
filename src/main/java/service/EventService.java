package service;

import dao.EventDAO;
import dao.UserDAO;
import model.Event;
import model.EventImpl;

public class EventService {
    private EventDAO eventDAO;

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public Event findEventById(long id) {
        return eventDAO.findEventById(id);
    }

    public Event createEvent(String name) {
        return eventDAO.createEvent(name);
    }

    public Event updateEvent(Event event) {
        return eventDAO.updateEvent(event);
    }

    public boolean deleteEvent(long eventId) {
        return eventDAO.deleteEvent(eventId);
    }
}
