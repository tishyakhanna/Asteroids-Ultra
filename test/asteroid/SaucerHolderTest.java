package asteroid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the functions of SaucerHolder.java
 * 
 * @author ULTrA
 *
 */

class SaucerHolderTest {

    // SaucerHolder object to perform tests
    SaucerHolder a = new SaucerHolder();

    @BeforeEach
    void setUp() {
        // initializing before each test
        a = new SaucerHolder();

    }

    @Test
    void addTest() {
        /**
         * Purpose: testing whether saucers are added correctly
         * Method: add()
         * Initialization: new SaucerHolder object
         * Parameters: none
         * Correct Result: total increases by 1, list size increases by 1,
         */
        
        // initially rhere should be 0 saucers
        assertEquals(0, a.getTotal());
        assertEquals(0, a.size());

        a.add();

        // after adding both list size and total increase by 1
        assertEquals(1, a.getTotal());
        assertEquals(1, a.size());
    }

    @Test
    void addTest2() {
        /**
         * Purpose: testing whether saucers are added correctly
         * Method: add()
         * Initialization: new SaucerHolder object
         * Parameters: none
         * Correct Result: total increases by 2, list size increases by 2,
         */
        a.add();
        a.add();
        assertEquals(2, a.getTotal());
        assertEquals(2, a.size());
    }


}
