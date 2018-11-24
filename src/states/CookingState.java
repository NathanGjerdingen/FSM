package states;
import timer.Notifiable;
import timer.Timer;

/**
 * 
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010
 
 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.  
 */

/**
 * Represents the cooking state.
 *
 */
public class CookingState extends MicrowaveState implements Notifiable {
    private static CookingState instance;
    private Timer timer;

    /**
     * Private for the singleton pattern
     */
    private CookingState() {
    }

    /**
     * For singleton
     * 
     * @return the object
     */
    public static CookingState instance() {
        if (instance == null) {
            instance = new CookingState();
        }
        return instance;
    }

    /**
     * Process Cook request
     */
    @Override
    public void cookRequested() {
        timer.addTimeValue(10);
        MicrowaveContext.instance().showTimeLeft(timer.getTimeValue());
    }

    /**
     * Process door open request
     */
    @Override
    public void doorOpened() {
        MicrowaveContext.instance().changeState(DoorOpenState.instance());
    }

    /**
     * Process clock tick Generates the timer runs out event
     */
    @Override
    public void timerTicked(int timeLeft) {
        MicrowaveContext.instance().showTimeLeft(timeLeft);
    }

    /**
     * Process clock ticks Generates the timer runs out event
     */
    @Override
    public void timerRanOut() {
        MicrowaveContext.instance().showTimeLeft(0);
        MicrowaveContext.instance().changeState(DoorClosedState.instance());
    }

    /**
     * Initializes the state Adds itself as a listener to managers Updates the
     * displays
     * 
     */
    @Override
    public void enter() {
        timer = new Timer(this, 10);
        MicrowaveContext.instance().showCooking();
        MicrowaveContext.instance().showTimeLeft(timer.getTimeValue());
    }

    @Override
    public void leave() {
        timer.stop();
        timer = null;
        MicrowaveContext.instance().showNotCooking();
        MicrowaveContext.instance().showTimeLeft(0);
    }

}