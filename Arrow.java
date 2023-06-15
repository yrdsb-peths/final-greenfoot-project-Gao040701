import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Arrow
 * 
 * @author Angela 
 * @version 06/14/2023
 */
public class Arrow extends NonSolids
{
    GreenfootImage arrow = new GreenfootImage("images/arrow.png");
    public void act()
    {
        
    }
    public Arrow(){
        arrow.scale(30, 30);
        setImage(arrow);
    }
}
