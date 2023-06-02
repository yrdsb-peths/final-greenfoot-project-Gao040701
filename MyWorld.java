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
        
        Cat cat = new Cat ();
        addObject(cat, 100, 250);
        /*
        addObject(new Barrier(5, 160, 0), 0, 337);
        addObject(new Barrier(5, 80, 0), 215, 360);
        addObject(new Barrier(5, 20, 0), 345, 305);
        addObject(new Barrier(5, 20, 0), 437, 323);
        addObject(new Barrier(5, 20, 0), 515, 280);
        addObject(new Barrier(5, 20, 0), 600, 337);
        addObject(new Barrier(5, 600 ,0), 300, 400);
        */
        //addObject(new Barrier(50, 298, 340), 239, 150);
        //addObject(new Barrier(50, 600, 0), 300, 300);
        //addObject(new Barrier(50, 420, 80), 500, 200);
        //addObject(new Barrier(50, 100, 0), 50, 200);
        Coin coin1 = new Coin();
        addObject(coin1, 440, 310);
        Coin coin2 = new Coin();
        addObject(coin2, 515, 270);
        Ground1 ground1 = new Ground1();
        addObject(ground1, 20,400);
        Cloud cloud1 = new Cloud();
        addObject(cloud1, 345, 320);
    }
    public void IncreaseScore(){
        score++;
    }
}
