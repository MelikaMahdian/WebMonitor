package WebMonitor;
public class User {
    private String userId;
    private String name;
    private String email;

    public User(String userId, String name, String email) {
        this.userId = userId; //das Atributt der klasse ,so werden die werte in das objekt gespeichert
        this.name = name;
        this.email = email;
    }
// void bedeuted sie gibt kein wert zurück
    public void register() {
        System.out.println(name + " hat sich registriert.");
    }

    public void login() {
        System.out.println(name + " hat sich eingeloggt.");
    }

    public void manageSubscription() {
        System.out.println(name + " verwaltet sein Abo.");
    }
}