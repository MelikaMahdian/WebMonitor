package WebMonitor;
public class MonitorController {
    private MonitorService monitorService;

    public MonitorController(MonitorService monitorService) {
        this.monitorService = monitorService;
    }

    public void handleRegistration() {
        System.out.println("Registrierung wird bearbeitet.");
    }

    public void triggerSubscription() {
        monitorService.scheduleCheck();
    }

    public void handleModifyCancel() {
        System.out.println("Abo wird geändert oder gekündigt.");
    }
}