import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game One scene for tutorial  
 * 
 * @author Angela 
 * @version 05/30/2023
 */
public class GameOne extends World
{
    private int coin = 0;
    private int heartVal = 6;
    Label coinLabel;
    public GameOne()
    {    
        super(600, 400, 1,false);
        coin = 0;
        heartVal = 6;
        
        Water water = new Water();
        addObject(water, 300, 400);
        Ground1 ground11 = new Ground1();
        addObject(ground11, 40,370);
        createBar(ground11);
        Ground1 ground12 = new Ground1();
        addObject(ground12, 170, 400);
        createBar(ground12);
        Tree1 tree = new Tree1();
        addObject(tree, 170, 210);
        Ground1 ground13 = new Ground1();
        addObject(ground13, 600, 380);
        createBar(ground13);
        Arrow arrow = new Arrow();
        addObject(arrow, 560, 325);
        Cloud cloud1 = new Cloud();
        addObject(cloud1, 345, 320);
        createBar(cloud1);
        Coin coin1 = new Coin();
        addObject(coin1, 345, 300);
        Cloud cloud3 = new Cloud();
        addObject(cloud3, 510, 250);
        Coin coin2 = new Coin();
        addObject(coin2, 510, 230);
        createBar(cloud3);
        
        coinLabel = new Label(coin,50);
        addObject(coinLabel, 50, 50);
        Heart heart = new Heart(heartVal);
        addObject(heart, 80, 100);
        
        Cat cat = new Cat ();
        addObject(cat, 50, 250);
        
        FireBall fireBall = new FireBall(2);
        addObject(fireBall, 300, 0);
    }
    
    public void act(){
        if (heartVal <= 0){
            Greenfoot.setWorld(new GameOver(0, "tutorial"));
        }
    }
    
    /**
     * increase number of coins by one and reset the coin label 
     */
    public void increaseCoin(){
        coin++;
        coinLabel.setValue(coin);
    }
    
    /**
     * create bars beside each solid to stop the cat
     */
    public void createBar(Solids solid){
        int x = solid.getX();
        int y = solid.getY();
        int height = solid.getImage().getHeight();
        int width = solid.getImage().getWidth();
        LeftBarrier leftBarrier = new LeftBarrier(5,height-5,90);
        RightBarrier rightBarrier = new RightBarrier(5,height-5,90);
        addObject(leftBarrier, x-width/2, y);
        addObject(rightBarrier, x+width/2, y);
    }
    
    /**
     * return the cat's heart value
     */
    public int getHeartVal(){
        return heartVal;
    }
    
    /**
     * decrease the cat's jeart value by a specific number 
     */
    public void minusHeartVal(int val){
        heartVal -= val;
    }
    
    /**
     * set heart value to a specific number 
     */
    public void setHeart(int heartLeft){
        Heart heart = new Heart(heartLeft);
        addObject(heart, 80, 100);
    }
    
    /**
     * go to next roud in the tutorial 
     */
    public void toNextTwo(){
        Greenfoot.setWorld(new GameTwo(coin, heartVal));
    }
}