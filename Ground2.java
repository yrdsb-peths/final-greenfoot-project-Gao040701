import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ground (type 2)
 * 
 * @author Angela
 * @version 06/06/2023
 */
public class Ground2 extends Solids
{
    GreenfootImage ground2 = new GreenfootImage("images/ground2.png");
    private int height;
    public Ground2(){
        ground2.scale(600, 60);
        setImage(ground2);
        height = 30;
    }
}
