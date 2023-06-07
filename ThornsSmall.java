import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Thorns that will present in a map
 * 
 * @author Angela 
 * @version 06/06/2023
 */
public class ThornsSmall extends Speakers
{
    GreenfootImage thornsSmall = new GreenfootImage ("images/Speakers/ThormsSmall.png");
    public void act()
    {
        createBubble();
    }
    public ThornsSmall(){
        thornsSmall.scale(200,200);
        setImage(thornsSmall);
    }
    public void createBubble(){
        GameTwo world = (GameTwo) getWorld();
        if (isTouching(Cat.class)){
            world.addBubble(380, 60);
        }else{
            world.removeBubble();
        }
    }
}
