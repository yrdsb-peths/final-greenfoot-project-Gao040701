import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * fire ball 
 * 
 * @author Anela 
 * @version 06/14/2023
 */
public class FireBall extends Hurt
{
    GreenfootImage[] fireBall = new GreenfootImage[5];
    int dy = 0;
    SimpleTimer animationTimer = new SimpleTimer();
    public void act()
    {
        animateFireBall();
        move();
        super.removeCat(2);
        
    }
    public void FireBall(){
        for (int i = 0; i < fireBall.length; i++){
            fireBall[i] = new GreenfootImage("images/fireBall/FB" + i + ".png");
            fireBall[i].scale(40, 80);
        }
        setImage(fireBall[0]);
        animationTimer.mark();
    }
    private int imageIndex = 0;
    public void animateFireBall(){
        if (animationTimer.millisElapsed() < 100){
            return;
        }
        animationTimer.mark(); 
        imageIndex = (imageIndex + 1) % fireBall.length;
        setImage(fireBall[imageIndex]);
    }
    public void move(){
        while (!isTouching(Solids.class) && !(getY() >= 400)){
            setLocation(getX(), getY() + dy);
            dy+=0.5;
        }
        if (isTouching(Solids.class) || getY() >= 400){
            setLocation(getX(), 0);
            dy = 0;
        }
    }
}
