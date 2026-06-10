package WebMonitorObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Website implements Observable {

    private String url;
    private LocalDateTime lastChecked;
    private List<WebsiteObserver> observers = new ArrayList<>();

    public Website(String url) {
        this.url = url;
        this.lastChecked = LocalDateTime.now();
    }

    @Override
    public void addObserver(WebsiteObserver observer) {
        observers.add(observer);
        System.out.println("Observer registriert: " + observer.getClass().getSimpleName());
    }

    @Override
    public void removeObserver(WebsiteObserver observer) {
        observers.remove(observer);
        System.out.println("Observer entfernt: " + observer.getClass().getSimpleName());
    }

    @Override
    public void notifyObservers(String changeDescription) {
        for (WebsiteObserver observer : observers) {
            observer.update(url, changeDescription);
        }
    }

    public void checksForUpdates() {
        System.out.println("Prüfe Website: " + url);
        this.lastChecked = LocalDateTime.now();
        detectChange("Inhalt wurde geändert.");
    }

    private void detectChange(String description) {
        System.out.println("Änderung erkannt: " + description);
        notifyObservers(description);
    }

    public String getUrl() {
        return url;
    }
}