
public class BrakingState extends StateAdapter implements Notifiable{

	private static BrakingState instance;
	
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void timerRanOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean pressBreakPedal() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pressGasPedal() {
		// TODO Auto-generated method stub
		return false;
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
