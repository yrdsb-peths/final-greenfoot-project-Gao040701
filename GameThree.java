import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Game Three scene 
 * find the apple 
 * 
 * @author Angela
 * @version 06/06/2023
 */
public class GameThree extends World
{
    private int score;
    private int heartVal;
    Label coinLabel;

    public GameThree(int score, int heartVal)
    { 
        super(600, 400, 1, false); 
        
        this.score = score;
        this.heartVal = heartVal;
        
        Ground2 ground21 = new Ground2();
        addObject(ground21, 300, 400);
        createBar(ground21);
        
        Cat cat = new Cat();
        addObject(cat, 300, 0);
    
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
    public void showBackPack(){
        if (Greenfoot.isKeyDown("b")){
            
        }
    }
}