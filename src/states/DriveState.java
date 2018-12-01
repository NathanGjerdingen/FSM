package states;

import timer.Notifiable;

public class DriveState extends StateAdapter implements Notifiable{
	
	private static DriveState instance;
	
	private DriveState() {
		
	}
	
    public static DriveState instance() {
        if (instance == null) {
            instance = new DriveState();
        }
        return instance;
    }

	@Override
	public void timerTicked(int timeLeft) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timerRanOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter() {
		VehicleContext.instance().showDriveState();
		
	}

	@Override
	public void leave() {
		//idk
		
	}

	@Override
	public void pressBreakPedal() {
		VehicleContext.instance().changeState(BrakingState.instance());
		
	}

	@Override
	public void pressGasPedal() {
		VehicleContext.instance().changeState(AcceleratingState.instance());
		
	}

	@Override
	public boolean breakPedalIsPressed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean gasPedalIsPressed() {
		// TODO Auto-generated method stub
		return false;
	}

}
