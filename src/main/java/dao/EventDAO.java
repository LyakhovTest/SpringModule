package dao;

import model.Event;
import storage.Storage;

public class EventDAO {
    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Event findEventById(long id) {
        return storage.getEventById(id);
    }

    public Event createEvent(String name) {
        return storage.addEvent(name);
    }

    public Event updateEvent(Event event) {
        return storage.updateEvent(event);
    }

    public boolean deleteEvent(long eventId) {
        return storage.deleteEvent(eventId);
    }
}
