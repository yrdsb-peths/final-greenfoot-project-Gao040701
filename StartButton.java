import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * start button on the title screen
 * 
 * @author Angela 
 * @version 06/11/2023
 */
public class StartButton extends Actor
{
    GreenfootImage startButton1 = new GreenfootImage("images/buttons/startButton1.png");
    GreenfootImage startButton2 = new GreenfootImage("images/buttons/startButton2.png");
    public void act()
    {
        if (Greenfoot.mouseMoved(this)){
            setImage(startButton2);
        }else{
            setImage(startButton1);
        }
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Random());
        }
    }
    public StartButton(){
        startButton1.scale(100,100);
        startButton2.scale(90,90);
        setImage(startButton1);
    }
}