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
    private int spd;
    SimpleTimer animationTimer = new SimpleTimer();
    public FireBall(int spd){
        for (int i = 0; i < fireBalls.length; i++){
            fireBalls[i] = new GreenfootImage("images/fireBall/FB" + i + ".png");
            fireBalls[i].scale(40, 80);
        }
        setImage(fireBalls[0]);
        animationTimer.mark();
        this.spd = spd;
    }
    
    private int imageIndex = 0;
    public void animateFireBall(){
        if (animationTimer.millisElapsed() < 100){
            return;
        }
        animationTimer.mark(); 
        imageIndex = (imageIndex + 1) % fireBalls.length;
        setImage(fireBalls[imageIndex]);
    }
    
    public void act()
    {
        animateFireBall();
        
        // Move the fireball
        if (!isTouching(Solids.class) && getY() < 400 && !isTouching(Cat.class)){
            setLocation(getX(), getY() + spd);
        } else {
            super.removeCat(2);
            setLocation(Greenfoot.getRandomNumber(600), 0);
        }
        
    }
    
    public int getSpd(){
        return spd;
    }
    public void increaseSpd(){
        spd++;
    }
    public void setSpd(int theSpd){
        spd = theSpd;
    }
}
