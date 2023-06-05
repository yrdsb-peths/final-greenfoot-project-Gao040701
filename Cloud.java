import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * cloud 
 * 
 * @author Angela
 * @version 06/05/2023
 */
public class Cloud extends Solids
{
    GreenfootImage cloud = new GreenfootImage("images/landscapes/cloud.png");
    private int height;
    public void act()
    {
        // Add your action code here.
    }
    public Cloud(){
        cloud.scale(60, 20);
        setImage(cloud);
        height = 10;
    }
}
