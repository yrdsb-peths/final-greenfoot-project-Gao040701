import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game two scene 
 * 
 * @author Angela  
 * @version 06/05/2023
 */
public class GameTwo extends World
{
    public GameTwo()
    {
        super(600, 400, 1); 
        
        Water water = new Water();
        addObject(water, 300, 500);
        Cat cat = new Cat ();
        addObject(cat, 100, 250);
        Ground1 ground11 = new Ground1();
        addObject(ground11, 60, 350);
        createBar(ground11);
        Ground1 ground12 = new Ground1();
        addObject(ground12, 200,300);
        createBar(ground12);
    }
    public void IncreaseScore(){
        World world = new MyWorld();
        //world.score ++;
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
