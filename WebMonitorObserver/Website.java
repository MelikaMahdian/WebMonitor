package WebMonitorObserver;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Website implements Observable {

    private String url;
    private String content;
    private LocalDateTime lastChecked;
    private List<WebsiteObserver> observers = new ArrayList<>();
    private ComparisonStrategy strategy;

    public Website(String url, String initialContent, ComparisonStrategy strategy) {
        this.url = url;
        this.content = initialContent;
        this.strategy = strategy;
        this.lastChecked = LocalDateTime.now();
    }

    public void setStrategy(ComparisonStrategy strategy) {
        this.strategy = strategy;
        System.out.println("Strategie gewechselt: " + strategy.getClass().getSimpleName());
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

    public void checksForUpdates(String newContent) {
        System.out.println("Prüfe Website: " + url
                + " [Strategie: " + strategy.getClass().getSimpleName() + "]");
        this.lastChecked = LocalDateTime.now();

        if (strategy.hasChanged(this.content, newContent)) {
            System.out.println("Änderung erkannt!");
            this.content = newContent;
            notifyObservers("Inhalt wurde geändert.");
        } else {
            System.out.println("Keine Änderung festgestellt.");
        }
    }

    public String getUrl() {
        return url;
    }
}