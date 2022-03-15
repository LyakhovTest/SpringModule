package dao;

import model.Event;
import storage.Storage;

public class EventDAO {
    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Event findEventById(int id) {
        return storage.getEventById(id);
    }
}
