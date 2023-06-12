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
        super(600, 400, 1); 
        
        this.finalScore = finalScore;
        finalScoreLabel.setValue(finalScore);
        addObject(finalScoreLabel, 300, 150);
        
        HomeButton homeButton = new HomeButton();
        addObject(homeButton, 200, 300);
        NewGameButton newGame = new NewGameButton();
        addObject(newGame, 400, 300);
    }
    public void act(){
        
    }
}
