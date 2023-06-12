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
    GreenfootImage gameOverScreen = new GreenfootImage("images/gameOverScreen.png");
    public GameOver(int finalScore)
    {    
        super(600, 400, 1); 
        
        gameOverScreen.scale(600, 400);
        setBackground(gameOverScreen);
        
        this.finalScore = finalScore;
        finalScoreLabel.setValue(finalScore);
        addObject(finalScoreLabel, 380, 220);
        
        HomeButton homeButton = new HomeButton();
        addObject(homeButton, 200, 330);
        NewGameButton newGame = new NewGameButton();
        addObject(newGame, 400, 330);
    }
    public void act(){
        
    }
}
