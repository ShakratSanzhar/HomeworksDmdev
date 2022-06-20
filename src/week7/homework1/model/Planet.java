package week7.homework1.model;

public class Planet {

    private final Object lock = new Object();
    private int redCrystals;
    private int whiteCrystals;
    private static final int RED = 0;
    private static final int WHITE = 1;

    public int getCrystals(int type) {
        int crystals = 0;
        if (type == RED) {
            crystals = redCrystals;
        } else if (type == WHITE) {
            crystals = whiteCrystals;
        }
        return crystals;
    }

    public void addRedCrystals(int grownRedCrystals) {
        redCrystals += grownRedCrystals;
    }

    public void addWhiteCrystals(int grownWhiteCrystals) {
        whiteCrystals += grownWhiteCrystals;
    }

    public void removeCrystalsOfSameType(int gatheredCrystals, int type) {
        if (type == RED) {
            redCrystals -= gatheredCrystals;
        } else if (type == WHITE) {
            whiteCrystals -= gatheredCrystals;
        }
    }

    public void removeAllCrystalsOfSameType(int type) {
        if (type == RED) {
            redCrystals = 0;
        } else if (type == WHITE) {
            whiteCrystals = 0;
        }
    }

    public boolean isCrystalsOfSameTypeExist(int type) {
        boolean isExist = false;
        if (type == RED) {
            isExist = !(redCrystals == 0);
        } else if (type == WHITE) {
            isExist = !(whiteCrystals == 0);
        }
        return isExist;
    }

    public String getNameOfCrystals(int type) {
        String name = null;
        if (type == RED) {
            name = "red";
        } else if (type == WHITE) {
            name = "white";
        }
        return name;
    }

    public Object getLock() {
        return lock;
    }
}
