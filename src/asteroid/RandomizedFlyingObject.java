package asteroid;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.util.Random;

import animation.AbstractAnimation;
import animation.AnimatedObject;

/**
 * @author ULTrA
 *
 * An abstract class with various methods to be implemented by flying
 * objects like asteroids and saucers
 */
public abstract class RandomizedFlyingObject implements AnimatedObject {

    /* the physical shape representation of the object */
    private Path2D.Double shape;

    /* The starting x coordinate of the left edge of the object */
    private double x;

    /* The starting y coordinate of the object (y axis is upside down) */
    private double y;

    /* The direction in which the objects should move */
    private double angle;

    /* The number of pixels to move in each frame of the animation */
    private int moveAmount;

    /* The object used to transform object shape as it moves across screen */
    private AffineTransform mover = new AffineTransform();

    /* Random object used to generate random coordinates */
    private Random rand = new Random();

    /**
     * Draws a physical representation of object at its current location.
     * 
     * @param g the graphics context to draw on.
     */
    public void paint(Graphics2D g) {
    }

    /**
     * Returns a random number between 0 and the size of the window.
     * 
     * @return random number between 0 and the size of the window.
     */
    public double getRandCoor() {
        return GameDemo.WINDOW_SIZE * rand.nextDouble();
    }

    /**
     * Calculates a random set of coordinates on the perimeter of the window and
     * calculating a random angle such that the object will move onto the screen
     * 
     */
    public void place() {
        if (rand.nextBoolean()) {
            if (rand.nextBoolean()) {
                // left side of screen
                this.x = 0;
                angle = -Math.PI / 2 + (Math.PI * rand.nextDouble());
            } else {
                // right side of screen
                this.x = GameDemo.WINDOW_SIZE;
                angle = Math.PI / 2 + (Math.PI * rand.nextDouble());
            }
            this.y = getRandCoor();
        } else {
            if (rand.nextBoolean()) {
                // top of screen
                this.y = 0;
                angle = -Math.PI + (Math.PI * rand.nextDouble());
            } else {
                // bottom side of screen
                this.y = GameDemo.WINDOW_SIZE;
                angle = Math.PI * rand.nextDouble();
            }
            this.x = getRandCoor();
        }
    }

    /**
     * Translates the object by the moveAmount in the direction of angle. If the
     * object moves off screen, translates it so that it wraps over.
     * 
     */
    public void nextFrame() {
        mover.setToIdentity();
        double dx, dy;

        dx = moveAmount * Math.cos(angle);
        dy = -moveAmount * Math.sin(angle);
        y += dy;
        x += dx;

        // check if out of frame
        if (this.x >= GameDemo.WINDOW_SIZE) {
            dy = 0;
            dx = -x;
            x = 0;
        } else if (this.x < 0) {
            dy = 0;
            dx = GameDemo.WINDOW_SIZE - x;
            x = GameDemo.WINDOW_SIZE;
        }
        if (this.y > GameDemo.WINDOW_SIZE) {
            dx = 0;
            dy = -y;
            y = 0;
        }
        if (this.y < 0) {
            dx = 0;
            dy = GameDemo.WINDOW_SIZE - y;
            y = GameDemo.WINDOW_SIZE;
        }

        mover.translate(dx, dy);
        shape.transform(mover);
    }

    /**
     * Returns the angle
     * 
     * @return angle
     * 
     */
    protected double getAngle() {
        return angle;
    }

    // FOR TESTING PURPOSE ONLY
    /**
     * Sets the angle
     * 
     * @param a the angle
     * 
     */
    protected void setAngle(double a) {
        this.angle = a;
    }

    /**
     * Sets the number of pixels to translate the object by in each frame.
     * 
     * @param moveAmount number of pixels
     */
    protected void setMoveAmount(int moveAmount) {
        this.moveAmount = moveAmount;
    }

    // FOR TESTING PURPOSE ONLY
    /**
     * Gets the number of pixels to translate the object by in each frame.
     * 
     * @return the move amount
     */
    protected int getMoveAmount() {
        return this.moveAmount;
    }

    /**
     * Sets the shape of the object.
     * 
     * @param shape shape of type Path2D.Double
     */
    protected void setShape(Path2D.Double shape) {
        this.shape = shape;
    }

    /**
     * Returns the shape of the object.
     * 
     * @return shape shape of type Path2D.Double
     */
    protected Path2D.Double getShape() {
        return this.shape;
    }

    /**
     * Returns the x coordinate.
     * 
     * @return x the value for x coordinate
     */
    protected double getY() {
        return y;
    }

    /**
     * Returns the y coordinate.
     * 
     * @return y the value for y coordinate
     */
    protected double getX() {
        return x;
    }

    // FOR TESTING PURPOSE ONLY
    /**
     * Sets the x coordinate.
     * 
     * @param x the new value for x coordinate
     */
    protected void setX(double x) {
        this.x = x;
    }

    // FOR TESTING PURPOSE ONLY
    /**
     * Sets the y coordinate.
     * 
     * @param y the new value for y coordinate
     */
    protected void setY(double y) {
        this.y = y;
    }

}
