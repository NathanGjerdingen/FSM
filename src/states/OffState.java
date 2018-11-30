package states;

import timer.Notifiable;

public class OffState extends StateAdapter implements Notifiable {

	private static OffState instance;

	private OffState() {
	}

	public static OffState instance() {
		if (instance == null) {
			instance = new OffState();
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
		if(VehicleContext.getisBreaking() == true && VehicleContext.getSpeed() == 0) {
			VehicleContext.instance().showOffState();
		}
	}

	@Override
	public void leave() {
		VehicleContext.instance().showOnState();

	}

	@Override
	public void pressBreakPedal() {
		// Do nothing car is off

	}

	@Override
	public void pressGasPedal() {
		// do nothing car is off

	}

	@Override
	public boolean breakPedalIsPressed() {
		return VehicleContext.getisBreaking();
	}

	@Override
	public boolean gasPedalIsPressed() {
		// TODO Auto-generated method stub
		return false;
	}

}
