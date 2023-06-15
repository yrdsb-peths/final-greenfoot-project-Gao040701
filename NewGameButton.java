import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * create a new game 
 * 
 * @author Angela
 * @version 06/11/2023
 */
public class NewGameButton extends Actor
{
    GreenfootImage newGame1 = new GreenfootImage("images/buttons/newGame1.png");
    GreenfootImage newGame2 = new GreenfootImage("images/buttons/newGame2.png");
    GreenfootSound click = new GreenfootSound("clickSound.mp3");
    private String name;
    public void act()
    {
        if (Greenfoot.mouseMoved(this)){
            setImage(newGame2);
        }else{
            setImage(newGame1);
        }
        if (Greenfoot.mouseClicked(this)){
            click.play();
            if (name.equals("tutorial")){
                Greenfoot.setWorld(new GameOne());
            }else if (name.equals("random")){
                Greenfoot.setWorld(new Random());
            }
        }
    }
    public NewGameButton(String name){
        newGame1.scale(100,100);
        newGame2.scale(90,90);
        setImage(newGame1);
        this.name = name;
    }
}
