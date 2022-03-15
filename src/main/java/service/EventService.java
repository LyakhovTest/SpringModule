package service;

import dao.EventDAO;
import dao.UserDAO;
import model.Event;

public class EventService {
    private EventDAO eventDAO;

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    public Event findEventById(int id) {
        return eventDAO.findEventById(id);
    }
}
