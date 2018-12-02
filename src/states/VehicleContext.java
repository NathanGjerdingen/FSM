package states;
import display.*;

/**
 * Context class to keep track of states within FSM
 */
public class VehicleContext {
	
	/**
	 * Setting up display and states for class
	 */
	private VehicleDisplay display;
	private StateAdapter currentState;
	
	/**
	 * Instance variables needed to be tracked throughout
	 * all states
	 */
	private static int speed = 0;
	private static boolean isBreaking = true;
	private static boolean isParked = true;
	
	/**
	 * Set up instance for class
	 */
	private static VehicleContext instance;
	
	/**
	 * Private constructor to implement Singleton pattern
	 */
	private VehicleContext() {
		instance = this;
		currentState = OffState.instance();
	}

	/**
	 * Instance method for implementing Singleton pattern
	 * 
	 * @return instance
	 */
	public static VehicleContext instance() {
		if (instance == null) {
			instance = new VehicleContext();
		}
		return instance;
	}

	/**
	 * Method to set a display
	 * 
	 * @param display
	 */
	public void setDisplay(VehicleDisplay display) {
		this.display = display;
	}

	/**
	 * Method to show the Drive state
	 */
	public void showDriveState() {
		display.showCarDrive();
	}

	/**
	 * Called from the states to change the current state of the car
	 * 
	 * @param nextState: The next state
	 */
	public void changeState(StateAdapter nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}
	
	/**
	 * Method for when the gas pedal is pressed
	 */
	public void gasPedalPressed() {
		currentState.pressGasPedal();
	}
	
	/**
	 * Method for when the brake pedal is pressed
	 */
	public void brakePendalPress(){
		currentState.pressBreakPedal();
	}

	/**
	 * Accessor for current
	 * 
	 * @return speed
	 */
	public static int getSpeed() {
		return speed;
	}

	/**
	 * Mutator for speed
	 * 
	 * @param speed
	 */
	public static void setSpeed(int speed) {
		VehicleContext.speed = speed;
	}

	/**
	 * Method to update display with speed
	 */
	public void showSpeed() {
		display.showMilesPerHour(speed);
	}

	/**
	 * Method to update display with Accelerating State
	 */
	public void showAcceleratingState() {
		display.showAccelerating();
	}

	/**
	 * Method to update display with Braking State
	 */
	public void showBrakingState() {
		display.showBraking();
	}
	
	/**
	 * Method to update display with Parked State
	 */
	public void showParkedState() {
		display.showCarParked();
	}

	/**
	 * Method to update display with On State
	 */
	public void showOnState() {
		display.showCarOn();
	}

	/**
	 * Method to update display with Off State
	 */
	public void showOffState() {
		display.showCarOff();
	}

	/**
	 * Accessor for if the FSM is braking

	 * @return isBreaking
	 */
	public static boolean getisBreaking() {
		return isBreaking;
	}
	
	/**
	 * Mutator to see if the FSM is currently breaking
	 */
	public static void setisBreaking(boolean isBreaking) {
		VehicleContext.isBreaking = isBreaking;
	}

	/**
	 * Method that puts FSM into Park State
	 * 
	 * Preconditions:
	 * 	-	Speed = 0
	 *  -	isBreaking = true
	 */
	public void parkCar() {
		if(speed == 0 && isBreaking == true) {
			changeState(ParkState.instance());
		}
	}
	
	/**
	 * Method that puts FSM into Off State
	 * 
	 * Preconditions:
	 * 	-	isParked = true
	 */
	public void turnCarOff() {
		if (isParked == true) {
			changeState(OffState.instance());
		}
	}

	/**
	 * Method that puts FSM into Drive state
	 * 
	 * Precondition:
	 * 	-	isParked = true
	 */
	public void driveCar() {
		if (isParked == true) {
			changeState(DriveState.instance());
		}
	}

	/**
	 * Accessor for if the FSM is parked
	 * 
	 * @return isParked
	 */
	public static boolean isParked() {
		return isParked;
	}
	
	/**
	 * Mutator for isParked 
	 * 
	 * @param isParked
	 */
	public static void setParked(boolean isParked) {
		VehicleContext.isParked = isParked;
	}
}
