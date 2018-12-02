package states;

/**
 * Adapter methods that are needed by states
 */
public abstract class StateAdapter {
    public abstract void enter();
    public abstract void leave();
    public abstract void pressBreakPedal();
    public abstract void pressGasPedal();
    public abstract boolean breakPedalIsPressed();
 
}
