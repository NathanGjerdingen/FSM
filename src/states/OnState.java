package states;

import timer.Notifiable;

/**
 * On State for FSM
 */
public class OnState extends StateAdapter implements Notifiable{
	
	/**
	 * Set up instance for state
	 */
	private static OnState instance;
	
	/**
	 * Private constructor to implement Singleton pattern
	 */
	private OnState() {
	}
	
	/**
	 * Instance method for implementing Singleton pattern
	 * 
	 * @return instance
	 */
    public static OnState instance() {
        if (instance == null) {
            instance = new OnState();
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
		VehicleContext.instance().showOnState();
		VehicleContext.setParked(true);
	}
	
	/**
	 * Method for when the State is left
	 */
	@Override
	public void leave() {
		// Do nothing as have no need for an event(s) here 		
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
	 * Method for checking if break pedal is currently pressed.
	 */
	@Override
	public boolean breakPedalIsPressed() {
		// TODO Auto-generated method stub
		return false;
	}

}
