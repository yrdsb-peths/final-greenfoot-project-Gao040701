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
        
        StartButton startButton = new StartButton();
        addObject(startButton, 300, 300);
        TutorialButton tutorialButton = new TutorialButton();
        addObject(tutorialButton, 150, 300);
        InstructionButton instruc = new InstructionButton();
        addObject(instruc, 450, 300);
    }
    public void act(){
        
    }
}
