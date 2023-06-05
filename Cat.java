import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * cat
 * 
 * @author Angela 
 * @version 05/30/2023
 */
public class Cat extends Actor
{
    int groundLevel = 350;

    GreenfootImage[] stillRightImages = new GreenfootImage[8];
    GreenfootImage[] stillLeftImages = new GreenfootImage[8];
    GreenfootImage[] jumpRightImages = new GreenfootImage[8];
    GreenfootImage[] jumpLeftImages = new GreenfootImage[8];
    GreenfootImage[] runRightImages = new GreenfootImage[12];
    GreenfootImage[] runLeftImages = new GreenfootImage[12];
    
    SimpleTimer animationTimer = new SimpleTimer();
    boolean facingRight = true;
    
    int dx = 0, dy = 0;
    public Cat(){
        for (int i = 0; i < runRightImages.length; i++){
            runRightImages[i] = new GreenfootImage("images/catRun/run" + i + ".png");
            runRightImages[i].scale(80,80);
            runLeftImages[i] = new GreenfootImage("images/catRun/run" + i + ".png");
            runLeftImages[i].mirrorHorizontally();
            runLeftImages[i].scale(80,80);
        }
        
        for (int i = 0; i < jumpRightImages.length; i++){
            jumpRightImages[i] = new GreenfootImage("images/catJump/jump" + i + ".png");
            jumpRightImages[i].scale(80,80);
            jumpLeftImages[i] = new GreenfootImage("images/catJump/jump" + i + ".png");
            jumpLeftImages[i].mirrorHorizontally(); 
            jumpLeftImages[i].scale(80,80);            
        }
        
        for (int i = 0; i < stillRightImages.length; i++){
            stillRightImages[i] = new GreenfootImage("images/catStill/still" + i + ".png");
            stillRightImages[i].scale(80,80);
            stillLeftImages[i] = new GreenfootImage("images/catStill/still" + i + ".png");
            stillLeftImages[i].mirrorHorizontally(); 
            stillLeftImages[i].scale(80,80); 
        }
        setImage(runRightImages[0]);
        animationTimer.mark();
    }
    
    private int imageIndex = 0;
    private boolean isJumping = false;
    public void act()
    {
        move();
        animateCat();
        getCoin();
        Next();
    }
    
    /**
     * set animation for jump, run, and stand still
     */
    public void animateCat(){
        if (animationTimer.millisElapsed() < 100){
            return;
        }
        animationTimer.mark(); 
        if (facingRight){
            if (Greenfoot.isKeyDown("Up")){
                imageIndex = (imageIndex + 1) % jumpRightImages.length;
                setImage(jumpRightImages[imageIndex]);
            }else if (Greenfoot.isKeyDown("Right")){
                imageIndex = (imageIndex + 1) % runRightImages.length;
                setImage(runRightImages[imageIndex]);
            }else{
                imageIndex = (imageIndex + 1) % stillRightImages.length;
                setImage(stillRightImages[imageIndex]);            
            }
        }else{
            if (Greenfoot.isKeyDown("Up")){
                imageIndex = (imageIndex + 1) % jumpLeftImages.length;
                setImage(jumpLeftImages[imageIndex]);
            }else if (Greenfoot.isKeyDown("Left")){
                imageIndex = (imageIndex + 1) % runLeftImages.length;
                setImage(runLeftImages[imageIndex]);
            }else{
                imageIndex = (imageIndex + 1) % stillLeftImages.length;
                setImage(stillLeftImages[imageIndex]);            
            }
        }
    }
    
    public void move(){
        if (Greenfoot.isKeyDown("Up")&& isTouching(Solids.class)){
            dy = -15; 
            setLocation(getX(), getY() + dy); 
            Greenfoot.getKey();
        }
        else if (Greenfoot.isKeyDown("left")){
            setLocation(getX()-3,getY());
            facingRight = false;
        }
        else if (Greenfoot.isKeyDown("right")){
            setLocation(getX()+3,getY());
            facingRight = true;
        }
        if (!isTouching(Solids.class)){
            dy++; 
            if (dy >= 0){
                for (int i = 0; i < dy; i++){
                    setLocation(getX(), getY()+1);
                    if (getOneIntersectingObject(Solids.class)!=null){
                        break;
                    }
                }
            }else{
                for (int i = dy; i <0; i++){
                    setLocation(getX(), getY()-1);
                    if (getOneIntersectingObject(Solids.class)!=null){
                        dy = 0;
                    }
                }
            }
        }
        touchBar();
    }
    
    public void getCoin(){
        if (isTouching(Coin.class)){
            removeTouching(Coin.class);
            MyWorld world = (MyWorld) getWorld();
            world.IncreaseScore();
        }
    }
    
    public void touchBar(){
        if (isTouching(LeftBarrier.class)){
            setLocation(getX()-3,getY());
        }else if (isTouching(RightBarrier.class)){
            setLocation(getX()+3,getY());
        }
    }
    
    public void Next(){
        if(getX() >= 600){
            if (getWorld().getClass().getName().equals("MyWorld")){
                MyWorld world = (MyWorld) getWorld();
                world.toNext();
            }
        }
    }
}