package jk.uz.pdp;

import java.util.Random;

public class RandomUtils {

    public static byte getMaxAge() {
        return (byte) new Random().nextInt(50, 100);
    }

    public static int getDateNumber(){
        return new Random().nextInt(1,10);
    }

    public static int getFishNumber(){
        return new Random().nextInt(1,3);
    }
}
