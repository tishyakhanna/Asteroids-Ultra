package asteroid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Testing the functions of Asteroid.java
 * 
 * @author ULTrA
 *
 */

class AsteroidTest {
    
    private Asteroid asteroid = new Asteroid(1);

    
    @BeforeEach
    void setUp() {
        asteroid = new Asteroid(1);
    }

    // The nextFrame tests are for Saucer.java also since it implements
    // RandomizedFlyingObject also
    
    @Test
    void nextFrameTest() {
        /**
         * Purpose: testing whether the object wraps around the screen
         * Method: nextFrame()
         * Initialization: new Asteroid object
         * Parameters: none
         * Correct Result: x is 800, y is dy
         */
        asteroid.setX(0);
        asteroid.setY(0);   
        
        //this is a wrap around test for x
        
        assertEquals(0,asteroid.getX());
        assertEquals(0,asteroid.getY());
        asteroid.setAngle(-Math.PI);
        
        asteroid.nextFrame();
        
        double dy = -asteroid.getMoveAmount()*Math.sin(asteroid.getAngle());

        assertEquals(800.0, asteroid.getX());
        assertEquals(dy, asteroid.getY());
    }
    
    
    @Test
    void nextFrameTest2() {
        /**
         * Purpose: testing whether the object moves correctly
         * Method: nextFrame()
         * Initialization: new Asteroid object
         * Parameters: none
         * Correct Result: x is 1+dx, y is 1+dy
         */
        asteroid.setX(1);
        asteroid.setY(1);
                
        assertEquals(1,asteroid.getX());
        assertEquals(1,asteroid.getY());
        asteroid.setAngle(Math.PI/12);


        asteroid.nextFrame();
        
        double dx = asteroid.getMoveAmount()*Math.cos(asteroid.getAngle());
        double dy = -asteroid.getMoveAmount()*Math.sin(asteroid.getAngle());

        assertEquals(1+dx, asteroid.getX());
        assertEquals(1+dy, asteroid.getY());
    }
    
    @Test
    void nextFrameTest3() {
        /**
         * Purpose: testing whether the object wraps around the screen
         * Method: nextFrame()
         * Initialization: new Asteroid object
         * Parameters: none
         * Correct Result: x is dx, y is 800.0
         */
        asteroid.setX(0);
        asteroid.setY(0);
       
        //this is a wrap around test for y
        
        assertEquals(0,asteroid.getX());
        assertEquals(0,asteroid.getY());
        asteroid.setAngle(Math.PI/2);
 
        asteroid.nextFrame();
        
        double dx = asteroid.getMoveAmount()*Math.cos(asteroid.getAngle());

        assertEquals(dx, asteroid.getX());
        assertEquals(800.0, asteroid.getY());
      }
    
    
    @Test
    void nextFrameTest4() {
        /**
         * Purpose: testing whether the object moves correctly
         * Method: nextFrame()
         * Initialization: new Asteroid object
         * Parameters: none
         * Correct Result: x is 1, y is 0
         */
        asteroid.setX(0);
        asteroid.setY(0);

        assertEquals(0,asteroid.getX());
        assertEquals(0,asteroid.getY());
        asteroid.setAngle(0);

        
        asteroid.nextFrame();

        assertEquals(1, asteroid.getX());
        assertEquals(0, asteroid.getY());   
    }
    
    @Test
    void nextFrameTest5() {
        /**
         * Purpose: testing whether the object wraps around the screen
         * Method: nextFrame()
         * Initialization: new Asteroid object
         * Parameters: none
         * Correct Result: x is 0, y is 0
         */
        asteroid.setX(800.0);
        asteroid.setY(0);
       
        //this is a wrap around test for x
        
        assertEquals(800.0,asteroid.getX());
        assertEquals(0,asteroid.getY());
        asteroid.setAngle(0);
 
        asteroid.nextFrame();
        
        assertEquals(0, asteroid.getX());
        assertEquals(0, asteroid.getY());
      }
    
    @Test
    void nextFrameTest6() {
        /**
         * Purpose: testing whether the object wraps around the screen
         * Method: nextFrame()
         * Initialization: new Asteroid object
         * Parameters: none
         * Correct Result: x is 800.0, y is 0
         */
        asteroid.setX(0);
        asteroid.setY(800.0);
       
        //this is a wrap around test for y
        
        assertEquals(0,asteroid.getX());
        assertEquals(800.0,asteroid.getY());
        asteroid.setAngle(3*Math.PI/2);
 
        asteroid.nextFrame();
        
        assertEquals(800.0, asteroid.getX());
        assertEquals(0, asteroid.getY());
      }
    
    
    @Test
    void constructorTest() {
        /**
         * Purpose: testing the constructor
         * Method: Asteroid()
         * Initialization: new Asteroid object
         * Parameters: 1
         * Correct Result: moveAmount is 1
         */
        assertEquals(1, asteroid.getMoveAmount());
    }
    
    @Test
    void constructorTest2() {
        /**
         * Purpose: testing the constructor
         * Method: Asteroid()
         * Initialization: new Asteroid object
         * Parameters: 0
         * Correct Result: moveAmount is 0
         */
        Asteroid a = new Asteroid(0);
        assertEquals(0, a.getMoveAmount());
    }

}
