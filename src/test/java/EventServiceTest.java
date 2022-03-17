import model.Event;
import model.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.EventService;
import service.UserService;

import static org.junit.Assert.assertEquals;

public class EventServiceTest {
    static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );
    static EventService eventService = context.getBean("eventService", EventService.class);
    @Test
    public void createAndDeleteEventTest() {
        Event newEvent = eventService.createEvent("Theatre");
        Long eventId = newEvent.getId();
        eventService.deleteEvent(eventId);
        assertEquals(eventService.findEventById(eventId), null);
    }
}
