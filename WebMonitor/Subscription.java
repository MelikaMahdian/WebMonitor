package WebMonitor;
public class Subscription {
    private String subscriptionId;
    private String status;
    private int frequency;

    public Subscription(String subscriptionId, String status, int frequency) {
        this.subscriptionId = subscriptionId;
        this.status = status;
        this.frequency = frequency;
    }

    public void modify() {
        System.out.println("Abo wurde geändert.");
    }

    public void cancel() {
        status = "cancelled";
        System.out.println("Abo wurde gekündigt.");
    }

    public int getFrequency() {
        return frequency;
    }
}