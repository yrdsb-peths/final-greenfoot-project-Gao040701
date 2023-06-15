import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * fire ball 
 * 
 * @author Angela 
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
    /**
     * animate the fire ball 
     */
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
        if (getWorld().getObjects(TextBox.class)!=null){
            if (!TextBox.getIsTalking()){
                animateFireBall();
                // Move the fireball
                move();
            }
        }
    }
    
    /**
     * set the speed of the fire ball
     */
    public void setSpd(int theSpd){
        spd = theSpd;
    }
    
    /**
     * the fire ball fall down in a constant speed and restartwhen touching cat or solid 
     */
    public void move(){
        if (!isTouching(Solids.class) && getY() < 400 && !isTouching(Cat.class)){
            setLocation(getX(), getY() + spd);
        } else {
            super.removeCat(1);
            setLocation(Greenfoot.getRandomNumber(600), 0);
        }
    }
}
