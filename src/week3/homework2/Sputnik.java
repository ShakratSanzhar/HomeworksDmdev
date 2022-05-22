package week3.homework2;

public class Sputnik extends CosmicBody implements Accelerable {

    public Sputnik(String name, double mass, double radius) {
        super(name, mass, radius);
    }

    public double getAccelerationOfFreeFall(double mass, double radius) {
        return GRAVITATIONAL_CONSTANT * mass / (radius * radius);
    }

    @Override
    public void print() {
        System.out.println(getName() + " - это спутник. Ускорение свободного падения нем: " + getAccelerationOfFreeFall(getMass(), getRadius()) + " м/с2");
    }

    @Override
    public String toString() {
        return "Sputnik{ name: " + getName() + "mass: " + getMass() + " radius: " + getRadius() + " }";
    }
}
