import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class detective here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cat extends Actor
{
    int groundLevel = 350;
    int ySpeed;
    public void act()
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("Left")){
            move(-5);
        }
        else if (Greenfoot.isKeyDown("Right")){
            move(5);
        }else if (Greenfoot.isKeyDown("Up")){
            jump();
        }
    }
    
    /**
     * make the chcracter jump 
     * detect the vertical distance, if greater than a specific number, lose an amount of hp 
     */
    public void jump(){
        /*
        boolean onGround = (getY() == groundLevel);
        if (!onGround) // in middle of jump
        {
            ySpeed++; // adds gravity effect
            setLocation(getX(), getY()+ySpeed); // fall (rising slower or falling faster)
            if (getY()>=groundLevel) // has landed (reached ground level)
            {
                setLocation(getX(), groundLevel); // set on ground
                Greenfoot.getKey(); // clears any key pressed during jump
           }
        }
        else // on ground
        {
            if (Greenfoot.isKeyDown("Up")) // jump key detected
            {
                ySpeed = -15; // add jump speed
                setLocation(getX(), getY()+ySpeed); // leave ground
            }
        }
        */
       
    }
}
