import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * coin
 * 
 * @author Angwla
 * @version 05/31/2023
 */
public class Coin extends Actor
{
    GreenfootImage[] coins = new GreenfootImage[2];
    SimpleTimer animationTimer = new SimpleTimer();
    public Coin(){
        for (int i = 0; i < coins.length; i++){
            coins[i] = new GreenfootImage("images/coins/coin" + i + ".png");
            coins[i].scale(20,20);
        }
        setImage(coins[0]);
        animationTimer.mark();
    }
    private int imageIndex = 0;
    public void act(){
        animateCoin();
    }
    
    public void animateCoin()
    {
        if (animationTimer.millisElapsed() < 200){
            return;
        }
        animationTimer.mark(); 
        imageIndex = (imageIndex + 1) % coins.length;
        setImage(coins[imageIndex]);
    }
}
