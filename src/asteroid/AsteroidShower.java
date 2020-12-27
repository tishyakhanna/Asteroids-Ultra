package asteroid;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Represents all asteroids currently on the screen with features to add and
 * remove.
 * 
 * @author ULTrA
 *
 */
public class AsteroidShower {

    /* ArrayList to hold current asteroids */
    private ArrayList<Asteroid> asteroids;

    /* total asteroids created so far in game */
    private int total;

    /* current speed to assign to asteroids */
    private int speed = 1;

    /**
     * Creates an asteroid shower object already containing two asteroids.
     * 
     */
    public AsteroidShower() {

        // initial number of asteroid when game starts
        total = 5;

        asteroids = new ArrayList<Asteroid>();

        for (int i = 0; i < 5; i++) {
            asteroids.add(new Asteroid(speed));
        }
    }

    /**
     * Calls nextFrame() on every asteroid in the shower.
     * 
     */
    public void nextFrame() {
        for (int i = 0; i < asteroids.size(); i++) {
            asteroids.get(i).nextFrame();
        }
    }

    /**
     * Draws an "asteroid" for each element at their current location.
     * 
     * @param g the graphics context to draw on.
     */
    public void paint(Graphics2D g) {
        for (int i = 0; i < asteroids.size(); i++) {
            asteroids.get(i).paint(g);
        }
    }

    /**
     * Creates a new asteroid with speed proportional to the total number of
     * asteroids created thus far and adds it to the shower.
     * 
     */
    public void add() {
        // speed increased by 1 every 5 asteroids
        speed = 1 + total / 5;
        Asteroid aster = new Asteroid(speed);

        asteroids.add(aster);
        total++;
    }

    /**
     * Returns the asteroid at a given index.
     * 
     * @param i index of asteroid
     * 
     * @return Asteroid the asteroid at index i
     * 
     */
    public Asteroid get(int i) {
        return asteroids.get(i);
    }

    /**
     * Removes the asteroid at a given index.
     * 
     * @param i index of the asteroid to be removed
     * 
     */
    public void remove(int i) {
        asteroids.remove(i);
    }

    /**
     * Returns the number of asteroids in the shower.
     * 
     * @return size the number of asteroids
     * 
     */
    public int size() {
        return asteroids.size();
    }
    
    //FOR TESTING PURPOSES
    /**
     * Returns the total asteroids of the game.
     * @return number total asteroids  
     */
    public int getTotal() {
        return this.total;
    }
    
    //FOR TESTING PURPOSES
    /**
     * Sets the total asteroids of the game.
     * @param val the new value of total 
     */
    public void setTotal(int val) {
        this.total = val;
    }
    
    //FOR TESTING PURPOSES
    /**
     * Returns the speed of asteroids of the game.
     * @return total starting asteroids  
     */
    public int getSpeed() {
        return this.speed;
    }
    
    
    

}
