import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * water
 * 
 * @author Angela
 * @version 06/05/2023
 */
public class Water extends NonSolids
{
    static int heartVal;
    GreenfootImage water = new GreenfootImage("images/landscapes/water1.png");
    public void act()
    {
        removeCat();
    }
    public Water(){
        //16:3
        water.scale(600, 50);
        setImage(water);
    }
    public void removeCat(){
        if (isTouching(Cat.class)){
            removeTouching(Cat.class);
            MyWorld world = (MyWorld) getWorld();
            world.minusHeartVal(2);
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
