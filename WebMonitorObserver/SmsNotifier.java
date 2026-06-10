package WebMonitorObserver;

public class SmsNotifier implements WebsiteObserver {

    private String phoneNumber;

    public SmsNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String url, String changeDescription) {
        Notification notification = new Notification("sms-1",
                "Änderung auf " + url + ": " + changeDescription);
        notification.generate();
        System.out.println("SMS an " + phoneNumber + ": " + notification.getMessage());
    }
}