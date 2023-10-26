package test.message;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import Lesson_4.message.MessageService;
import Lesson_4.message.NotificationService;

class NotificationServiceTest {

    @Test
    public void notificationTest() {
        MessageService service = mock(MessageService.class);
        NotificationService notificator = new NotificationService(service);

        notificator.sendNotification("Nikita", "Hello World.");
        verify(service, times(1)).sendMessage("Nikita", "Hello World.");
    }
}