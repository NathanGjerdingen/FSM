
public class VehicleContext {
	private VehilcleDisplay display;
	private StateAdapter currentState;
	private static VehicleContext instance;
	private static int speed = 0;
	
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

	public void setDisplay(VehilcleDisplay display) {
		this.display = display;
	}

	public void showDriveState() {
		GUI.showDriveState();
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

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		VehicleContext.speed = speed;
	}

	public void showSpeed() {
		GUI.showSpeed(speed);
		
	}

	public void showAcceleratingState() {
		// TODO Auto-generated method stub
		
	}

	public void showBrakingState() {
		// TODO Auto-generated method stub
		
	}
}
