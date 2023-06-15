import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Thorns - one of the speaker, can heal the cat 
 * 
 * @author Angela
 * @version 06/06/2023
 */
public class Thorns extends Speakers
{
    GreenfootImage thorns = new GreenfootImage("images/Speakers/Thorns.png");
    public void act()
    {
        // Add your action code here.
    }
    public Thorns(){
        thorns.scale(700, 740);
        setImage(thorns);
    }
    
}
