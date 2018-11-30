package states;

import timer.Notifiable;

public class ParkState extends StateAdapter implements Notifiable{

	private static ParkState instance;
	
	private ParkState() {
	}
	
    public static ParkState instance() {
        if (instance == null) {
            instance = new ParkState();
        }
        return instance;
    }
	
	@Override
	public void timerTicked(int timeLeft) {
		//Does nothing, nothing happens in park
		
	}

	@Override
	public void timerRanOut() {
		//Does nothing no use having this
		
	}

	@Override
	public void enter() {
		VehicleContext.instance().showParkedState();
		
	}

	@Override
	public void leave() {
		VehicleContext.instance().showDriveState();
		
	}

	@Override
	public void pressBreakPedal() {
		//Do nothing as cant break or go in this state
	}

	@Override
	public void pressGasPedal() {
		//Do nothing as cant break or go in this state
	}

	@Override
	public boolean breakPedalIsPressed() {
		//Do nothing as cant break or go in this state
		return false;
	}

	@Override
	public boolean gasPedalIsPressed() {
		//Do nothing as cant break or go in this state
		return false;
	}

}
