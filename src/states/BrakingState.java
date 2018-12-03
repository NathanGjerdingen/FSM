package states;

import timer.Notifiable;
import timer.Timer;

/**
 * Breaking state for FSM
 */
public class BrakingState extends StateAdapter implements Notifiable {

	/**
	 * Set up instance and timer for state
	 */
	private static BrakingState instance;
	private Timer timer;

	/**
	 * Private constructor to implement Singleton pattern
	 */
	private BrakingState() {
	}

	/**
	 * Instance method for implementing Singleton pattern
	 * 
	 * @return instance
	 */
	public static BrakingState instance() {
		if (instance == null) {
			instance = new BrakingState();
		}
		return instance;
	}

	/**
	 * Method for when the timer ticks
	 */
	@Override
	public void timerTicked(int timeLeft) {
		if (VehicleContext.getSpeed() == 0) {
			VehicleContext.instance().changeState(DriveState.instance());
		} else {
			VehicleContext.setSpeed(VehicleContext.getSpeed() - 5);
			VehicleContext.instance().showSpeed();
		}
	}
	
	/**
	 * Method for when the timer runs out
	 */
	@Override
	public void timerRanOut() {
		// TODO Auto-generated method stub

	}

	/**
	 * Method for when the State is entered
	 */
	@Override
	public void enter() {
		timer = new Timer(this);
		VehicleContext.setisBreaking(true);
		VehicleContext.setParked(false);
		VehicleContext.instance().showBrakingState();

	}

	/**
	 * Method for when the State is left
	 */
	@Override
	public void leave() {
		timer.stop();
		timer = null;
		VehicleContext.instance().showDriveState();
		VehicleContext.setParked(true);
	}

	/**
	 * Method for when the break pedal is pressed
	 */
	@Override
	public void pressBreakPedal() {
		// Do nothing as we are already in braking state
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
	 */
	@Override
	public boolean breakPedalIsPressed() {
		// Return true as we are already in braking state
		return true;
	}

}
