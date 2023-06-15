import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * enemy
 * 
 * @author Angela
 * @version 06/06/2023
 */
public class Enemy extends Hurt
{
    GreenfootImage[] enemy = new GreenfootImage[3];
    SimpleTimer animationTimer = new SimpleTimer();
    public Enemy()
    {
        for (int i = 0; i < enemy.length; i++){
            enemy[i] = new GreenfootImage("images/enemy/enemy" + i + ".png");
            enemy[i].scale(50,50);
        }
        setImage(enemy[0]);
        animationTimer.mark();
    }
    private int imageIndex = 0;
    public void act(){
        if (getWorld().getObjects(TextBox.class)!=null){
            if (!TextBox.getIsTalking()){
                animateEnemy();
                constantMove();
                super.removeCat(1);
            }
        }
    }
    
    /**
     * animate the enemy 
     */
    public void animateEnemy()
    {
        if (animationTimer.millisElapsed() < 200){
            return;
        }
        animationTimer.mark(); 
        imageIndex = (imageIndex + 1) % enemy.length;
        setImage(enemy[imageIndex]);
    }
    int fadeAmount = 3;
    int volume = 0;
    
    /**
     * moe the enemy up and down 
     */
    public void constantMove(){
        setLocation(getX(),getY() + fadeAmount);
        volume += fadeAmount;
        if (volume <= 0 || volume >= 300){
            fadeAmount = -fadeAmount;
        }
    }
}
