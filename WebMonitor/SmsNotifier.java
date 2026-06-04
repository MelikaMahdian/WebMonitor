package WebMonitor;
public class SmsNotifier implements Notifier {
    private String phoneNumber;

    public SmsNotifier(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void deliver(Notification notification) {
        System.out.println("SMS an " + phoneNumber + ": " + notification.getMessage());
    }
}