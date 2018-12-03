package states;

import timer.Notifiable;

/**
 * Off State for FSM
 */
public class OffState extends StateAdapter implements Notifiable {

	/**
	 * Set up instance for state
	 */
	private static OffState instance;

	/**
	 * Private constructor to implement Singleton pattern
	 */
	private OffState() {
	}

	/**
	 * Instance method for implementing Singleton pattern
	 * 
	 * @return instance
	 */
	public static OffState instance() {
		if (instance == null) {
			instance = new OffState();
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
		if(VehicleContext.getisBreaking() == true && VehicleContext.getSpeed() == 0) {
			VehicleContext.instance().showOffState();
			VehicleContext.setOn(false);
		}
	}

	/**
	 * Method for when the State is left
	 */
	@Override
	public void leave() {
		VehicleContext.instance().showOnState();
	}

	/**
	 * Method for when the break pedal is pressed
	 */
	@Override
	public void pressBreakPedal() {
		// Do nothing as car is off
	}

	/**
	 * Method for when the gas pedal is pressed
	 */
	@Override
	public void pressGasPedal() {
		// Do nothing as car is off
	}

	/**
	 * Method for when the break pedal is pressed
	 */
	@Override
	public boolean breakPedalIsPressed() {
		return VehicleContext.getisBreaking();
	}

}
