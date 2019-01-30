package framework;

public class EventListener implements Listener, Runnable {
    public String message;
    @Override
    public void Catch(String message) {
        this.message = message;
        System.out.println(message);
    }
    @Override
    public void run() { System.out.println("INFO: Started listening to Chrome Driver Actions.");}
}
