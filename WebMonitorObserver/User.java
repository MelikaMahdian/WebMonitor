package WebMonitorObserver;

public class User implements WebsiteObserver {

    private String userId;
    private String name;
    private String email;

    public User(String userId, String name, String email) {
        this.userId = userId;
        this.name = name;
        this.email = email;
    }

    public void register() {
        System.out.println(name + " hat sich registriert.");
    }

    public void login() {
        System.out.println(name + " hat sich eingeloggt.");
    }

    public void manageSubscription() {
        System.out.println(name + " verwaltet sein Abo.");
    }

    @Override
    public void update(String url, String changeDescription) {
        System.out.println("[User " + name + "] Änderung auf " 
            + url + ": " + changeDescription);
    }
}