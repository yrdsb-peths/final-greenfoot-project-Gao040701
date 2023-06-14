import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The instruction page
 * 
 * @author Angela 
 * @version 06/13/2023
 */
public class Instructions extends World
{
    boolean onPage2 = false;
    boolean previousSpace = false;
    GreenfootImage tutorial1 = new GreenfootImage("images/tutorial1.png");
    GreenfootImage tutorial2 = new GreenfootImage("images/tutorial2.png");
    GreenfootSound click = new GreenfootSound("clickSound.mp3");
    public Instructions()
    {    
        super(600, 400, 1); 
        setBackground(tutorial1);
            }
    public void act(){
        if (Greenfoot.isKeyDown("space") && !onPage2){
            click.play();
            setBackground(tutorial2);
            onPage2 = true;
            previousSpace = true;
        }if (!Greenfoot.isKeyDown("space")){
            previousSpace = false;
        }
        if (onPage2 && Greenfoot.isKeyDown("space") && previousSpace == false){
            click.play();
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
