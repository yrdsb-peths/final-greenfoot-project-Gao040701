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
    private int score;
    private int heartVal;
    Label coinLabel;
    public GameTwo(int score, int heartVal)
    {
        super(600, 400, 1,false); 
        
        this.score = score;
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
        Enemy enemy = new Enemy();
        addObject(enemy, 200, 100);
        
        coinLabel = new Label(score,50);
        addObject(coinLabel, 50, 50);
        Heart heart = new Heart(heartVal);
        addObject(heart, 80, 100);
        
        Cat cat = new Cat ();
        addObject(cat, 10, 250);
    }
    public void IncreaseScore(){
        score++;
        coinLabel.setValue(score);
    }
    public void act(){
        if (heartVal <= 0){
            Greenfoot.setWorld(new GameOver());
        }
    }
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
    
    public int getHeartVal(){
        return heartVal;
    }
    public void minusHeartVal(int val){
        heartVal -= val;
    }
    public void setHeart(int heartLeft){
        Heart heart = new Heart(heartLeft);
        addObject(heart, 80, 100);
    }
    public void addBubble(int x, int y){
        TextBubble bubble = new TextBubble();
        addObject(bubble, x, y);
    }
    public void removeBubble(){
        removeObjects(getObjects(TextBubble.class));
    }
    public void addCharacter(Actor actor){
        addObject(actor, 100, 400);
    }
    public void removeCharacter(){
        removeObjects(getObjects(Speakers.class));
    }
    public void addTextBox(TextBox box){
        addObject(box, 300, 300);
    }
    public void removeTextBox(TextBox box){
        removeObjects(getObjects(TextBox.class));
    }
    public void addText(Label label){
        addObject(label, 300, 300);
    }
    public void removeLabel(){
        removeObjects(getObjects(Label.class));
        coinLabel = new Label(score,50);
        addObject(coinLabel, 50, 50);
    }
    public void toNextThree(){
        Greenfoot.setWorld(new GameThree(score, heartVal));
    }
}
