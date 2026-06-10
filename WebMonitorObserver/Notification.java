package WebMonitorObserver;
import java.time.LocalDateTime;

public class Notification {
    private String notificationId;
    private String message;
    private LocalDateTime createdAt;

    public Notification(String notificationId, String message) {
        this.notificationId = notificationId;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public void generate() {
        System.out.println("Notification erstellt: " + message);
    }

    public void send() {
        System.out.println("Notification gesendet: " + message);
    }

    public String getMessage() {
        return message;
    }
}