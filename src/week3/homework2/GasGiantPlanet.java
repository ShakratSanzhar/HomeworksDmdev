package week3.homework2;

public class GasGiantPlanet extends Planet {

    public GasGiantPlanet(String name, double mass, double radius, Sputnik[] sputniks) {
        super(name, mass, radius, sputniks);
    }

    @Override
    public String toString() {
        return "GasGiantPlanet{ name: " + getName() + "mass: " + getMass() + " radius: " + getRadius() + " }";
    }

    @Override
    public void print() {
        System.out.println(getName() + " - это газовый гигант. Ускорение свободного падения на ней: " + getAccelerationOfFreeFall(getMass(), getRadius()) + " м/с2");
        System.out.println("Спутники планеты " + getName() + ": ");
        for (Sputnik sputnik : getSputniks()) {
            sputnik.print();
        }
    }
}
