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
        // Add your action code here.
    }
    public void addList(Objects obj){
        backPack.add(obj);
    }
    public void removeList(Objects obj){
        int index = backPack.indexOf(obj);
        backPack.remove(index);
    }
    /*
    public void show(){
        for (int i = 0; i < backPack.size(); i++){
            if (i%4 == 0){
                
            }
        }
    }*/
}
