import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * backPack
 * a list of objects 
 * 
 * @author Angela
 * @version 06/07/2023
 */
public class BackPack extends Actor
{
    ArrayList<Objects> backPack = new ArrayList<Objects>();
    public void act()
    {
        if (Greenfoot.isKeyDown("b")){
            show();
            Greenfoot.getKey();
        }
        if (Greenfoot.isKeyDown("a")){
            addList(new Apple(2));
        }
    }
    public void addList(Objects obj){
        backPack.add(obj);
    }
    public void removeList(Objects obj){
        int index = backPack.indexOf(obj);
        backPack.remove(index);
    }
    public void show(){
        for (int i = 0; i < backPack.size(); i++){
            getWorld().addObject(backPack.get(i), 225 +i%4*50, 175+i/4*50);
            System.out.println(i);
        }
    }
    public void stopShow(){
        
    }
}
