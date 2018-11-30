package states;

import timer.Notifiable;
import timer.Timer;

public class AcceleratingState extends StateAdapter implements Notifiable{

	private static AcceleratingState instance;
	 private Timer timer;
	 
	private AcceleratingState() {
	}
	
    public static AcceleratingState instance() {
        if (instance == null) {
            instance = new AcceleratingState();
        }
        return instance;
    }
	
	@Override
	public void timerTicked(int timeLeft) {
		if(VehicleContext.getSpeed() == 50) {
			
		}else {
			VehicleContext.setSpeed(VehicleContext.getSpeed() + 5);
			VehicleContext.instance().showSpeed();
		}
		
	}

	//Dont need this?
	@Override
	public void timerRanOut() {
		// Doesn't do anything because no time
		
	}

	@Override
	public void enter() {
		timer = new Timer(this);
		VehicleContext.instance().showAcceleratingState();
		
	}

	@Override
	public void leave() {
		timer.stop();
        timer = null;
        VehicleContext.instance().showDriveState();
		
	}

	@Override
	public void pressBreakPedal() {
		VehicleContext.instance().changeState(BrakingState.instance());
	}

	@Override
	public void pressGasPedal() {
		//Do nothing as we are already in this state.
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
