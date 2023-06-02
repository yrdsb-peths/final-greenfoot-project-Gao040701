import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class water here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Water extends NonSolids
{
    GreenfootImage water = new GreenfootImage("images/landscapes/water1.png");
    public void act()
    {
        if (isTouching(Cat.class)){
            removeTouching(Cat.class);
        }
    }
    public Water(){
        //16:3
        water.scale(600, 50);
        setImage(water);
    }
}
