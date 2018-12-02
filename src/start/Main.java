package start;
import display.GUI;
import display.VehicleDisplay;
import javafx.application.Application;
import timer.Clock;
import states.VehicleContext;


/**
 * Main method to run program.
 */
public class Main {
    public static void main(String[] args) {
        Clock.instance();
        new Thread() {
            @Override
            public void run() {
                Application.launch(GUI.class, null);
            }
        }.start();
        try {
            while (GUI.getInstance() == null) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
        }
        VehicleDisplay display = GUI.getInstance();
        VehicleContext.instance().setDisplay(display);
    }
}
