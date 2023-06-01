import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Barrier here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Barrier extends Actor
{
    /**
     * Act - do whatever the Barrier wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Barrier(int thick, int len, int rot)
    {
        updateImage(len, thick, rot);
    }
    private void updateImage(int length, int thickness, int rotation)
    {
        GreenfootImage img = new GreenfootImage(length, thickness);
        //img.setColor(Color.BLUE);
        img.setTransparency(255);
        img.fill();
        setRotation(rotation);
        setImage(img);
    }

}
