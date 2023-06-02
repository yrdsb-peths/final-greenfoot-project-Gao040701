import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground1 extends Solids
{
    GreenfootImage ground1 = new GreenfootImage("images/landscapes/ground1.png");
    private int height;
    /**
     * Act - do whatever the Ground1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public Ground1(){
        ground1.scale(120, 80);
        setImage(ground1);
        height = 40;
    }
}
