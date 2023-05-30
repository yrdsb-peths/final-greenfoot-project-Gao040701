import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Scene 1 
 * 
 * @author Angela 
 * @version 05/30/2023
 */
public class MyWorld extends World
{
    int groundLevel = 350;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Cat cat = new Cat ();
        addObject(cat, 0, 350);

    }
    
}
