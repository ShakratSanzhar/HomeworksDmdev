package week3.homework2;

public class EarthPlanet extends Planet {

    public EarthPlanet(String name, double mass, double radius, Sputnik[] sputniks) {
        super(name, mass, radius, sputniks);
    }

    @Override
    public void print() {
        System.out.println(getName() + " - это земная Планета. Ускорение свободного падения на ней: " + getAccelerationOfFreeFall(getMass(), getRadius()) + " м/с2");
        System.out.println("Спутники планеты " + getName() + ": ");
        for (Sputnik sputnik : getSputniks()) {
            sputnik.print();
        }
    }

    @Override
    public String toString() {
        return "EarthPlanet{ name: " + getName() + "mass: " + getMass() + " radius: " + getRadius() + " }";
    }
}
