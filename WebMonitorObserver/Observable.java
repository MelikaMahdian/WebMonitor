package WebMonitorObserver;

public interface Observable {
    void addObserver(WebsiteObserver observer);
    void removeObserver(WebsiteObserver observer);
    void notifyObservers(String changeDescription);
}