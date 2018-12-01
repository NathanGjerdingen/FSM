package states;

import timer.Notifiable;
import timer.Timer;

public class BrakingState extends StateAdapter implements Notifiable {

	private static BrakingState instance;
	private Timer timer;

	private BrakingState() {
	}

	public static BrakingState instance() {
		if (instance == null) {
			instance = new BrakingState();
		}
		return instance;
	}

	@Override
	public void timerTicked(int timeLeft) {
		if (VehicleContext.getSpeed() == 0) {
			VehicleContext.instance().changeState(DriveState.instance());
		}
		else {
			VehicleContext.setSpeed(VehicleContext.getSpeed() - 5);
			VehicleContext.instance().showSpeed();
		}

	}

	@Override
	public void timerRanOut() {
		// TODO Auto-generated method stub

	}

	@Override
	public void enter() {
		timer = new Timer(this);
		VehicleContext.setisBreaking(true);
		VehicleContext.instance().showBrakingState();

	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		VehicleContext.setisBreaking(false);
		VehicleContext.instance().showDriveState();
	}

	@Override
	public void pressBreakPedal() {
		// Do nothing as we are already in braking state

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
