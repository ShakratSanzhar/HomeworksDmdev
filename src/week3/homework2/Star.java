package week3.homework2;

public class Star extends CosmicBody {
    private int surfaceTemperature;

    public Star(String name, double mass, double radius, int surfaceTemperature) {
        super(name, mass, radius);
        this.surfaceTemperature = surfaceTemperature;
    }

    @Override
    public void print() {
        System.out.println(getName() + " - это звезда. Температура на ней равна: " + surfaceTemperature + " K");
    }

    @Override
    public String toString() {
        return "Star{ name: " + getName() + "mass: " + getMass() + " radius: " + getRadius() + " surfaceTemperature " + surfaceTemperature + " }";
    }

    public int getSurfaceTemperature() {
        return surfaceTemperature;
    }

    public void setSurfaceTemperature(int surfaceTemperature) {
        this.surfaceTemperature = surfaceTemperature;
    }
}
