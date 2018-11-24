import java.util.Observable;

public class Clock extends Observable implements Runnable {
    private static Clock instance;

    private Clock() {
        Thread thread = new Thread(this);
        thread.start();
    }

    public static Clock instance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                setChanged();

            }
        } catch (InterruptedException ie) {
        }
    }
}
