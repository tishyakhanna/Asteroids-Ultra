package asteroid;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents an asteroid with attributes constituting its location and
 * direction, which are assigned randomly. Asteroid is symbolized on screen by a
 * black circle.
 * 
 * @author ULTrA
 *
 */
public class Asteroid extends RandomizedFlyingObject {

    /* The diameter of the ball, in pixels */
    private static final int ROCK_SIZE = 50;

    private BufferedImage img;

    /**
     * Creates an asteroid object with a specified speed and random location and
     * direction.
     * 
     * @param speed the number of pixels to move by in each frame
     */
    public Asteroid(int speed) {
        // assigns random x, y, and angle values such the asteroid will
        // move across screen
        place(); 
        
        setMoveAmount(speed);
       
        Ellipse2D.Double temp = new Ellipse2D.Double(getX(), getY(), ROCK_SIZE,
                ROCK_SIZE);
        setShape(new Path2D.Double(temp));
    }

    /**
     * Draws a black circle at its current x and y coordinates.
     * 
     * @param g the graphics context to draw on.
     */
    public void paint(Graphics2D g) {
        g.setColor(Color.BLACK);
        try {
            img = ImageIO.read(getClass().getResourceAsStream("/asteroid.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(img, (int) getX(), (int) getY(), ROCK_SIZE, ROCK_SIZE,
                null);

    }

}
