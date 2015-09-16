package main;

/**
 * Boundaries interface
 *
 * Initializes constants for boundaries for frame, panels, ball and paddle.
 * 
 */

public interface Boundaries 
{
	public static final int WIDTH = Constants.WINDOW_WIDTH;
	public static final int HEIGHT = Constants.WINDOW_HEIGHT;
	public static final int BOTTOM = (Constants.WINDOW_HEIGHT - 82);
	public static final int PADDLERIGHT = (Constants.WINDOW_WIDTH - 10);
	public static final int PADDLELEFT = 0;
	public static final int BALLRIGHT = (Constants.WINDOW_WIDTH - 22);
}
