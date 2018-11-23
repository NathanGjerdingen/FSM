
public abstract class StateAdapter {

	// Methods for transitioning from state-to-state...
    public abstract void enter();
    public abstract void leave();
    
    // Methods all states will have...
    public abstract boolean pressBreakPedal();
    public abstract boolean pressGasPedal();
    
    // Boolean methods to check if pedals are currently pressed...
    public abstract boolean breakPedalIsPressed();
    public abstract boolean gasPedalIsPressed();
    
}
