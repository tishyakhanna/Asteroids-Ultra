package asteroid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

import animation.AnimatedObject;

/***
 * Represents a bullet with attributes constituting its location and direction,
 * which are assigned based on the location and direction of the object which
 * 'shoots' it. Bullet is symbolized on screen by a black oval.
 * 
 * @author ULTrA
 *
 */
public class Bullet extends AffineTransform implements AnimatedObject {

    /* the width of a bullet */
    private static final int BULLET_WIDTH = 10;

    /* the height of a bullet */
    private static final int BULLET_HEIGHT = BULLET_WIDTH - (BULLET_WIDTH / 2);

    /* the physical shape representation of a bullet */
    private Path2D.Double bullet;

    /* The starting x coordinate of the bullet */
    private double x;

    /* The starting y coordinate of the bullet (y axis is upside down) */
    private double y;

    /* The direction in which the bullets should move */
    private double angle;

    /* The number of pixels to move on each frame of the animation */
    private double moveAmount = 15;

    /* The object used to transform bullet shape as it moves across screen */
    private AffineTransform bulletMover = new AffineTransform();

    /**
     * Creates the animated object
     * 
     * @param x     the x coordinate
     * @param y     the y coordinate
     * @param angle the angle of bullet
     * 
     */
    public Bullet(double x, double y, double angle) {

        Ellipse2D b = new Ellipse2D.Double(x, y, BULLET_WIDTH,
                BULLET_HEIGHT - 5);
        bullet = new Path2D.Double(b);

        this.angle = angle;
        this.x = x;
        this.y = y;
    }

    /**
     * Draws a black oval at its current location.
     * 
     * @param g the graphics context to draw on.
     */
    public void paint(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillOval((int) x, (int) y, BULLET_WIDTH, BULLET_HEIGHT);

    }

    /**
     * Moves the bullet.
     */
    public void move() {
        bulletMover.setToIdentity();

        double dx = moveAmount * Math.cos(angle);
        double dy = -moveAmount * Math.sin(angle);

        bulletMover.translate(dx, dy);

        bullet.transform(bulletMover);

        y += dy;
        x += dx;
    }

    /**
     * Returns the shape
     * 
     * @return the shape located
     */
    public Shape getShape() {
        return bullet;
    }

    /**
     * Moves the ball a small amount. If it reaches the left or right edge, it
     * bounces.
     */
    public void nextFrame() {
        move();
    }
    
    /**
     * Tells us if the bullet is on the frame or out
     * 
     * @return true if bullet is out of the frame
     */
    public boolean outOfFrame() {
        if (this.x > GameDemo.WINDOW_SIZE || this.x < 0) {
            return true;
        }
        if (this.y > GameDemo.WINDOW_SIZE || this.y < 0) {
            return true;
        }
        return false;

    }

    // For TESTING only
    double getX() {
        return x;
    }

    // For TESTING only
    double getY() {
        return y;
    }

    // For TESTING only
    void setX(int x) {
        this.x = x;
    }
    
    // For TESTING only
    void setY(int y) {
        this.y = y;
    }

    // For TESTING only
    double getMoveAmount() {
        return moveAmount;
    }

    // For TESTING only
    void setMoveAmount(int amount) {
        moveAmount = amount;
    }
    
    // For TESTING only
    double getAngle() {
        return angle;
    }


}
