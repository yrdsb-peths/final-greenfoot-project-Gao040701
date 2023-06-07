import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * objects in backpack
 * 
 * @author Angela
 * @version 06/07/2023
 */
public class Objects extends Actor
{
    
    private String name;
    private int num;
    private GreenfootImage image;
    public Objects(String name, int num, GreenfootImage image){
        this.name = name;
        this.num = num;
        this.image = image;
        setImage(image);
        image.scale(50,50);
    }
    public int getNum(){
        return num;
    }
    public String getName(){
        return name;
    }
    public void addNum(int val){
        num += val;
    }
    public void setNum(int val){
        num = val;
    }
}
