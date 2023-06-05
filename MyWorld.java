import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Scene 1 
 * 
 * @author Angela 
 * @version 05/30/2023
 */
public class MyWorld extends World
{
    int score = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        
        Water water = new Water();
        addObject(water, 300, 500);
        Cat cat = new Cat ();
        addObject(cat, 100, 250);
        Coin coin1 = new Coin();
        addObject(coin1, 440, 310);
        Coin coin2 = new Coin();
        addObject(coin2, 510, 230);
        Ground1 ground11 = new Ground1();
        addObject(ground11, 40,370);
        createBar(ground11);
        Ground1 ground12 = new Ground1();
        addObject(ground12, 200, 400);
        createBar(ground12);
        Ground1 ground13 = new Ground1();
        addObject(ground13, 600, 380);
        createBar(ground13);
        Cloud cloud1 = new Cloud();
        addObject(cloud1, 345, 320);
        createBar(cloud1);
        Cloud cloud2 = new Cloud();
        addObject(cloud2, 440, 330);
        createBar(cloud2);
        Cloud cloud3 = new Cloud();
        addObject(cloud3, 510, 250);
        createBar(cloud3);
    }
    public void IncreaseScore(){
        score++;
    }
    public void createBar(Solids solid){
        int x = solid.getX();
        int y = solid.getY();
        int height = solid.getImage().getHeight();
        int width = solid.getImage().getWidth();
        Barrier leftBarrier = new Barrier(5,height-2,90);
        Barrier rightBarrier = new Barrier(5,height-2,90);
        addObject(leftBarrier, x-width/2, y);
        addObject(rightBarrier, x+width/2, y);
    }
}
