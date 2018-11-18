package timerREF;

/**
 * An entity that can be notified of timing events
 * 
 * @author Brahma Dathan
 *
 */
public interface Notifiable {
    /**
     * Process timer ticks
     */
    public void timerTicked(int timeLeft);

    /**
     * Process timer runs out event
     */
    public void timerRanOut();
}
