package storage;

import basicIntegration.BasicIntegrationTest;
import model.Event;
import model.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class StorageTest extends BasicIntegrationTest {
    @Test
    public void createUserTest() {
        //When
        User newUser = storage.addUser("Kolya", "Bang@Gang");
        //Then
        assertEquals(storage.getUserById(newUser.getId()), newUser);
    }

    @Test
    public void updateUserTest(){
        //Given
        User user = storage.addUser("Kolya", "Bang@Gang");
        user.setEmail("Ivan@");
        //When
        User updateUser = storage.updateUser(user);
        //Then
        assertEquals(storage.getUserById(user.getId()).getEmail(),"Ivan@");
        assertNull(storage.getUserByEmail("Bang@Gang"));
    }

    @Test
    public void deleteUserTest() {
        //Given
        User newUser = storage.addUser("Qwer", "ytfgujh@kj");
        //When
        boolean isDeleted = storage.deleteUser(newUser.getId());
        //Then
        assertTrue(isDeleted);
    }

    @Test
    public void createEventTest() {
        //When
        Event newEvent = storage.addEvent("Theatre");
        //Then
        assertEquals(storage.getEventById(newEvent.getId()).getTitle(), "Theatre");
    }

    @Test
    public void updateEventTest(){
        //Given
        Event event = storage.addEvent("Theatre");
        //Given
        event.setTitle("Football");
        Event updateEvent = storage.updateEvent(event);
        //Then
        assertEquals(storage.getEventById(event.getId()).getTitle(), "Football");
    }

    @Test
    public void deleteEvent(){
        //Given
        Event event = storage.addEvent("Theatre");
        //When
        storage.deleteEvent(event.getId());
        //Then
        assertNull(storage.getEventById(event.getId()));
    }
}
