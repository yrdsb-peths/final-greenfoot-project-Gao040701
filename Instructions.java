import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The instruction page
 * 
 * @author Angela 
 * @version 06/13/2023
 */
public class Instructions extends World
{
    int currentPage = 1;
    boolean previousSpace = false;
    GreenfootImage tutorial1 = new GreenfootImage("images/tutorial1.png");
    GreenfootImage tutorial2 = new GreenfootImage("images/tutorial2.png");
    GreenfootImage tutorial3 = new GreenfootImage("images/tutorial3.png");
    GreenfootSound click = new GreenfootSound("clickSound.mp3");
    public Instructions()
    {    
        super(600, 400, 1); 
        setBackground(tutorial1);
            }
    public void act(){
        if (Greenfoot.isKeyDown("space") && currentPage == 1 && !previousSpace){
            previousSpace = true;
            click.play();
            setBackground(tutorial2);
            currentPage = 2;
            Greenfoot.getKey();
        }else if (Greenfoot.isKeyDown("space") && currentPage == 2 && !previousSpace){
            previousSpace = true;
            click.play();
            setBackground(tutorial3);
            currentPage = 3;
            Greenfoot.getKey();
        }
        if (currentPage == 3 && Greenfoot.isKeyDown("space") && !previousSpace){
            click.play();
            Greenfoot.setWorld(new TitleScreen());
        }
        if (!Greenfoot.isKeyDown("space")){
            previousSpace = false;
        }
    }
}
