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
            GameTwo world = (GameTwo) getWorld();
            Thorns thorns = new Thorns();
            world.addCharacter(thorns);
            TextBox box = new TextBox();
            world.addTextBox(box);
        }
    }
    
}
