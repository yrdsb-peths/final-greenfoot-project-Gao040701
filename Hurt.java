import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * all actors that cause the cat to lose heart
 * 
 * @author Angela 
 * @version 06/06/2023
 */
public class Hurt extends Actor
{
    static int heartVal;
    public void removeCat(int heartLost){
        if (isTouching(Cat.class)){
            removeTouching(Cat.class);
            if (getWorld() instanceof MyWorld){
                MyWorld world = (MyWorld) getWorld();
                world.minusHeartVal(heartLost);
                heartVal = world.heartVal; 
                world.removeObjects(world.getObjects(Heart.class));
                world.setHeart(heartVal);
                if (heartVal > 0){
                    Cat cat = new Cat();
                    world.addObject(cat, 50, 250);
                }
            }else if (getWorld() instanceof GameTwo){
                GameTwo world = (GameTwo) getWorld();
                world.minusHeartVal(heartLost);
                heartVal = world.heartVal; 
                world.removeObjects(world.getObjects(Heart.class));
                world.setHeart(heartVal);
                if (heartVal > 0){
                    Cat cat = new Cat();
                    world.addObject(cat, 50, 250);
                }
            }
        }
    }
}
