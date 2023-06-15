import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Two scene 
 * meet Thorns 
 * 
 * @author Angela  
 * @version 06/05/2023
 */
public class GameTwo extends World
{
    private int coin;
    private int heartVal;
    Label coinLabel;
    public GameTwo(int coin, int heartVal)
    {
        super(600, 400, 1,false); 
        
        this.coin = coin;
        this.heartVal = heartVal;
        
        Water water = new Water();
        addObject(water, 300, 400);
        Ground1 ground11 = new Ground1();
        addObject(ground11, 0, 350);
        createBar(ground11);
        Ground1 ground12 = new Ground1();
        addObject(ground12, 200, 270);
        createBar(ground12);
        Ground1 ground13 = new Ground1();
        addObject(ground13, 400, 190);
        createBar(ground13);
        ThornsSmall thornsSmall = new ThornsSmall();
        addObject(thornsSmall, 400, 90);
        Ground1 ground14 = new Ground1();
        addObject(ground14, 600, 400);
        createBar(ground14);
        Arrow arrow = new Arrow();
        addObject(arrow, 560, 345);
        Enemy enemy = new Enemy();
        addObject(enemy, 200, 100);
        
        coinLabel = new Label(coin,50);
        addObject(coinLabel, 50, 50);
        Heart heart = new Heart(heartVal);
        addObject(heart, 80, 100);
        
        Cat cat = new Cat ();
        addObject(cat, 10, 250);
    }
    
    public void act(){
        if (heartVal <= 0){
            Greenfoot.setWorld(new GameOver(0, "tutorial"));
        }
    }
    
    /**
     * increase coin value by 1
     */
    public void increaseCoin(){
        coin++;
        coinLabel.setValue(coin);
    }
    
    /**
     * decrease the coin value by a specific amount 
     */
    public void decreaseCoin(int num){
        coin-= num;
        coinLabel.setValue(coin);
    }
    
    /**
     * get the current number of coins 
     */
    public int getCoin(){
        return coin;
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
     * remove the textBubbles
     */
    public void removeBubble(){
        removeObjects(getObjects(TextBubble.class));
    }
    
    /**
     * remove the NPC
     */
    public void removeCharacter(){
        removeObjects(getObjects(Speakers.class));
    }
    
    /**
     * remove the textBoxes
     */
    public void removeTextBox(TextBox box){
        removeObjects(getObjects(TextBox.class));
    }
    
    /**
     * add the NPC's words
     */
    public void addText(Label label){
        addObject(label, 300, 300);
    }
    
    /** 
     * remove the NPC's words
     */
    public void removeLabel(){
        removeObjects(getObjects(Label.class));
        coinLabel = new Label(coin,50);
        addObject(coinLabel, 50, 50);
    }
}
