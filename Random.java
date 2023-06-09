import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Randomly create a world 
 * 
 * @author Angela 
 * @version 06/08/2023
 */
public class Random extends World
{
    int level = 0;
    int x = 100;
    int y = 400;
    int changeX;
    int changeY;
    int addX;
    int addY;
    int games = 1;
    private int score = 0;
    private int heartVal = 6;
    Label coinLabel;
    Label gameNumLabel;
    int previousNum;
    int numThorns;
    public Random()
    {    
        super(600, 400, 1, false); 
        
        Water water = new Water();
        addObject(water, 300, 400);
        Ground1 ground1 = new Ground1();
        addObject (ground1, 40,370);
        Ground1 ground2 = new Ground1();
        addObject (ground2, 600,370);
        
        randomCreate();
        
        coinLabel = new Label(score,50);
        addObject(coinLabel, 50, 50);
        Heart heart = new Heart(heartVal);
        addObject(heart, 80, 100);
        gameNumLabel = new Label(games, 70);
        addObject(gameNumLabel, 300, 70);
        
        Cat cat = new Cat();
        addObject(cat, 50, 250);

    }
    public void randomCreate(){
        //larger gap if a ground is created. smaller when a cloud 
        numThorns = 0;
        while (x < 440){
            int num = Greenfoot.getRandomNumber(2);
            if (num == 0){
                addX =  80;
                addY = 40;
            }else{
                addX = 120;
                addY = 60;
            }
            if (Greenfoot.getRandomNumber(2) == 0){
                randomPositionPos();
            }else{
                randomPositionNeg();
            }
            if (y + changeY < 50 || y + changeY > 380){
                continue;
            }
            x += changeX;
            y += changeY;
            if (previousNum == 0 && num == 1){
                x += 20;
                y += 20;
            }
            previousNum = num;
            if (num == 0){
                createWithBar(new Cloud(), x, y);
                if (Greenfoot.getRandomNumber(4) == 0){
                    addObject(new Coin(), x, y - 20);
                }
            }else{
                createWithBar(new Ground1(), x, y);
                if (Greenfoot.getRandomNumber(10) <= level){
                    addObject(new Enemy(), x, y - 180);
                }else if (Greenfoot.getRandomNumber(15) == 0 && numThorns == 0){
                    addObject(new ThornsSmall(), x, y - 100);
                    numThorns = 1;
                }
            }
        }
    }
    public void randomPositionPos(){
        changeX = addX + Greenfoot.getRandomNumber(40);
        changeY = addY + Greenfoot.getRandomNumber(100);
    }
    public void randomPositionNeg(){
        changeX =  addX + Greenfoot.getRandomNumber(40);
        changeY = - (addY + Greenfoot.getRandomNumber(40));
    }
    public void createWithBar(Solids solid, int x, int y){
        addObject(solid, x, y);
        createBar(solid);
    }
    public void createBar(Solids solid){
        int x = solid.getX();
        int y = solid.getY();
        int height = solid.getImage().getHeight();
        int width = solid.getImage().getWidth();
        LeftBarrier leftBarrier = new LeftBarrier(5,height-2,90);
        RightBarrier rightBarrier = new RightBarrier(5,height-2,90);
        addObject(leftBarrier, x-width/2, y);
        addObject(rightBarrier, x+width/2, y);
    }
    
    public void act(){
        if (heartVal <= 0){
            Greenfoot.setWorld(new GameOver());
        }
    }
    
    public void IncreaseScore(){
        score++;
        coinLabel.setValue(score);
    }
    public void DecreaseScore(int num){
        score-= num;
        coinLabel.setValue(score);
    }
    public int getScore(){
        return score;
    }
    public void setGameNumLabel(){
        gameNumLabel.setValue(games);
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
    public void resetWorld(){
        games++;
        if (games % 10 == 0){
            level++;
        }
        setGameNumLabel();
        removeObjects(getObjects(Solids.class));
        removeObjects(getObjects(Barrier.class));
        removeObjects(getObjects(Cat.class));
        removeObjects(getObjects(Coin.class));
        removeObjects(getObjects(Enemy.class));
        removeObjects(getObjects(Speakers.class));
        removeObjects(getObjects(TextBubble.class));
        x = 100;
        y = 400;
        
        Ground1 ground1 = new Ground1();
        addObject (ground1, 40,370);
        Ground1 ground2 = new Ground1();
        addObject (ground2, 600,370);
        
        randomCreate();
        
        Cat cat = new Cat();
        addObject(cat, 50, 250);
    }
    public void removeLabel(){
        removeObjects(getObjects(Label.class));
        coinLabel = new Label(score,50);
        addObject(coinLabel, 50, 50);
        gameNumLabel = new Label(games, 70);
        addObject(gameNumLabel, 300, 70);
    }
    public void removeCharacter(){
        removeObjects(getObjects(Speakers.class));
    }
    public void removeBubble(){
        removeObjects(getObjects(TextBubble.class));
    }
    public void addText(Label label){
        addObject(label, 300, 300);
    }
    public void removeTextBox(TextBox box){
        removeObjects(getObjects(TextBox.class));
    }
}
