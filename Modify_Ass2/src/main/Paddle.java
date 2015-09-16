package main;
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Dimensions
{
    int dx;
    // Constructor
    public Paddle(int x, int y, int width, int height, Color color)
    {
        super(x, y, width, height, color);
    }

    // Draws the paddle
    @Override
    public void draw(Graphics g)
    {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    // Places the paddle back in starting position at center of screen
    public void reset()
    {
    	x = PADDLE_X_START;
    	y = PADDLE_Y_START;
    }

    // Checks if the ball hit the paddle
    public boolean hitPaddle(int ballX, int ballY)
    {
        if ((ballX >= x) && (ballX <= x + width) && ((ballY >= y) && (ballY <= y + height))) 
        {
            return true;
        }
        return false;
    }
    
	public void move()
	{
		if (x <= Boundaries.PADDLELEFT)
		{
			x = Boundaries.PADDLELEFT;
		}
		if (x >= Boundaries.PADDLERIGHT - width)
		{
			x = Boundaries.PADDLERIGHT - width;
		}
		x += dx;
	}

	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) 
		{
			dx = -2;
		}

		if (key == KeyEvent.VK_RIGHT) 
		{
			dx = 2;
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) 
		{
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) 
		{
			dx = 0;
		}
	}

	public void resetState() 
	{
		x = (Constants.WINDOW_WIDTH / 2) - 30;
		y = 460;
	}
}