import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * if pressed, pop up a little window of instructions 
 * 
 * @author Angela 
 * @version 06/12/2023
 */
public class InstructionButton extends Actor
{
    GreenfootImage instruc1 = new GreenfootImage("images/buttons/instruction1.png");
    GreenfootImage instruc2 = new GreenfootImage("images/buttons/instruction2.png");
    public void act()
    {
        if (Greenfoot.mouseMoved(this)){
            setImage(instruc2);
        }else{
            setImage(instruc1);
        }
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Instructions());
        }
    }
    public InstructionButton(){
        instruc1.scale(100,100);
        instruc2.scale(90,90);
        setImage(instruc1);
    }
}
