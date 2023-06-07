import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Object apple
 * 
 * @author Angela 
 * @version 06/07/2023
 */
public class Apple extends Objects
{
    public void act()
    {
        // Add your action code here.
    }
    
    public Apple(){
        super("apple", 0, new GreenfootImage("images/apple.png"));
    }
    public Apple(int num){
        super("apple", num, new GreenfootImage("images/apple.png"));
    }
}
