import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Over scene
 * 
 * @author Angela 
 * @version 06/09/2023
 */
public class GameOver extends World
{
    int finalScore;
    Label finalScoreLabel = new Label(finalScore, 70);
    public GameOver(int finalScore)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        this.finalScore = finalScore;
        finalScoreLabel.setValue(finalScore);
        addObject(finalScoreLabel, 300, 150);
    }
    public void act(){
        restart();
    }
    public void restart(){
        if (Greenfoot.isKeyDown("shift")){
            Greenfoot.setWorld(new TitleScreen());
        }
    }
}
