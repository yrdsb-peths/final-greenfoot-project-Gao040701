import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * tutorial button to start the tutorial 
 * 
 * @author Angela  
 * @version 06/11/2023
 */
public class TutorialButton extends Actor
{
    GreenfootImage tutorialButton1 = new GreenfootImage("images/buttons/tutorialButton1.png");
    GreenfootImage tutorialButton2 = new GreenfootImage("images/buttons/tutorialButton2.png");
    GreenfootSound click = new GreenfootSound("clickSound.mp3");

    public void act()
    {
        if (Greenfoot.mouseMoved(this)){
            setImage(tutorialButton2);
        }else{
            setImage(tutorialButton1);
        }
        if (Greenfoot.mouseClicked(this)){
            click.play();
            Greenfoot.setWorld(new GameOne());
        }
    }
    public TutorialButton(){
        tutorialButton1.scale(100,100);
        tutorialButton2.scale(90,90);
        setImage(tutorialButton1);
    }
}
