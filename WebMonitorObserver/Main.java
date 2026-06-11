package WebMonitorObserver;

public class Main {

    public static void main(String[] args) {

        // Strategien
        ComparisonStrategy htmlStrategy = new HtmlContentStrategy();
        ComparisonStrategy sizeStrategy = new ContentSizeStrategy();
        ComparisonStrategy textStrategy = new TextContentStrategy();

        // Subject mit initialem Inhalt und Strategie erstellen
        String initialContent = "<html><body><p>Hello World</p></body></html>";
        Website website = new Website("https://example.com", initialContent, htmlStrategy);

        // Observer erstellen und registrieren
        User user = new User("1", "Melika", "melika@email.com");
        EmailNotifier emailNotifier = new EmailNotifier("mail.example.com");
        SmsNotifier smsNotifier = new SmsNotifier("+49123456789");

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

        // --- Test 1: HtmlContentStrategy – identischer Inhalt → keine Änderung ---
        System.out.println("\n--- Test 1: HTML-Strategie, gleicher Inhalt ---");
        controller.triggerSubscription(initialContent);

        // --- Test 2: HtmlContentStrategy – geänderter HTML-Inhalt ---
        System.out.println("\n--- Test 2: HTML-Strategie, geänderter Inhalt ---");
        controller.triggerSubscription("<html><body><p>Hello Universe</p></body></html>");

        // --- Test 3: ContentSizeStrategy ---
        System.out.println("\n--- Test 3: Strategie wechsel zu ContentSizeStrategy ---");
        website.setStrategy(sizeStrategy);
        // Gleiche Zeichenanzahl, aber anderer Text → keine Änderung bei ContentSize
        controller.triggerSubscription("<html><body><p>Hello_Univers</p></body></html>");

        // --- Test 4: TextContentStrategy – nur Text zählt ---
        System.out.println("\n--- Test 4: Strategie wechsel zu TextContentStrategy ---");
        website.setStrategy(textStrategy);
        // Anderer HTML-Wrapper, gleicher sichtbarer Text → keine Änderung
        controller.triggerSubscription("<html><body><div>Hello_Univers</div></body></html>");

        // --- Test 5: TextContentStrategy – sichtbarer Text ändert sich ---
        System.out.println("\n--- Test 5: TextContentStrategy, Text ändert sich ---");
        controller.triggerSubscription("<html><body><div>Goodbye World</div></body></html>");

        // Melika kündigt ihr Abo
        System.out.println("\n--- Melika kündigt ihr Abo ---");
        website.removeObserver(user);
        controller.triggerSubscription("<html><body><div>Final Content</div></body></html>");
    }
}