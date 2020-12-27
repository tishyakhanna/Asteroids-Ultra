package asteroid;

import javax.sound.sampled.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.*;

/**
 * @author ULTrA
 *
 * Class that puts sound in the game
 */

public class Sound {
    /* Static variable to check if the game is still on */

    private static boolean gameOver = false;

    /* static variable for the sound clip */

    private static Clip test;

    /**
     * Receives a file as sound input
     * 
     * @param fileName : the name of the file that contains the sound clip
     */
    private static void playSound(String fileName) {
        try {
            AudioInputStream ais = AudioSystem
                    .getAudioInputStream(new File(fileName));
            test = AudioSystem.getClip();

            test.open(ais);
            test.start();

            while (!test.isRunning()) {
                Thread.sleep(10);
            }

            while (test.isRunning()) {
                Thread.sleep(10);
            }

            test.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Class that is called to play the background music
     */
    public static void playBackground() {
        while (!gameOver) {
            playSound("stranger.wav");
        }
    }

    /**
     * Class that is called when the game is over
     */
    public static void setGameOver() {
        gameOver = true;
        test.stop();
        playSound("shot.wav");
    }
}
