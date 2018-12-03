package states;

import timer.Notifiable;
import timer.Timer;

/**
 * Accelerating State for FSM
 */
public class AcceleratingState extends StateAdapter implements Notifiable{

	/**
	 * Set up instance and timer for state
	 */
	private static AcceleratingState instance;
	private Timer timer;
	 
	/**
	 * Private constructor to implement Singleton pattern
	 */
	private AcceleratingState() {
	}
	
	/**
	 * Instance method for implementing Singleton pattern
	 * 
	 * @return instance
	 */
    public static AcceleratingState instance() {
        if (instance == null) {
            instance = new AcceleratingState();
        }
        return instance;
    }
	
    /**
     * Event for when the timer ticks
     */
	@Override
	public void timerTicked(int timeLeft) {		
		if(VehicleContext.getSpeed() != 50) {
			VehicleContext.setSpeed(VehicleContext.getSpeed() + 5);
			VehicleContext.instance().showSpeed();
		}
	}

	/**
	 * Event for when the timer runs out
	 */
	@Override
	public void timerRanOut() {
		// Doesn't do anything because no time
	}

	/**
	 * Method for when the State is entered
	 */
	@Override
	public void enter() {
		timer = new Timer(this);
		VehicleContext.setisBreaking(false);
		VehicleContext.setParked(false);
		VehicleContext.instance().showDriveState();
		VehicleContext.instance().showAcceleratingState();
	}
	
	/**
	 * Method for when the State is left
	 */
	@Override
	public void leave() {
		timer.stop();
        timer = null;
        VehicleContext.instance().showDriveState();
	}

	/**
	 * Method for when break pedal is pressed
	 */
	@Override
	public void pressBreakPedal() {
		VehicleContext.instance().changeState(BrakingState.instance());
	}

	/**
	 * Method for when gas pedal is pressed
	 */
	@Override
	public void pressGasPedal() {
		//Do nothing as we are already in this state.
	}

	/**
	 * Method for checking if break pedal is currently pressed.
	 */
	@Override
	public boolean breakPedalIsPressed() {
		// Return false as we are Accelerating
		return false;
	}

}
