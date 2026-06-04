package WebMonitor;
import java.time.LocalDateTime;

public class Website {
    private String url;
    private LocalDateTime lastChecked;

    public Website(String url) {
        this.url = url;
        this.lastChecked = LocalDateTime.now();
    }

    public String getUrl() {
        return url;
    }
}