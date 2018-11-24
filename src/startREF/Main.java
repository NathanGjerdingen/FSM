package startREF;

import displayREF.GUIDisplay;
import displayREF.VehilcleDisplay;
import javafx.application.Application;
import statesREF.Clock;
import statesREF.MicrowaveContext;

public class Main {
    public static void main(String[] args) {
        Clock.instance();
        new Thread() {
            @Override
            public void run() {
                Application.launch(GUIDisplay.class, null);
            }
        }.start();
        try {
            while (GUIDisplay.getInstance() == null) {
                Thread.sleep(1000);
            }
        } catch (InterruptedException ie) {
        }
        VehilcleDisplay display = GUIDisplay.getInstance();
        MicrowaveContext.instance().setDisplay(display);
    }
}
