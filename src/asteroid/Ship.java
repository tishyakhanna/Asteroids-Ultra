package asteroid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

import animation.AnimatedObject;

/**
 * @author ULTrA
 *
 * A spaceship which can rotate and shoot!
 */
public class Ship implements AnimatedObject {

    /* the physical shape representation of the object */
    private Path2D.Double ship;

    /* The starting x coordinate of the left edge of the ship */
    private double x = GameDemo.WINDOW_SIZE / 2;

    /* The starting y coordinate of the object (y axis is upside down) */
    private double y = GameDemo.WINDOW_SIZE / 2;

    /* The direction in which the ship should point */
    private double angle = Math.PI / 2;

    /* The number of pixels to move by with each key press */
    private static final double translationAmount = 10;

    /* The angle in radians to rotate by with each key press */
    private static final double rotationAmount = Math.PI / 18;

    /* The object used to transform ship's shape as it moves across screen */
    private AffineTransform mover = new AffineTransform();

    /**
     * Creates the ship
     * 
     */
    public Ship() {
        Polygon p = new Polygon();
        int tempX = (int) x;
        int tempY = (int) y;
        p.addPoint(tempX - 10, tempY + 20);
        p.addPoint(tempX, tempY - 20);
        p.addPoint(tempX + 10, tempY + 20);
        ship = new Path2D.Double(p);

    }

    /**
     * Draws the ship
     * 
     * @param g the graphics context to draw on
     */
    public void paint(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.draw(getShape());
    }

    /**
     * Rotates the ship left by rotationAmount.
     */
    public synchronized void rotateLeft() {
        mover.setToIdentity();
        mover.rotate(-rotationAmount, x, y);
        ship.transform(mover);
        angle += rotationAmount;
    }

    /**
     * Rotates the ship right by rotationAmount.
     */
    public synchronized void rotateRight() {
        mover.setToIdentity();
        mover.rotate(rotationAmount, x, y); // -15 degrees
        ship.transform(mover);
        angle -= rotationAmount;
    }

    /**
     * Moves the ship in the direction it is pointing (angle) by
     * translationAmount pixels.
     */
    public synchronized void move() {
        mover.setToIdentity();
        double dx = translationAmount * Math.cos(angle);
        double dy = -translationAmount * Math.sin(angle);
        // make sure the ship is always visible
        boolean aboveScreen = y + dx < 5;
        boolean belowScreen = y + dx > GameDemo.WINDOW_SIZE - 5;
        boolean rightOfScreen = x + dx > GameDemo.WINDOW_SIZE - 5;
        boolean leftOfScreen = x + dx < 5;
        if (!aboveScreen && !belowScreen && !rightOfScreen && !leftOfScreen) {
            mover.translate(dx, dy);
            ship.transform(mover);
            y += dy;
            x += dx;
        }
    }

    /**
     * Moves the ship to a random location on the screen.
     */
    public synchronized void hyperspace() {
        mover.setToIdentity();
        double newX = (Math.random() * GameDemo.WINDOW_SIZE);
        double newY = (Math.random() * GameDemo.WINDOW_SIZE);
        mover.translate(newX - x, newY - y);
        ship.transform(mover);
        x = newX;
        y = newY;
    }

    /**
     * Returns the physical shape representation.
     * 
     * @return shape
     */
    public Shape getShape() {
        return ship;
    }

    /**
     * Returns the direction which the ship points.
     * 
     * @return angle in radians
     */
    public double getAngle() {
        return angle;
    }

    /**
     * Returns the x coordinate of the ship.
     * 
     * @return x coordinate
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y coordinate of the ship.
     * 
     * @return y coordinate
     */
    public double getY() {
        return y;
    }

    public void nextFrame() {
    };

}
