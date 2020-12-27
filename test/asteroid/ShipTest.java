package asteroid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the functions of Ship.java
 * 
 * @author ULTrA
 *
 */
class ShipTest {

    // Ship object to perform tests
    private Ship ship = new Ship();

    @BeforeEach
    void setUp() {

        // initializing before each test
        ship = new Ship();
    }

    @Test
    public void testConstructor() {
        /**
         * Purpose: testing the constructor
         * Method: Ship()
         * Initialization: new Ship object
         * Parameters: none
         * Correct Result: angle is pi, x and y are half of the window size
         */
        assertEquals(GameDemo.WINDOW_SIZE / 2, ship.getX());
        assertEquals(GameDemo.WINDOW_SIZE / 2, ship.getY());
        assertEquals(Math.PI / 2, ship.getAngle());
    }

    @Test
    public void testRotateLeft() {
        /**
         * Purpose: testing the rotation towards left
         * Method: Ship()
         * Initialization: new Ship object
         * Parameters: none
         * Correct Result: pi/2 plus pi/18
         */
        ship.rotateLeft();
        assertEquals((Math.PI / 2) + (Math.PI / 18), ship.getAngle());
    }

    @Test
    public void testRotateRight() {
        /**
         * Purpose: testing the rotation towards right
         * Method: Ship()
         * Initialization: new Ship object
         * Parameters: none
         * Correct Result: pi/2 minus pi/18
         */
        ship.rotateRight();
        assertEquals(Math.PI / 2 - (Math.PI / 18), ship.getAngle());
    }

    @Test
    public void testMove() {
        /**
         * Purpose: testing the ship moves properly
         * Method: Ship()
         * Initialization: new Ship object
         * Parameters: none
         * Correct Result: x and y are greater than previous values
         */
        double y = ship.getY();
        double x = ship.getY();
        ship.move();
        assertEquals(true, y > ship.getY());
        assertEquals(true, x == ship.getX());
    }

}
