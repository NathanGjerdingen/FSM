

/**
 * Specifies what the display system should do. Note that the implementation has
 * a lot of freedom to choose its display.
 */
public interface VehilcleDisplay {
	/**
	 * Displays the cook time remaining
	 * 
	 * @param time remaining time
	 */
	public void showMilesPerHour(int speed);

	/**
	 * Indicate that the light is on
	 */
	public void showCarOn();

	/**
	 * Indicate that the light is off
	 */
	public void showCarOff();

	/**
	 * Indicate that the door is now closed
	 */
	public void showCarParked();

	/**
	 * Indicate that the door is now open
	 */
	public void showCarDrive();

	/**
	 * indicate that cooking has begun
	 */
	public void showAccelerating();

	/**
	 * indicate that cooking has ended
	 */
	public void showBraking();
}