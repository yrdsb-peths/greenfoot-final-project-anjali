import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pumpkins here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pumpkins extends Actor
{
    String facing = "right";
    
    public Pumpkins()
    {
        GreenfootImage myImage = getImage();
        int newHeight = (int) myImage.getHeight() / 8;
        int newWidth = (int) myImage.getWidth() / 8;
        myImage.scale(newHeight, newWidth);    
    }
    
    public void act()
    {
        //allowing the user to control the direction of the character using WASD
        //WASD
        if(Greenfoot.isKeyDown("a"))
        {
            move(-3);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("d"))
        {
            move(3);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(), getY() - 3);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(), getY() + 3);
        }
        //Arrow keys
        if(Greenfoot.isKeyDown("left"))
        {
            move(-3);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(3);
            facing = "right";
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 3);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 3);
        }
        eat();
    }
    
    public void eat()
    {
        if(isTouching(Witches.class))
        {
            removeTouching(Witches.class);
            PumpkinWorld world = (PumpkinWorld) getWorld();
            world.spawnWitches();
            world.decreaseScore();
            world.decreaseScore();
            world.decreaseScore();
            world.decreaseScore();
            world.decreaseScore();
        }
        if(isTouching(Candy.class))
        {
            removeTouching(Candy.class);
            PumpkinWorld world = (PumpkinWorld) getWorld();
            world.spawnCandies();
            world.increaseScore();
            
        }
        if(isTouching(Ghost.class))
        {
            removeTouching(Ghost.class);
            PumpkinWorld world = (PumpkinWorld) getWorld();
            world.spawnGhosts();
            world.decreaseScore();
        }
        if(isTouching(Bombs.class))
        {
            removeTouching(Bombs.class);
            PumpkinWorld world = (PumpkinWorld)getWorld();
            world.loseLives();
        }
    }
}
