package com.app.roshambo.utils;

public class RoshamboUtils {

    public static int RESULT_LOST = 0;
    public static int RESULT_WON = 1;
    public static int RESULT_TIE = 2;

    public static int ROCK_CHOOSEN = 0;
    public static int PAPER_CHOOSEN = 1;
    public static int SCISSOR_CHOOSEN = 2;


    /**
     * Genereates Random number between 0 & 2.
     *
     * Formula is Random number = (int) ((Math.random() * (Upper bound - lower bound) + 1) + lower bound);
     *
     * @param imagelength
     * @return random number between 0 & 2
     */
    public static int selectRandomImageId(int imagelength) {
        double random = Math.random();
        int imageId = (int) (random * imagelength);
        return imageId;
    }
}
