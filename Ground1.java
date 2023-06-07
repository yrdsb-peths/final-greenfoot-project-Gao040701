import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Ground(type 1)
 * 
 * @author Angela 
 * @version 06/06/2023
 */
public class Ground1 extends Solids
{
    GreenfootImage ground1 = new GreenfootImage("images/landscapes/ground1.png");
    private int height;
    public Ground1(){
        ground1.scale(120, 80);
        setImage(ground1);
        height = 40;
    }
}
