package asteroid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

/**
 * Testing the functions of AsteroidShower.java
 * 
 * @author ULTrA
 *
 */
class AsteroidShowerTest {

    // AsteroidShower object to perform tests
    AsteroidShower a = new AsteroidShower();

    @BeforeEach
    void setUp() {
        // initializing before each test
        a = new AsteroidShower();

    }

    @Test
    void constructorTest() {
        /**
         * Purpose: testing the constructor
         * Method: AsteroidShower()
         * Initialization: new AsteroidShower object
         * Parameters: none
         * Correct Result: total is 5, length of the list is 5,
         * speed is 1
         */
        assertEquals(5, a.getTotal());
        assertEquals(1, a.getSpeed());
        assertEquals(5, a.size());
    }

    @Test
    void addTest() {
        /**
         * Purpose: testing whether asteroids are added correctly
         * Method: add()
         * Initialization: new AsteroidShower object
         * Parameters: none
         * Correct Result: total increases by 1, list size increases by 1,
         * speed is incremented by 1 when total is set to 5
         */
        assertEquals(1, a.getSpeed());
        a.setTotal(5);
        a.add();
        assertEquals(6, a.getTotal());
        assertEquals(2, a.getSpeed());
        assertEquals(6, a.size());
    }

    @Test
    void addTest2() {
        /**
         * Purpose: testing whether asteroids are added correctly
         * Method: add()
         * Initialization: new AsteroidShower object
         * Parameters: none
         * Correct Result: total increases by 1, list size increases by 1,
         * speed is not incremented 
         */
        assertEquals(1, a.getSpeed());
        a.setTotal(4);
        a.add();
        assertEquals(5, a.getTotal());
        assertEquals(1, a.getSpeed());
        assertEquals(6, a.size());
    }

    @Test
    void addTest3() {
        /**
         * Purpose: testing whether asteroids are added correctly
         * Method: add()
         * Initialization: new AsteroidShower object
         * Parameters: none
         * Correct Result: total increases by 2, list size increases by 2,
         * speed is incremented by 1 when total reaches 5
         */
        assertEquals(1, a.getSpeed());
        a.setTotal(4);
        a.add();
        a.add();
        assertEquals(6, a.getTotal());
        assertEquals(2, a.getSpeed());
        assertEquals(7, a.size());
    }

}
