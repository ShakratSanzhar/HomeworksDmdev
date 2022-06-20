package week7.homework1.thread;

import week7.homework1.model.Mage;
import week7.homework1.model.Planet;
import week7.homework1.util.RandomUtil;

public class Rocket extends Thread{

    private static final int NUMBER_OF_CRYSTALS_TYPE = 2;
    private static final int RED = 0;
    private static final int WHITE = 1;
    private static final int REQUIRED_NUMBER_OF_CRYSTALS = 500;
    private static final int BOUND = 4;
    private final Night night;
    private final Mage mage;
    private final Planet planet;

    public Rocket(Mage mage, Planet planet, Night night) {
        this.mage = mage;
        this.planet = planet;
        this.night = night;
    }

    @Override
    public void run() {
        try {
            while (night.isActive()) {
                int[] gatheredCrystals = gatherCrystalsFromPlanet();
                mage.addCrystals(gatheredCrystals);
                if (mage.getRedCrystals() >= REQUIRED_NUMBER_OF_CRYSTALS && mage.getWhiteCrystals() >= REQUIRED_NUMBER_OF_CRYSTALS) {
                    night.disable();
                }
                waitNextNight();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int[] gatherCrystalsFromPlanet() {
        int crystalsCount = RandomUtil.getRandomMax(BOUND);
        int redCrystalCount = RandomUtil.getNext(crystalsCount);
        int whiteCrystalCount = crystalsCount - redCrystalCount;
        int[] gatheredCrystals = new int[NUMBER_OF_CRYSTALS_TYPE];
        synchronized (planet.getLock()) {
            gatheredCrystals[RED] = getCrystalsOfSameKind(RED, redCrystalCount);
            gatheredCrystals[WHITE] = getCrystalsOfSameKind(WHITE, whiteCrystalCount);
        }
        return gatheredCrystals;
    }

    private int getCrystalsOfSameKind(int type, int crystalCount) {
        int gatheredCrystals = 0;
        if (planet.getCrystals(type) <= crystalCount) {
            gatheredCrystals = planet.getCrystals(type);
            planet.removeAllCrystalsOfSameType(type);
        } else if (planet.isCrystalsOfSameTypeExist(type)) {
            gatheredCrystals = crystalCount;
            planet.removeCrystalsOfSameType(crystalCount, type);
        }
        System.out.printf("%s rocket gathered %s crystals: %d\n", mage.getName(), planet.getNameOfCrystals(type), gatheredCrystals);
        return gatheredCrystals;
    }

    private void waitNextNight() throws InterruptedException {
        synchronized (night.getLock()) {
            night.getLock().wait();
        }
    }

    public Mage getMage() {
        return mage;
    }
}
