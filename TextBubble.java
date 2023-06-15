import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * text bubble - start text when clicked 
 * 
 * @author Angela
 * @version 06/06/2023
 */
public class TextBubble extends Actor
{
    GreenfootSound click = new GreenfootSound("clickSound.mp3");
    public void act()
    {
        startText();
    }
    /**
     * start the conservation when text bubble is clicked 
     */
    public void startText(){
        if (Greenfoot.mouseClicked(this)){
            click.play();
            getWorld().addObject(new Thorns(), 100, 400);
            getWorld().addObject(new TextBox(), 300, 300);
        }
    }
    
}
