package WebMonitorObserver;

public class Main {
    public static void main(String[] args) {

        // Subject erstellen
        Website website = new Website("https://example.com");

        // Observer erstellen
        User user = new User("1", "Melika", "melika@email.com");
        EmailNotifier emailNotifier = new EmailNotifier("mail.example.com");
        SmsNotifier smsNotifier = new SmsNotifier("+49123456789");

        // Observer registrieren
        website.addObserver(user);
        website.addObserver(emailNotifier);
        website.addObserver(smsNotifier);

        // Setup
        Subscription subscription = new Subscription("sub1", "active", 5);
        MonitorService service = new MonitorService(website, subscription);
        MonitorController controller = new MonitorController(service);

        user.register();
        user.login();
        controller.handleRegistration();

        // Löst Check aus → alle Observer werden benachrichtigt
        controller.triggerSubscription();

        // Melika kündigt ihr Abo
        System.out.println("\n--- Melika kündigt ihr Abo ---");
        website.removeObserver(user);
        controller.triggerSubscription();
    }
}