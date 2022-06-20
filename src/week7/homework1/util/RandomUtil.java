package week7.homework1.util;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM = new Random();
    private static final int MIN = 2;

    private RandomUtil() {
    }

    public static int getRandomMax(int bound) {
        return RANDOM.nextInt(bound) + MIN;
    }

    public static int getNext(int bound) {
        return RANDOM.nextInt(bound + 1);
    }

}
