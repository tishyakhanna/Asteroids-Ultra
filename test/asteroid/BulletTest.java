package asteroid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the functions of Bullet.java
 * 
 * @author ULTrA
 *
 */

class BulletTest {

    // AsteroidShower object to perform tests
    Bullet bullet = new Bullet(0,0,0);

    @BeforeEach
    void setUp() {
        // initializing before each test
        bullet = new Bullet(0,0,0);


    }

    @Test
    void constructorTest() {
        /**
         * Purpose: testing the constructor
         * Method: Bullet()
         * Initialization: new Bullet object
         * Parameters: 0,0,0
         * Correct Result: x, y, and angle are 0
         */
        assertEquals(0, bullet.getX());
        assertEquals(0, bullet.getY());
        assertEquals(0, bullet.getAngle());
        assertEquals(15, bullet.getMoveAmount());

    }
    
    @Test
    void constructorTest2() {
        /**
         * Purpose: testing the constructor
         * Method: Bullet()
         * Initialization: new Bullet object
         * Parameters: 0,0,0
         * Correct Result: x, y, and angle are 0
         */
        Bullet newBullet = new Bullet(5,5,Math.PI);
        assertEquals(5, newBullet.getX());
        assertEquals(5, newBullet.getY());
        assertEquals(Math.PI, newBullet.getAngle());
        assertEquals(15, newBullet.getMoveAmount());
    }
    
    @Test
    void outOfFrameTest() {
        /**
         * Purpose: testing whether the bullet is out of frame
         * Method: outOfFrame()
         * Initialization: new Bullet object, x set to 700 
         * Parameters: none
         * Correct Result: true
         */
        bullet.setX(801);
        assertEquals(true, bullet.outOfFrame());

    }
    
    @Test
    void outOfFrameTest2() {
        /**
         * Purpose: testing whether the bullet is out of frame
         * Method: outOfFrame()
         * Initialization: new Bullet object, x set to -1
         * Parameters: none
         * Correct Result: true
         */
        bullet.setX(-1);
        assertEquals(true, bullet.outOfFrame());

    }
    
    @Test
    void outOfFrameTest3() {
        /**
         * Purpose: testing whether the bullet is out of frame
         * Method: outOfFrame()
         * Initialization: new Bullet object, y set to -1 
         * Parameters: none
         * Correct Result: true
         */
        bullet.setY(-1);
        assertEquals(true, bullet.outOfFrame());

    }
    
    @Test
    void outOfFrameTest4() {
        /**
         * Purpose: testing whether the bullet is out of frame
         * Method: outOfFrame()
         * Initialization: new Bullet object, y set to 801
         * Parameters: none
         * Correct Result: true
         */
        bullet.setY(801);
        assertEquals(true, bullet.outOfFrame());

    }
    
    @Test
    void outOfFrameTest5() {
        /**
         * Purpose: testing whether the bullet is out of frame
         * Method: outOfFrame()
         * Initialization: new Bullet object, x set to 700 
         * Parameters: none
         * Correct Result: false
         */
        bullet.setX(500);
        assertEquals(false, bullet.outOfFrame());

    }
    
    @Test
    void outOfFrameTest6() {
        /**
         * Purpose: testing whether the bullet is out of frame
         * Method: outOfFrame()
         * Initialization: new Bullet object, y set to 700 
         * Parameters: none
         * Correct Result: false
         */
        bullet.setY(500);
        assertEquals(false, bullet.outOfFrame());

    }
    
    @Test
    void moveTest() {
        /**
         * Purpose: testing whether the bullet moves correctly
         * Method: move()
         * Initialization: new Bullet object
         * Parameters: none
         * Correct Result: false
         */
        Bullet newBullet = new Bullet(5,5,Math.PI);
        newBullet.move();
        double dx = newBullet.getMoveAmount() * Math.cos(Math.PI);
        double dy = -newBullet.getMoveAmount() * Math.sin(Math.PI);
        assertEquals(5+dx, newBullet.getX());
        assertEquals(5+dy, newBullet.getY());
    }
    
    
    

}
