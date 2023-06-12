import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * create a new game 
 * 
 * @author Angela
 * @version 06/11/2023
 */
public class NewGameButton extends Actor
{
    GreenfootImage newGame1 = new GreenfootImage("images/buttons/newGame1.png");
    GreenfootImage newGame2 = new GreenfootImage("images/buttons/newGame2.png");
    public void act()
    {
        if (Greenfoot.mouseMoved(this)){
            setImage(newGame2);
        }else{
            setImage(newGame1);
        }
        if (Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new Random());
        }
    }
    public NewGameButton(){
        newGame1.scale(100,100);
        newGame2.scale(90,90);
        setImage(newGame1);
    }
}
