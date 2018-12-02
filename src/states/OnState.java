package states;

import timer.Notifiable;

public class OnState extends StateAdapter implements Notifiable{
	
	private static OnState instance;
	
	private OnState() {
	}
	
    public static OnState instance() {
        if (instance == null) {
            instance = new OnState();
        }
        return instance;
    }
	
	@Override
	public void timerTicked(int timeLeft) {
		//do nothing
		
	}

	@Override
	public void timerRanOut() {
		//doesnt do anything
		
	}

	@Override
	public void enter() {
		VehicleContext.instance().showOnState();
		VehicleContext.setParked(true);
	}

	@Override
	public void leave() {
		
	}

	@Override
	public void pressBreakPedal() {
		//Does nothing? Car isnt moving
		
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
