package asteroid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the functions of ShotsFired.java
 * 
 * @author ULTrA
 *
 */
class ShotsFiredTest {

    // ShotsFired object to perform tests
    ShotsFired shotsFired = new ShotsFired();

    @BeforeEach
    void setUp() {
        // initializing before each test
        shotsFired = new ShotsFired();

    }

    @Test
    void addTest() {
        /**
         * Purpose: testing whether bullets are added correctly
         * Method: add()
         * Initialization: new ShotsFired object
         * Parameters: Bullet object called bullet
         * Correct Result: list size increases by 1,
         */
        
        // initially there should be 0 shots
        assertEquals(0, shotsFired.size());

        Bullet bullet = new Bullet(5.0, 5.0, 5.0);
        shotsFired.add(bullet);

        // after adding list size increases by 1
        assertEquals(1, shotsFired.size());
    }

    @Test
    void addTest2() {
        /**
         * Purpose: testing whether bullets are added correctly
         * Method: add()
         * Initialization: new ShotsFired object
         * Parameters: Bullet object called bullet
         * Correct Result: total increases by 2, list size increases by 2,
         */
        Bullet bullet = new Bullet(5.0, 5.0, 5.0);
        shotsFired.add(bullet);
        shotsFired.add(bullet);
        assertEquals(2, shotsFired.size());
    }
}
