public class MonitorService {
    private Website website;
    private Subscription subscription;
    private Notifier notifier;

    public MonitorService(Website website, Subscription subscription, Notifier notifier) {
        this.website = website;
        this.subscription = subscription;
        this.notifier = notifier;
    }

    public void checksForUpdates() {
        System.out.println("Prüfe Website: " + website.getUrl());
    }

    public void detectChange() {
        System.out.println("Änderung erkannt.");
    }

    public void scheduleCheck() {
        System.out.println("Prüfung geplant. Frequenz: " + subscription.getFrequency());
    }

    public void createNotification() {
        Notification notification = new Notification("1", "Website wurde geändert!");
        notification.generate();
        notifier.deliver(notification);
    }
}