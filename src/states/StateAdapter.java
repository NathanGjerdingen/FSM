package states;
public abstract class StateAdapter {

	// Methods for transitioning from state-to-state...
    public abstract void enter();
    public abstract void leave();
    
    // Actions that can be done in every state...
    public abstract void pressBreakPedal();
    public abstract void pressGasPedal();
    
    // Boolean methods to check if pedals are currently pressed...
    public abstract boolean breakPedalIsPressed();
    public abstract boolean gasPedalIsPressed();
    
}
