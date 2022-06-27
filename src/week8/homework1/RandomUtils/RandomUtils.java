package week8.homework1.RandomUtils;

import java.time.LocalDateTime;
import java.util.Random;

public final class RandomUtils {

    private static final Random RANDOM = new Random();
    private static final int VALUES = 3;
    private static final int SECOND = 5;
    private static final int YEARS = 1;
    private static final int NANOSECOND = 0;
    public static final int AMOUNT = 3;
    public static final long PERIOD = 2000;
    public static final long CALL = 300;
    public static final long DURATION = 1000;
    public static final int ID = 4;

    private RandomUtils() {
    }

    public static String getRandomComplaint() {
        String[] strings = {
                LocalDateTime.now().withSecond(SECOND).minusYears(YEARS).withNano(NANOSECOND) + ",Иванов Иван,+375 29 999 78 90,Не включается свет",
                LocalDateTime.now().withSecond(SECOND).minusYears(YEARS).withNano(NANOSECOND) + ",Петров Петр,+375257777765,Почему опять не работает интернет?",
                LocalDateTime.now().withSecond(SECOND).minusYears(YEARS).withNano(NANOSECOND) + ",Петров Петр,333652193,Кто-то оборвал мне телефонный кабель"
        };
        return strings[RANDOM.nextInt(VALUES)];
    }
}
