package WebMonitor;


public class Main {
    public static void main(String[] args) {
        User user = new User("1", "Melika", "melika@email.com");
        Subscription subscription = new Subscription("sub1", "active", 5);
        Website website = new Website("https://example.com");
        Notifier notifier = new EmailNotifier("mail.example.com");

        MonitorService service = new MonitorService(website, subscription, notifier);
        MonitorController controller = new MonitorController(service);

        user.register();
        user.login();
        controller.handleRegistration();
        controller.triggerSubscription();
        service.checksForUpdates();
        service.detectChange();
        service.createNotification();
    }
}