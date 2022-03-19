package service;

import basicIntegration.BasicIntegrationTest;
import model.Event;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EventServiceTest extends BasicIntegrationTest {
    EventService eventService = context.getBean("eventService", EventService.class);
    @Test
    public void createEventTest() {
        //When
        Event newEvent = eventService.createEvent("Theatre");
        //Then
        assertEquals(eventService.findEventById(newEvent.getId()).getTitle(), "Theatre");
    }

    @Test
    public void updateEventTest(){
        //Given
        Event event = storage.addEvent("Theatre");
        //Given
        event.setTitle("Football");
        Event updateEvent = eventService.updateEvent(event);
        //Then
        assertEquals(eventService.findEventById(event.getId()).getTitle(), "Football");
    }

    @Test
    public void deleteEvent(){
        //Given
        Event event = storage.addEvent("Theatre");
        //When
        eventService.deleteEvent(event.getId());
        //Then
        assertNull(eventService.findEventById(event.getId()));
    }
}
