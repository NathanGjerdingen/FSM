package states;

import timer.Notifiable;

/**
 * Park State for FSM
 */
public class ParkState extends StateAdapter implements Notifiable{

	/**
	 * Set up instance for state
	 */
	private static ParkState instance;
	
	/**
	 * Private constructor to implement Singleton pattern
	 */
	private ParkState() {
	}
	
	/**
	 * Instance method for implementing Singleton pattern
	 * 
	 * @return instance
	 */
    public static ParkState instance() {
        if (instance == null) {
            instance = new ParkState();
        }
        return instance;
    }
	
	/**
	 * Method for when the timer ticks
	 */
	@Override
	public void timerTicked(int timeLeft) {
		// Do nothing as have no need for an event(s) here 				
	}

	/**
	 * Method for when the timer runs out
	 */
	@Override
	public void timerRanOut() {
		// Do nothing as have no need for an event(s) here 				
	}

	/**
	 * Method for when the State is entered
	 */
	@Override
	public void enter() {
		VehicleContext.instance().showParkedState();
		VehicleContext.setParked(true);
	}

	/**
	 * Method for when the State is left
	 */
	@Override
	public void leave() {
	VehicleContext.setParked(false);
	}

	/**
	 * Method for when the break pedal is pressed
	 */
	@Override
	public void pressBreakPedal() {
		// Do nothing as have no need for an event(s) here 				
	}

	/**
	 * Method for when the gas pedal is pressed
	 */
	@Override
	public void pressGasPedal() {
		VehicleContext.instance().changeState(AcceleratingState.instance());
	}

	/**
	 * Method for when the break pedal is pressed
	 * 
	 * @return false
	 */
	@Override
	public boolean breakPedalIsPressed() {
		return false;
	}

}
