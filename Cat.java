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
    
    GreenfootSound getCoin = new GreenfootSound("getCoin.mp3");
    GreenfootSound jumpSound = new GreenfootSound("jumpSound.mp3");
    
    SimpleTimer animationTimer = new SimpleTimer();
    boolean facingRight = true;
    
    int dx = 0, dy = 0;
    public Cat(){
        for (int i = 0; i < runRightImages.length; i++){
            runRightImages[i] = new GreenfootImage("images/catRun/run" + i + ".png");
            runRightImages[i].scale(60,40);
            runLeftImages[i] = new GreenfootImage("images/catRun/run" + i + ".png");
            runLeftImages[i].mirrorHorizontally();
            runLeftImages[i].scale(60,40);
        }
        
        for (int i = 0; i < jumpRightImages.length; i++){
            jumpRightImages[i] = new GreenfootImage("images/catJump/jump" + i + ".png");
            jumpRightImages[i].scale(60,40);
            jumpLeftImages[i] = new GreenfootImage("images/catJump/jump" + i + ".png");
            jumpLeftImages[i].mirrorHorizontally(); 
            jumpLeftImages[i].scale(60,40);            
        }
        
        for (int i = 0; i < stillRightImages.length; i++){
            stillRightImages[i] = new GreenfootImage("images/catStill/still" + i + ".png");
            stillRightImages[i].scale(60,40);
            stillLeftImages[i] = new GreenfootImage("images/catStill/still" + i + ".png");
            stillLeftImages[i].mirrorHorizontally(); 
            stillLeftImages[i].scale(60,40); 
        }
        setImage(runRightImages[0]);
        animationTimer.mark();
    }
    
    private int imageIndex = 0;
    private boolean isJumping = false;
    public void act()
    {
        if (getWorld().getObjects(TextBox.class)!=null){
            if (!TextBox.getIsTalking()){
                move();
                animateCat();
                getCoin();
                Next();
            }
        }
    }
    /**
     * set up animation for cat 
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
    
    /**
     * move the cat
     */
    public void move(){
        if (Greenfoot.isKeyDown("Up")&& isTouching(Solids.class) && getY() < getOneIntersectingObject(Solids.class).getY()){
            jumpSound.play();
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
    
    /**
     * get the number of coins earned 
     */
    public void getCoin(){
        if (isTouching(Coin.class)){
            getCoin.play();
            removeTouching(Coin.class);
            if (getWorld() instanceof GameOne){
                GameOne world = (GameOne) getWorld();
                world.increaseCoin();
            }else{
                Random world = (Random) getWorld();
                world.increaseCoin();
            }
        }
    }
    
    /**
     * stop the cat if it's touching the barriers
     */
    public void touchBar(){
        if (isTouching(LeftBarrier.class)){
            setLocation(getX()-3,getY());
        }else if (isTouching(RightBarrier.class)){
            setLocation(getX()+3,getY());
        }else if (isTouching(BottomBarrier.class)){
            setLocation(getX(), getY()-dy*2);
            dy = 0;
        }
    }
    
    /** 
     * go to next world or reset the world when the cat reaches the end of the world 
     */
    public void Next(){
        if(getX() >= 600){
            if (getWorld().getClass().getName().equals("GameOne")){
                GameOne world = (GameOne) getWorld();
                world.toNextTwo();
            }
            if (getWorld().getClass().getName().equals("GameTwo")){
                GameTwo world = (GameTwo) getWorld();
                world.end();
            }
            if (getWorld().getClass().getName().equals("Random")){
                Random world = (Random) getWorld();
                world.resetWorld();
            }
        }
    }
}