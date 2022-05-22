package week3.homework2;

public class Asteroid extends CosmicBody implements SmallBody {
    private int rotationPeriod;

    public Asteroid(String name, double mass, double radius, int rotationPeriod) {
        super(name, mass, radius);
        this.rotationPeriod = rotationPeriod;
    }

    @Override
    public void print() {
        System.out.println(getName() + " - это астероид. Период вращения его равен: " + rotationPeriod + ". Скорость вращения равна: " + getRotationSpeed(getRadius(), rotationPeriod));
    }

    @Override
    public String toString() {
        return "Asteroid{ name: " + getName() + "mass: " + getMass() + " radius: " + getRadius() + " rotationPeriod " + rotationPeriod + " }";
    }

    public int getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(int rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }
}
