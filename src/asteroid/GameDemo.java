package asteroid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import animation.AbstractAnimation;

/**
 * GameDemo starts and ends the game,the game holds all of the objects on
 * screen, and controls their motion.
 * 
 * @author ULTrA
 *
 */
public class GameDemo extends AbstractAnimation implements KeyListener {

    /* The size of the window, in pixels. */
    public static final int WINDOW_SIZE = 800;

    /* The Ship object controlled by user. */
    private Ship ship = new Ship();

    /* The AsteroidShower object containing the asteroids currently shown. */
    private AsteroidShower asteroids = new AsteroidShower();

    /* The Pointage object to keep track of and project points and level. */
    private Pointage score = new Pointage();

    /* The Graphics2D object to project physical shape representations. */
    private Graphics2D g;

    /* The SaucerHolder object containing the saucers currently shown. */
    private SaucerHolder saucers = new SaucerHolder();

    /* The ShotsFired object containing the bullets currently shown. */
    private ShotsFired shots = new ShotsFired();

    /* The ShotsFired object containing bullets for Saucer object */
    private ShotsFired saucerShots = new ShotsFired();

    /* Flag to specify whether game is being played or over. */
    private boolean moving = true;

    /* Flag to specify whether saucers are visible on screen. */
    private boolean saucerVisible = false;

    /* Flag to tell whether more asteroids must be created. */
    private boolean enough = false;

    /* Number of frames until saucer shoots */
    private int shootTime = 10;

    /* Angle at which saucer should shoot */
    private double shootAngle = Math.PI / 2;

    /**
     * Constructs the game and initializes it to be able to accept key.
     * 
     */
    public GameDemo() {
        // Allow the game to receive key input
        setFocusable(true);
        addKeyListener(this);

    }

    @Override
    /**
     * Updates the animated objects for the next frame of the animation and
     * repaints the window.
     */
    protected void nextFrame() {
        if (moving) {
            shots.nextFrame();
            saucerShots.nextFrame();
            asteroids.nextFrame();
            score.nextFrame();
            saucers.nextFrame();
            repaint();
            // ends the game
            if (checkCollision()) {
                score.gameOver();
                moving = false;
                Sound.setGameOver();
            }
            // to update saucers shooting
            checkSaucerShoot();
        }

    }

    /**
     * Check whether any two objects collide. If the ship is hit by an asteroid,
     * saucer, bullet, or ship, the game ends. If the ship shoots a saucer or
     * asteroid, it disappears
     * 
     * @param shape1 the first shape to test
     * @param shape2 the second shape to test
     * @return true if the shapes intersect
     */
    protected boolean checkCollision() {

        // if ship hits asteroid
        for (int i = 0; i < asteroids.size(); i++) {
            if (asteroids.get(i).getShape()
                    .intersects(ship.getShape().getBounds2D())) {
                return true;
            }
        }
        // if ship hits saucer
        for (int i = 0; i < saucers.size(); i++) {
            if (saucerVisible && ship.getShape()
                    .intersects(saucers.get(i).getShape().getBounds2D())) {
                return true;
            }
        }
        // Checks if the saucer bullet hit the ship
        for (int i = 0; i < saucerShots.size(); i++) {
            if (saucerVisible && saucerShots.get(i).getShape()
                    .intersects(ship.getShape().getBounds2D())) {
                return true;
            }
        }

        boolean levelChange = false;

        boolean hitSaucer = false;

        // Checks if any bullet hit saucers

        for (int i = 0; i < shots.size(); i++) {
            // For going through all saucers on the screen
            for (int j = 0; j < saucers.size(); j++) {
                if (saucerVisible && shots.get(i).getShape()
                        .intersects(saucers.get(j).getShape().getBounds2D())) {
                    levelChange = score.add(200);
                    shots.removeOne(i);

                    hitSaucer = true;

                    saucers.remove();

                    if (saucers.size() == 0) {
                        saucerVisible = false;
                    }
                }
            }

            // only check to see if bullet hit asteroid
            // if it did not hit a saucer

            if (!hitSaucer) {

                // if asteroid is shot
                for (int j = 0; j < asteroids.size(); j++) {
                    if (shots.get(i).getShape().intersects(
                            asteroids.get(j).getShape().getBounds2D())) {

                        asteroids.remove(j);

                        shots.removeOne(i);

                        levelChange = score.add(100);

                        enough = true;

                        asteroids.add();

                    }
                }
            }
            // if level changes due to previous collisions,
            // deploy boss Saucer
            if (levelChange) {
                saucers.add();
                saucerVisible = true;
            }
        }
        shots.removeAll();
        return false;
    }

    public void checkSaucerShoot() {
        if (saucerVisible) {
            if (shootTime == 0) {
                for (int i = 0; i < saucers.size(); i++) {
                    shoot("saucer",
                            saucers.get(i).getX() + saucers.get(i).getWidth(),
                            saucers.get(i).getY() + saucers.get(i).getHeight(),
                            shootAngle);
                }
                // 13 frames between each shot
                shootTime = 13;
                // angle of shots shifts at constant rate
                shootAngle += Math.PI / 8;
            } else {
                shootTime--;
            }
        }
    }

    /**
     * Paint the animation by painting the objects in the animation.
     * 
     * @param g the graphic context to draw on
     */
    public void paintComponent(Graphics g) {
        // Note that your code should not call paintComponent directly.
        // Instead your code calls repaint (as shown in the nextFrame
        // method above, and repaint will call paintComponent.

        super.paintComponent(g);

        ship.paint((Graphics2D) g); // paint stuff
        asteroids.paint((Graphics2D) g);
        saucers.paint((Graphics2D) g);
        saucerShots.paint((Graphics2D) g);
        score.paint((Graphics2D) g);
        shots.paint((Graphics2D) g);
    }

    @Override
    /**
     * This is called on the downward action when the user presses a key. It
     * notifies the animated ball about presses of up arrow, right arrow, left
     * arrow, and the space bar. All other keys are ignored.
     * 
     * @param e information about the key pressed
     */
    public void keyPressed(KeyEvent e) {
        if (moving) {
            int key = e.getKeyCode();
            switch (key) {
            case KeyEvent.VK_UP:
                ship.move();
                break;
            case KeyEvent.VK_RIGHT:
                ship.rotateRight();
                break;
            case KeyEvent.VK_LEFT:
                ship.rotateLeft();
                break;
            case KeyEvent.VK_SPACE:
                this.shoot("ship", ship.getX(), ship.getY(), ship.getAngle());
                break;
            case KeyEvent.VK_SHIFT:
                ship.hyperspace();
                break;
            default:
                // Ignore all other keys

            }
        }

    }

    @Override
    /**
     * This is called when the user releases the key after pressing it. It does
     * nothing.
     * 
     * @param e information about the key released
     */
    public void keyReleased(KeyEvent e) {
        // Nothing to do
    }

    @Override
    /**
     * This is called when the user presses and releases a key without moving
     * the mouse in between. Does nothing.
     * 
     * @param e information about the key typed.
     */
    public void keyTyped(KeyEvent e) {
        // Nothing to do
    }

    /**
     * Prompts the bullet to fires
     * 
     * @param ObjectName speficying which object shoots,
     * @param x          and
     * @param y          coordinates,
     * @param angle      of shooting
     */
    public void shoot(String objectName, double x, double y, double angle) {
        if (objectName.equals("ship")) {
            shots.add(new Bullet(x, y, angle));
        }
        if (objectName.equals("saucer")) {
            saucerShots.add(new Bullet(x, y, angle));
        }

    }

    /**
     * The main method creates a window for the animation to run in, initializes
     * the animation and starts it running.
     * 
     * @param args none
     */
    public static void main(String[] args) {
        // JFrame is the class for a window. Create the window,
        // set the window's title and its size.
        JFrame f = new JFrame();
        f.setTitle("Game Demo");
        f.setSize(new Dimension(WINDOW_SIZE, WINDOW_SIZE));

        // This says that when the user closes the window, the
        // entire program should exit.
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the animation.
        GameDemo gameDemo = new GameDemo();

        // Add the animation to the window
        Container contentPane = f.getContentPane();
        contentPane.add(gameDemo, BorderLayout.CENTER);
        contentPane.setBackground(Color.BLACK);
        // Display the window.
        f.setVisible(true);

        // Start the animation
        gameDemo.start();
        Sound.playBackground();
    }

}
