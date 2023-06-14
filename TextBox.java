import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * textBox
 * 
 * @author Anela
 * @version 06/06/2023
 */
public class TextBox extends Actor
{
    GreenfootImage textBox = new GreenfootImage("images/textBox.png");
    GreenfootSound heal = new GreenfootSound("increaseHeartSound.mp3");
    GreenfootSound click = new GreenfootSound("clickSound.mp3");
    public Label text;
    Label yes = new Label("Yes", 30);
    Label no = new Label("No", 30);
    Label notEnough = new Label("You don't have enough coins.", 30);
    ArrayList<String> thornsOne = new ArrayList<String>();
    ArrayList<String> thornsTwo = new ArrayList<String>();
    int index = 0;
    int heartVal;
    boolean previousSpace = false;
    boolean finishChoosing = false;
    public void act()
    {
        presentText1();
    }
    public void presentText1(){
        if (getWorld() instanceof GameTwo){
            GameTwo world = (GameTwo) getWorld();
            world.removeBubble();
            if (index < thornsOne.size()){
                text = new Label(thornsOne.get(index),30);
                world.addText(text);
                if (Greenfoot.isKeyDown("space") && previousSpace == false){
                    click.play();
                    previousSpace = true;
                    world.removeLabel();
                    index++;
                }
                if (!Greenfoot.isKeyDown("space")){
                    previousSpace = false;
                }
                if (index == thornsOne.size()){
                    world.addObject(yes, 250, 300);
                    world.addObject(no, 350, 300);
                }
            }
            if (Greenfoot.mouseClicked(yes)){
                click.play();
                if (world.getScore() >= 2){
                    heal.play();
                    world.DecreaseScore(2);
                    world.minusHeartVal(-2);
                    heartVal = world.getHeartVal(); 
                    world.removeObjects(world.getObjects(Heart.class));
                    world.setHeart(heartVal);
                    world.removeLabel();
                    world.addObject(new Label("Good luck.", 30), 300, 300);
                }else{
                    world.removeLabel();
                    world.addObject(notEnough, 300, 300);
                }
                finishChoosing = true;
            }else if (Greenfoot.mouseClicked(no)){
                click.play();
                world.removeLabel();
                world.addObject(new Label("Good luck.", 30), 300, 300);
                finishChoosing = true;
            }
            if (finishChoosing && Greenfoot.isKeyDown("space")){
                click.play();
                finishChoosing = false;
                world.removeLabel();
                world.removeTextBox(this);
                world.removeCharacter();
                
            }
        }else{
            Random world = (Random) getWorld();
            world.removeBubble();
            if (index < thornsTwo.size()){
                text = new Label(thornsTwo.get(index),30);
                world.addText(text);
                if (Greenfoot.isKeyDown("space") && previousSpace == false){
                    click.play();
                    previousSpace = true;
                    world.removeLabel();
                    index++;
                }
                if (!Greenfoot.isKeyDown("space")){
                    previousSpace = false;
                }
                if (index == thornsTwo.size()){
                    world.addObject(yes, 250, 300);
                    world.addObject(no, 350, 300);
                }
            }
            if (Greenfoot.mouseClicked(yes)){
                click.play();
                if (world.getScore() >= 5){
                    heal.play();
                    world.DecreaseScore(5);
                    world.minusHeartVal(-2);
                    heartVal = world.getHeartVal(); 
                    world.removeObjects(world.getObjects(Heart.class));
                    world.setHeart(heartVal);
                    world.removeLabel();
                    world.addObject(new Label("Good luck.", 30), 300, 300);
                }else{
                    world.removeLabel();
                    world.addObject(notEnough, 300, 300);
                }
                finishChoosing = true;
            }else if (Greenfoot.mouseClicked(no)){
                click.play();
                world.removeLabel();
                world.addObject(new Label("Good luck.", 30), 300, 300);
                finishChoosing = true;
            }
            if (finishChoosing && Greenfoot.isKeyDown("space")){
                click.play();
                finishChoosing = false;
                world.removeLabel();
                world.removeTextBox(this);
                world.removeCharacter();
            }
        }
    }
    public TextBox(){
        addTextOne();
        addTextTwo();
        setImage(textBox);
    }
    public void addTextOne(){
        thornsOne.add("Hello, little warrior.");
        thornsOne.add("I am Thorns and I will help you \n in your future advanture.");
        thornsOne.add("You can pay me 5 coins to get 1 heart.");
        thornsOne.add("You only need to pay me 2 coins this time.");
    }
    public void addTextTwo(){
        thornsTwo.add("Hello, nice to see you again. ");
        thornsTwo.add("Do you want to pay 5 coins to get a heart?");
    }
    public void getChoice(){
        getWorld().addObject(new TextBox(), 550,200);
        getWorld().addObject(new Label("Yes", 50), 550, 200);
    }
}
