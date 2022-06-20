package week7.homework1.thread;

import week7.homework1.model.Planet;
import week7.homework1.util.RandomUtil;

public class Crystal extends Thread{

    private static final int BOUND = 4;
    private final Night night;
    private final Planet planet;


    public Crystal(Night night) {
        this.night = night;
        this.planet = new Planet();
    }

    @Override
    public void run() {
        try {
            while (night.isActive()) {
                throwNewCrystals();
                waitNextNight();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void throwNewCrystals() {
        int crystalsCount = RandomUtil.getRandomMax(BOUND);
        int redCrystalCount = RandomUtil.getNext(crystalsCount);
        int whiteCrystalCount = crystalsCount - redCrystalCount;
        synchronized (planet.getLock()) {
            planet.addRedCrystals(redCrystalCount);
            planet.addWhiteCrystals(whiteCrystalCount);
            System.out.println(redCrystalCount + " red crystals and " + whiteCrystalCount + " white crystals have grown on the planet");
        }
    }

    private void waitNextNight() throws InterruptedException {
        synchronized (night.getLock()) {
            night.getLock().wait();
        }
    }

    public Planet getPlanet() {
        return planet;
    }
}
