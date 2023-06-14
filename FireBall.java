import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * fire ball 
 * 
 * @author Anela 
 * @version 06/14/2023
 */
public class FireBall extends Hurt
{
    GreenfootImage[] fireBalls = new GreenfootImage[5];
    int dy = 0;
    SimpleTimer animationTimer = new SimpleTimer();
    
    public void FireBall(){
        for (int i = 0; i < fireBalls.length; i++){
            fireBalls[i] = new GreenfootImage("images/fireBall/FB" + i + ".png");
            fireBalls[i].scale(40, 80);
        }
        setImage(fireBalls[0]);
        animationTimer.mark();
    }
    
    private int imageIndex = 0;
    public void animateFireBall(){
        if (animationTimer.millisElapsed() < 500){
            return;
        }
        animationTimer.mark(); 
        imageIndex = (imageIndex + 1) % fireBalls.length;
        setImage(fireBalls[imageIndex]);
    }
    
    public void act()
    {
        // animateFireBall();
        
        // Move the fireball
        if (!isTouching(Solids.class) && getY() < 400){
            setLocation(getX(), getY() + 1);
            dy += 1;
        } else {
            setLocation(getX(), 0);
            dy = 0;
        }
        super.removeCat(2);
        
    }
    
    
}
