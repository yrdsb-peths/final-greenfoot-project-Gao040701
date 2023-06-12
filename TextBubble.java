import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * text bubble - start text when clicked 
 * 
 * @author Angela
 * @version 06/06/2023
 */
public class TextBubble extends Actor
{
    
    public void act()
    {
        startText();
    }
    public void startText(){
        if (Greenfoot.mouseClicked(this)){
            getWorld().addObject(new Thorns(), 100, 400);
            getWorld().addObject(new TextBox(), 300, 300);
        }
    }
    
}
