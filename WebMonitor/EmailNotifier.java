package WebMonitor;
public class EmailNotifier implements Notifier {
    private String server;

    public EmailNotifier(String server) {
        this.server = server;
    }

    @Override
    public void deliver(Notification notification) {
        System.out.println("E-Mail über " + server + ": " + notification.getMessage());
    }
}