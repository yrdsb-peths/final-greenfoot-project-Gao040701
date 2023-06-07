import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * water
 * 
 * @author Angela
 * @version 06/05/2023
 */
public class Water extends Hurt
{
    static int heartVal;
    GreenfootImage water = new GreenfootImage("images/landscapes/water1.png");
    public void act()
    {
        super.removeCat(2);
    }
    public Water(){
        water.scale(600, 50);
        setImage(water);
    }
}
