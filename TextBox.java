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
    public Label text;
    ArrayList<String> thornsOne = new ArrayList<String>();
    int index = 0;
    boolean previousSpace = false;
    public void act()
    {
        presentText1();
    }
    public void presentText1(){
        text = new Label(thornsOne.get(index),30);
        GameTwo world = (GameTwo) getWorld();
        world.addText(text);
        if (Greenfoot.isKeyDown("space") && previousSpace == false){
            previousSpace = true;
            world.removeLabel();
            index++;
        }
        if (!Greenfoot.isKeyDown("space")){
            previousSpace = false;
        }
        if (index >= thornsOne.size()){
            world.removeTextBox(this);
            world.removeCharacter();
            world.removeBubble();
        }
    }
    public TextBox(){
        addText();
        setImage(textBox);
    }
    public void addText(){
        thornsOne.add("Hello.");
        thornsOne.add("I am trying to create a medicine. ");
        thornsOne.add("I need two apples. ");
        thornsOne.add("Can you help me? ");
        thornsOne.add("I will give you someting back.");
    }
    
}
