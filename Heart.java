import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Heart
 * 
 * @author Angela 
 * @version 06/05/2023
 */
public class Heart extends Actor
{
    GreenfootImage[] heart = new GreenfootImage[7];
    public Heart()
    {
        for (int i = 0; i < heart.length; i++){
            heart[i] = new GreenfootImage("images/heart/heart" + i + ".png");
            heart[i].scale(112, 36);
        }
        setImage(heart[0]);
    }
    public Heart(int heartLeft){
        for (int i = 0; i < heart.length; i++){
            heart[i] = new GreenfootImage("images/heart/heart" + i + ".png");
            heart[i].scale(112, 36);
        }
        setImage(heart[6-heartLeft]);
    }
}
