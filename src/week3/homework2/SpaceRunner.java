package week3.homework2;

public class SpaceRunner {

    public static void main(String[] args) {
        CosmicBody moon = new Sputnik("Луна", 7.36e22, 1737e3);
        CosmicBody phobos = new Sputnik("Фобос", 1.072e16, 11000);
        CosmicBody deimos = new Sputnik("Деймос", 1.48e15, 6200);
        CosmicBody ganymede = new Sputnik("Ганимед", 1.48e23, 2634e3);
        Sputnik[] sputniksOfJupiter = {(Sputnik) ganymede};
        Sputnik[] sputniksOfEarth = {(Sputnik) moon};
        Sputnik[] sputniksOfMars = {(Sputnik) phobos, (Sputnik) deimos};
        CosmicBody earth = new EarthPlanet("Земля", 5.972e24, 6371e3, sputniksOfEarth);
        CosmicBody mars = new EarthPlanet("Марс", 6.39e23, 3389e3, sputniksOfMars);
        CosmicBody jupiter = new GasGiantPlanet("Юпитер", 1.898e27, 69911e3, sputniksOfJupiter);
        CosmicBody sun = new Star("Солнце", 1.989e30, 696340e3, 5778);
        CosmicBody ceres = new Asteroid("Церера", 9.39e20, 473e3, 9);
        CosmicBody jilin = new Meteoride("Гирин", 4000, 1000, 2);
        printAllInformation(mars, jupiter);
        getDiametersOfSpaceBodies(sun, ceres, jilin);
        mars.compareMassesOfBodies(jupiter);
        SpaceUtils.getGravitationalForce(earth, moon);
        SpaceUtils.isStar(sun);
        SpaceUtils.isStar(ceres);
    }

    public static void getDiametersOfSpaceBodies(CosmicBody... cosmicBodies) {
        for (CosmicBody cosmicBody : cosmicBodies) {
            System.out.print(cosmicBody.getName() + ". ");
            cosmicBody.getDiameter();
        }
    }

    public static void printAllInformation(Printable... cosmicBodies) {
        for (Printable cosmicBody : cosmicBodies) {
            cosmicBody.print();
        }
    }
}
