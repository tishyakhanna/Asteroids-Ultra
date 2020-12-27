package asteroid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the functions of Pointage.java
 * 
 * @author ULTrA
 *
 */
class PointageTest {

    // Pointage object to perform tests
    Pointage points = new Pointage();

    @BeforeEach
    void setUp() {
        // initializing before each test
        points = new Pointage();
    }

    @Test
    void addTest() {
        /**
         * Purpose: testing whether points are added correctly
         * Method: add()
         * Initialization: new Pointage object
         * Parameters: 20
         * Correct Result: total increases by 1, list size increases by 1,
         */
        assertEquals(0, points.getPoints());
        assertEquals(1, points.getLevel());
        points.add(20);
        assertEquals(20, points.getPoints());
        assertEquals(1, points.getLevel());
    }
    
    @Test
    void addTest2() {
        /**
         * Purpose: testing whether points are added correctly
         * Method: add()
         * Initialization: new Pointage object, points set to 980
         * Parameters: 20
         * Correct Result: points increases by 20, list size increases to 2
         */
        assertEquals(0, points.getPoints());
        assertEquals(1, points.getLevel());
        points.setPoints(980);
        points.add(20);
        assertEquals(1000, points.getPoints());
        assertEquals(2, points.getLevel());
    }

}
