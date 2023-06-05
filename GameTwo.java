import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game two scene 
 * 
 * @author Angela  
 * @version 06/05/2023
 */
public class GameTwo extends World
{
    static int score = MyWorld.score;
    static int heart = MyWorld.heartVal;
    Label coinLabel;
    public GameTwo()
    {
        super(600, 400, 1,false); 
        
        Water water = new Water();
        addObject(water, 300, 400);
        Cat cat = new Cat ();
        addObject(cat, 10, 250);
        Ground1 ground11 = new Ground1();
        addObject(ground11, 0, 350);
        createBar(ground11);
        Ground1 ground12 = new Ground1();
        addObject(ground12, 200,270);
        createBar(ground12);
        
        coinLabel = new Label(score,50);
        addObject(coinLabel, 50, 50);
        Heart heart = new Heart();
        addObject(heart, 80, 100);
    }
    public void IncreaseScore(){
        score++;
        coinLabel.setValue(score);
    }
    public void createBar(Solids solid){
        int x = solid.getX();
        int y = solid.getY();
        int height = solid.getImage().getHeight();
        int width = solid.getImage().getWidth();
        LeftBarrier leftBarrier = new LeftBarrier(5,height-10,90);
        RightBarrier rightBarrier = new RightBarrier(5,height-10,90);
        addObject(leftBarrier, x-width/2, y);
        addObject(rightBarrier, x+width/2, y);
    }
}
