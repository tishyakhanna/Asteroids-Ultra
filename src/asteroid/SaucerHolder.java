package asteroid;

import java.awt.Graphics2D;
import java.util.ArrayList;

/***
 * Represents all saucers currently on the screen with features to add and
 * remove.
 * 
 * @author ULTrA
 *
 */
public class SaucerHolder {

    /* ArrayList to hold current saucers */
    private ArrayList<Saucer> saucer = new ArrayList<Saucer>();

    /* Total number of saucers created in game thus far */
    private int total = 0;

    /**
     * Creates an empty SaucerHolder.
     * 
     */
    public SaucerHolder() {
    }

    /**
     * Calls nextFrame() on every saucer in the structure.
     * 
     */
    public void nextFrame() {
        for (int i = 0; i < saucer.size(); i++) {
            saucer.get(i).nextFrame();
        }
    }

    /**
     * Draws a "saucer" for each element at each of their current coordinates.
     * 
     * @param g the graphics context to draw on.
     */
    public void paint(Graphics2D g) {
        for (int i = 0; i < saucer.size(); i++) {
            saucer.get(i).paint((Graphics2D) g);
        }
    }

    /**
     * Creates a new saucer adds it to the holder.
     * 
     */
    public void add() {
        // each saucer is slightly bigger and faster
        saucer.add(new Saucer(2 + total, 20 + (total * 10))); 
        total++;
    }

    /**
     * Returns the saucer at a given index.
     * 
     * @param i index of the saucer
     * 
     * @return Saucer the saucer at index i
     */
    public Saucer get(int i) {
        return saucer.get(i);
    }

    /**
     * CHANGE SAUCER TO HOLD MULTIPLE Removes the first saucer
     * 
     **/
    public void remove() {
        saucer.remove(0);
    }

    /**
     * Returns the number of saucers in the holder.
     * 
     * @return number of saucers
     * 
     */
    public int size() {
        return saucer.size();
    }
    
    //FOR TESTING PURPOSES
    /**
     * Returns the total saucers of the game.
     * @return number total saucers  
     */
    public int getTotal() {
        return this.total;
    }

}
