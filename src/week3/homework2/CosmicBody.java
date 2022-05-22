package week3.homework2;

public abstract class CosmicBody implements Printable {
    private String name;
    private double mass;
    private double radius;

    public CosmicBody(String name, double mass, double radius) {
        this.name = name;
        this.mass = mass;
        this.radius = radius;
    }

    public double getDiameter() {
        double diameter = radius * 2;
        System.out.println("Диаметр равен: " + diameter);
        return diameter;
    }

    public void compareMassesOfBodies(CosmicBody cosmicBody) {
        if (mass > cosmicBody.mass) {
            System.out.println("Масса космотела " + name + " больше чем масса космотела " + cosmicBody.name);
        } else if (mass < cosmicBody.mass) {
            System.out.println("Масса космотела " + name + " меньше чем масса космотела " + cosmicBody.name);
        } else {
            System.out.println("Масса космотела " + name + " равна  массе космотела " + cosmicBody.name);
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }
}
