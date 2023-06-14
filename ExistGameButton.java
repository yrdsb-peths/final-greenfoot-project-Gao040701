import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * exit the current game
 * 
 * @author Angela 
 * @version 06/11/2023
 */
public class ExistGameButton extends Actor
{
    GreenfootImage exit = new GreenfootImage("images/buttons/exit.png");
    GreenfootSound click = new GreenfootSound("clickSound.mp3");
    int finalScore;
    public void act()
    {
        if (Greenfoot.mouseMoved(this)){
            exit.scale(45,45);
        }else{
            exit.scale(50,50);
        }
        if (Greenfoot.mouseClicked(this)){
            click.play();
            if (getWorld() instanceof Random){
                Random world = (Random) getWorld();
                finalScore = world.getFinalScore();
                Greenfoot.setWorld(new GameOver(finalScore));
            }else if (getWorld() instanceof GameTwo){
                Greenfoot.setWorld(new GameOver(0));
            }
        }
    }
    public ExistGameButton(){
        exit.scale(50, 50);
        setImage(exit);
    }
}
