package week7.homework1.model;

public class Mage {

    private static final int RED = 0;
    private static final int WHITE = 1;
    private int redCrystals;
    private int whiteCrystals;
    private final String name;

    public Mage(String name) {
        this.name = name;
    }

    public void addCrystals(int[] gatheredCrystals) {
        redCrystals += gatheredCrystals[RED];
        whiteCrystals += gatheredCrystals[WHITE];
    }

    public int getRedCrystals() {
        return redCrystals;
    }

    public int getWhiteCrystals() {
        return whiteCrystals;
    }

    public String getName() {
        return name;
    }
}
