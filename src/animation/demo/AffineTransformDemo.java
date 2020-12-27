package animation.demo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;

/**
 * This class demonstrates how shapes can be rotated and translated.
 *
 */
public class AffineTransformDemo {
    // The shape that is drawn
    private Polygon p;
    
    // The left edge of the shape
    private int x;
    
    // The top edge of the shape
    private int y;
    private int moveAmount = 5;
    
    /**
     * Constructs a triangle
     */
    public AffineTransformDemo () {
        p = new Polygon();
        p.addPoint(-10, 20);
        p.addPoint(0, -20);
        p.addPoint(10, 20);
        
        x = 400;
        y = 100;
    }

    /**
     * Draws the triangle
     * @param g the graphics context to draw on
     */
    public void paint(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.draw(getShape());
    }
    public void nextFrame() {
        // Update the x value to move in the current direction
        x = x - moveAmount;

//        // Check if the right edge of the ball is beyond the right
//        // edge of the window. If it is, move it to the right edge
//        // and change the direction, so it will move left on its
//        // next move.
//        if (x + BALL_SIZE > animation.getWidth()) {
//            x = animation.getWidth() - BALL_SIZE;
//            moveAmount = moveAmount * -1;
//        }
//
//        // Check if the left edge of the ball is beyond the left
//        // edge of the window. If it is, move it to the left edge
//        // and chante the direction, so it will move right on its
//        // next move.
//        else if (x < 0) {
//            x = 0;
//            moveAmount = moveAmount * -1;
        }

    /**
     * Returns the shape after applying the current translation
     * and rotation
     * @return the shape located as we want it to appear
     */
    public Shape getShape() {
        // AffineTransform captures the movement and rotation we
        // want the shape to have
        AffineTransform at1 = new AffineTransform();
        
        // x, y are where the origin of the shape will be.  In this
        // case, this is the center of the triangle.  See the constructor
        // to see where the points are.
        at1.translate(x, y);
        
        // Rotate the shape 45 degrees to the left
        at1.rotate(Math.PI/4);
        
        // Create a shape that looks like our triangle, but centered
        // and rotated as specified by the AffineTransform object.
        return at1.createTransformedShape(p);
    }
}
