import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * go back to titleScreen
 * 
 * @author Angela
 * @version 06/11/2023
 */
public class HomeButton extends Actor
{
    GreenfootImage home1 = new GreenfootImage("images/buttons/home1.png");
    GreenfootImage home2 = new GreenfootImage("images/buttons/home2.png");
    GreenfootSound click = new GreenfootSound("clickSound.mp3");
    public void act()
    {
        if (Greenfoot.mouseMoved(this)){
            setImage(home2);
        }else{
            setImage(home1);
        }
        if (Greenfoot.mouseClicked(this)){
            click.play();
            Greenfoot.setWorld(new TitleScreen());
        }
    }
    public HomeButton(){
        home1.scale(100,100);
        home2.scale(90,90);
        setImage(home1);
    }
}
