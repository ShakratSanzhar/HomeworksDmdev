package week3.homework2;

public abstract class Planet extends CosmicBody implements Accelerable {
    private Sputnik[] sputniks;

    public Planet(String name, double mass, double radius, Sputnik[] sputniks) {
        super(name, mass, radius);
        this.sputniks = sputniks;
    }

    public double getAccelerationOfFreeFall(double mass, double radius) {
        return (GRAVITATIONAL_CONSTANT * mass) / (radius * radius);
    }

    public Sputnik[] getSputniks() {
        return sputniks;
    }

    public void setSputniks(Sputnik[] sputniks) {
        this.sputniks = sputniks;
    }
}
