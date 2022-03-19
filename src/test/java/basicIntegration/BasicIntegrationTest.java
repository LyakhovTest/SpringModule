package basicIntegration;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import storage.Storage;

public class BasicIntegrationTest {
    protected ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
            "applicationContext.xml"
    );
    protected Storage storage = context.getBean("storageBean", Storage.class);
}
