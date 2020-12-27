package asteroid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the functions of Saucer.java
 * 
 * @author ULTrA
 *
 */

class SaucerTest {

    @Test
    void constructorTest() {
        /**
         * Purpose: testing the constructor
         * Method: Saucer()
         * Initialization: new Saucer object
         * Parameters: 1
         * Correct Result: moveAmount is 1, width is 10, height is 2 * 10 / 3
         */
        Saucer saucer = new Saucer(1, 10);
        assertEquals(1, saucer.getMoveAmount());
        assertEquals(10, saucer.getWidth());
        assertEquals(2 * 10 / 3, saucer.getHeight());
    }

    
    @Test
    void constructorTest2() {
        /**
         * Purpose: testing the constructor
         * Method: Saucer()
         * Initialization: new Saucer object
         * Parameters: 0, 0
         * Correct Result: moveAmount, width, height are 0
         */
        Saucer s = new Saucer(0, 0);
        assertEquals(0, s.getMoveAmount());
        assertEquals(0, s.getWidth());
        assertEquals(0, s.getHeight());
    }
   
}
