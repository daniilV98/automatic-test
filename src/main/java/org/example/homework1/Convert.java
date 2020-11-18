package org.example.homework1;

import java.util.Random;

public class Convert {

    public static boolean convertSeconds(long sec) {
        long seconds = sec % 60;
        long minutes = sec % 3600/60;
        long hours = sec % 86400/3600;

        if (sec <= 86399 && sec >= 0) {
            System.out.println(hours + "h:" + minutes + "m:" + seconds + "s");
            return true;
        }
        return false;
    }

    public static int randomNumber(int number) {
        int randNumber = new Random().nextInt(number);
        System.out.println("Число " + randNumber);
        return randNumber;
    }
}
