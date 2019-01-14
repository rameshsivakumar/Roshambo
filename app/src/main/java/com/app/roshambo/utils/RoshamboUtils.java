package com.app.roshambo.utils;

public class RoshamboUtils {

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
