
public class VehicleContext {
	private StateAdapter currentState;
	private static VehicleContext instance;

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
	
}