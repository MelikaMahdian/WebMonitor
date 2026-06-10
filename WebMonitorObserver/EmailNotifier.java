package WebMonitorObserver;

public class EmailNotifier implements WebsiteObserver {

    private String server;

    public EmailNotifier(String server) {
        this.server = server;
    }

    @Override
    public void update(String url, String changeDescription) {
        Notification notification = new Notification("email-1",
                "Änderung auf " + url + ": " + changeDescription);
        notification.generate();
        System.out.println("E-Mail über " + server + ": " + notification.getMessage());
    }
}