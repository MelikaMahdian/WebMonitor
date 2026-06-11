package WebMonitorObserver;

public class MonitorService {

    private Website website;
    private Subscription subscription;

    public MonitorService(Website website, Subscription subscription) {
        this.website = website;
        this.subscription = subscription;
    }

    public void scheduleCheck(String newContent) {
        System.out.println("Prüfung geplant. Frequenz: " + subscription.getFrequency());
        website.checksForUpdates(newContent);
    }
}