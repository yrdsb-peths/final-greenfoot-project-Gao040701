import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * titleScreen
 * 
 * @author Angela 
 * @version 06/08/2023
 */
public class TitleScreen extends World
{
    GreenfootImage titleScreen  = new GreenfootImage("images/titleScreen.png");
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        titleScreen.scale(600, 400);
        setBackground(titleScreen);
    }
    public void act(){
        Tutorial();
        Game();
    }
    public void Tutorial(){
        if (Greenfoot.isKeyDown("space")){
            Greenfoot.setWorld(new GameOne());
        }
    }
    public void Game(){
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Random());
        }
    }
}
