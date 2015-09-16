package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Clock  extends Dimensions implements Observer 
{
    private static final int MILLISEC_TO_SEC = 1000;
    private int time;
    
    public Clock(int x, int y, int width, int height, Color color) 
    {
        super(x, y, width, height, color);
        time = 0;
    }
    
    @Override
    public void draw(Graphics g) 
    {
        g.setColor(color);
        Font currentFont = g.getFont();
        Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
        g.setFont(newFont);
        int mm = time / MILLISEC_TO_SEC / 60 % 60;
        int ss = time / MILLISEC_TO_SEC % 60;
        g.drawString(String.format("%02d:%02d", mm, ss), x, y);
        g.setFont(currentFont);
    }

    @Override
    public void update(int timeStep) 
    {
        time = (time + timeStep) % (3600 * MILLISEC_TO_SEC);
    }
}