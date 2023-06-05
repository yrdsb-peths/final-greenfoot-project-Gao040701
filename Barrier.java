import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Barrier - created on the left and right side of Solids
 * prevent the cat from stuch into the solid 
 * 
 * @author Angela 
 * @version 06/02/2023 
 */
public class Barrier extends Actor
{
    public Barrier(int thick, int len, int rot)
    {
        updateImage(len, thick, rot);
    }
    
    private void updateImage(int length, int thickness, int rotation)
    {
        GreenfootImage img = new GreenfootImage(length, thickness);
        //img.setColor(Color.BLUE);
        img.setTransparency(0);
        img.fill();
        setRotation(rotation);
        setImage(img);
    }
}
