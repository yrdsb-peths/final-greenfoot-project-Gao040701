import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * cat
 * 
 * @author Angela 
 * @version 05/30/2023
 */
public class Cat extends Actor
{
    int groundLevel = 300;
    int ySpeed;

    GreenfootImage[] stillRightImages = new GreenfootImage[8];
    GreenfootImage[] stillLeftImages = new GreenfootImage[8];
    GreenfootImage[] jumpRightImages = new GreenfootImage[9];
    GreenfootImage[] jumpLeftImages = new GreenfootImage[9];
    GreenfootImage[] runRightImages = new GreenfootImage[12];
    GreenfootImage[] runLeftImages = new GreenfootImage[12];
    
    SimpleTimer animationTimer = new SimpleTimer();
    boolean facingRight = true;
    boolean isJumping = false;
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
            stillRightImages[i].scale(100,100);
            stillLeftImages[i] = new GreenfootImage("images/catStill/still" + i + ".png");
            stillLeftImages[i].mirrorHorizontally(); 
            stillLeftImages[i].scale(80,80); 
        }
        setImage(runRightImages[0]);
        animationTimer.mark();
    }
    
    private int imageIndex = 0;
    
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("Left")){
            setLocation(getX()-3,getY());
            facingRight = false;
        }else if (Greenfoot.isKeyDown("Right")){
            setLocation(getX()+3,getY());
            facingRight = true;
        }
        jump();
        
        animateCat();
    }


    public void animateCat(){
        if (animationTimer.millisElapsed() < 200){
            return;
        }
        animationTimer.mark(); 
        if (facingRight){
            imageIndex = (imageIndex + 1) % runRightImages.length;
            setImage(runRightImages[imageIndex]);            
        }else{
            imageIndex = (imageIndex + 1) % stillLeftImages.length;
            setImage(stillLeftImages[imageIndex]);
        }
    }
    
    public void jump(){
        boolean onGround = (getY() == groundLevel);
        if (!onGround){
            ySpeed++; // adds gravity effect
            setLocation(getX(), getY()+ySpeed); // fall (rising slower or falling faster)
            if (getY()>=groundLevel) // has landed (reached ground level)
            {
                setLocation(getX(), groundLevel); // set on ground
                Greenfoot.getKey(); // clears any key pressed during jump
           }
        }else{
            if (Greenfoot.isKeyDown("Up")) // jump key detected
            {
                ySpeed = -13; // add jump speed
                setLocation(getX(), getY()+ySpeed); // leave ground
            }
        }
    }
}