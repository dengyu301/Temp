package main;

import java.awt.Color;

public interface Constants {
/**
 * Constants class
 * 
 * Defines number for bricks, the width and height of the frame.
 * 
 */
	// Window Size
	public static final int WINDOW_WIDTH = 500;
	public static final int WINDOW_HEIGHT = 500;
	
	// Ball
	public static final int BALL_WIDTH = 10;
	public static final int BALL_HEIGHT = 10;
	public static final int BALL_RIGHT_BOUND = 490;
	public static final int BALL_X_START = 245;
	public static final int BALL_Y_START = 245;
	
	// Paddle
	public static final int PADDLE_WIDTH = 70;
	public static final int PADDLE_HEIGHT = 10;
	public static final int PADDLE_RIGHT_BOUND = 430;
	public static final int PADDLE_X_START = 225;
	public static final int PADDLE_Y_START = 350;
	public static final int PADDLE_MIN = 35;
	public static final int PADDLE_MAX = 140;

	
	//Brick Colors
	public static final Color BLUE_BRICK_ONE = new Color(0,0,255);
	public static final Color BLUE_BRICK_TWO = new Color(28,134,238);
	public static final Color BLUE_BRICK_THREE = new Color(0,191,255);
	public static final Color RED_BRICK_ONE = new Color(255,0,0);
	public static final Color RED_BRICK_TWO = new Color(255,106,106);
	public static final Color RED_BRICK_THREE = new Color(238,180,180);
	public static final Color PURPLE_BRICK_ONE = new Color(128,0,128);
	public static final Color PURPLE_BRICK_TWO = new Color(148,0,211);
	public static final Color PURPLE_BRICK_THREE = new Color(155,48,255);
	public static final Color YELLOW_BRICK_ONE = new Color(255,215,0);
	public static final Color YELLOW_BRICK_TWO = new Color(255,255,0);
	public static final Color YELLOW_BRICK_THREE = new Color(255,246,143);
	public static final Color PINK_BRICK_ONE = new Color(205,0,205);
	public static final Color PINK_BRICK_TWO = new Color(238,130,238);
	public static final Color PINK_BRICK_THREE = new Color(255,225,255);
	public static final Color GRAY_BRICK_ONE = new Color(77,77,77);
	public static final Color GRAY_BRICK_TWO = new Color(125,125,125);
	public static final Color GRAY_BRICK_THREE = new Color(189,189,189);
	public static final Color GREEN_BRICK_ONE = new Color(0,139,0);
	public static final Color GREEN_BRICK_TWO = new Color(0,205,0);
	public static final Color GREEN_BRICK_THREE = new Color(0,255,0);
	
	// Bricks
	public static final int BRICK_WIDTH = 50;
	public static final int BRICK_HEIGHT = 25;
	public static final int MAX_BRICKS = 50;
	public static final int NO_BRICKS = 0;
	public static final int BRICK_ROWS = 10;
	public static final int BRICK_COLUMNS = 5;
	public static final int TOTALBRICKS = BRICK_ROWS * BRICK_COLUMNS;

}