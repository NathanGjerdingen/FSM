package states;
import display.*;
public class VehicleContext {
	private VehicleDisplay display;
	private StateAdapter currentState;
	private static VehicleContext instance;
	private static int speed = 0;
	private static boolean isBreaking = true;
	private static boolean isParked = true;
	
	private VehicleContext() {
		instance = this;
		currentState = OffState.instance();
	}

	public static VehicleContext instance() {
		if (instance == null) {
			instance = new VehicleContext();
		}
		return instance;
	}

	public void setDisplay(VehicleDisplay display) {
		this.display = display;
	}

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
	
	public void gasPedalPressed() {
		currentState.pressGasPedal();
	}
	
	public void brakePendalPress(){
		currentState.pressBreakPedal();
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		VehicleContext.speed = speed;
	}

	public void showSpeed() {
		display.showMilesPerHour(speed);
	}

	public void showAcceleratingState() {
		display.showAccelerating();
	}

	public void showBrakingState() {
		display.showBraking();
	}
	
	public void showParkedState() {
		display.showCarParked();
	}

	public void showOnState() {
		display.showCarOn();
	}

	public void showOffState() {
		display.showCarOff();
	}

	public static boolean getisBreaking() {
		return isBreaking;
	}

	public static void setisBreaking(boolean isBreaking) {
		VehicleContext.isBreaking = isBreaking;
	}

	public void parkCar() {
		if(speed == 0 && isBreaking == true) {
			changeState(ParkState.instance());
		}
	}
	
	public void turnCarOff() {
		if (isParked == true) {
			changeState(OffState.instance());
		}
	}

	public void driveCar() {
		if (isParked == true) {
			changeState(DriveState.instance());
		}
	}

	public static boolean isParked() {
		return isParked;
	}

	public static void setParked(boolean isParked) {
		VehicleContext.isParked = isParked;
	}
}
