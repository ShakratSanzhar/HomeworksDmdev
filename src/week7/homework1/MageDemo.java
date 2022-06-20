package week7.homework1;

import week7.homework1.model.Mage;
import week7.homework1.thread.Crystal;
import week7.homework1.thread.Night;
import week7.homework1.thread.Rocket;
import week7.homework1.util.ThreadUtil;

public class MageDemo {

    public static void main(String[] args) throws InterruptedException {
        Night night = new Night();
        Crystal crystal = new Crystal(night);
        Rocket fireRocket = new Rocket(new Mage("FireMage"), crystal.getPlanet(), night);
        Rocket airRocket = new Rocket(new Mage("AirMage"), crystal.getPlanet(), night);
        ThreadUtil.startThreads(night, crystal, fireRocket, airRocket);
        ThreadUtil.joinThreads(night, crystal, fireRocket, airRocket);
        viewStatistic(fireRocket.getMage(), airRocket.getMage());
    }

    private static void viewStatistic(Mage fireMage, Mage airMage) {
        System.out.println("----------------");
        System.out.println(fireMage.getName() + " " + "have red crystals: " + fireMage.getRedCrystals() + ", white crystals: " + fireMage.getWhiteCrystals());
        System.out.println(airMage.getName() + " " + "have red crystals: " + airMage.getRedCrystals() + ", white crystals: " + airMage.getWhiteCrystals());
    }
}
