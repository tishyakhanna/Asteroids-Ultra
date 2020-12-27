package asteroid;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author ultra
 * 
 * This class keeps track of the shots fired
 */
public class ShotsFired {
    
    /* ArrayList to hold current shots */
    private ArrayList<Bullet> shots = new ArrayList<Bullet>();
    
    /* ArrayList to hold shots to be deleted */
    private ArrayList<Integer> deadShots = new ArrayList<Integer>();
    
    /**
     * Creates an empty ShotsFired object.
     * 
     */
    public ShotsFired() {}
    
    /**
     * Calls nextFrame() on every saucer in the structure.
     * 
     */
    public void nextFrame() {
        for (int i = 0; i < shots.size(); i++) {
            if (shots.get(i).outOfFrame()) {
                shots.remove(i);
            } else {
                shots.get(i).nextFrame();   
            }
        }
    }
    
    /**
     * Draws a "bullet" for each element in the structure at each of their
     * current coordinates.
     * 
     * @param g the graphic context to draw on
     */
    
    public void paint(Graphics2D g) {
        for (int i = 0; i < shots.size(); i++) {
            shots.get(i).paint(g);
        }
    }
    
    /**
     * Adds bullet to the structure.
     * @param bullet bullet object
     */
    public void add(Bullet bullet) {
        shots.add(bullet);
    }
    
    /**
     * Returns the bullet at a given index.
     * @param i index
     * 
     * @return Bullet the bullet at index i
     * 
     */
    public Bullet get(int i) {
        return shots.get(i);
    }
    
    /**                          
     * Adds the Bullet at the specified index to deadShots to later
     * be removed.
     * 
     * @param i index of element to remove
     *  
     **/
    public void removeOne(int i) {
        deadShots.add(i);
    }
    
    /**                          
     * Removes the all Bullets at each index in deadShots
     * from shots.
     *  
     **/
    public void removeAll() {
        // sort in reverse order so that Bullets are removed 
        // from end to beginning,so that the indexes are not messed up
        Collections.sort(deadShots, Collections.reverseOrder());
        for (Integer curr: deadShots) {
            shots.remove(curr);
        }
        deadShots.clear();
    }
    
    /**
     * Returns the number of Bullets in ShotsFired.
     * 
     * @return number of Bullets 
     * 
     */
    public int size() {
        return shots.size();
    }
     
    
}

