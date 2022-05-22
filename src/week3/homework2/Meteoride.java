package week3.homework2;

public class Meteoride extends CosmicBody implements SmallBody {
    private int rotationPeriod;

    public Meteoride(String name, double mass, double radius, int rotationPeriod) {
        super(name, mass, radius);
        this.rotationPeriod = rotationPeriod;
    }

    @Override
    public void print() {
        System.out.println(getName() + " - это метеорит. Период вращения его равен: " + rotationPeriod + ". Скорость вращения равна: " + getRotationSpeed(getRadius(), rotationPeriod));
    }

    @Override
    public String toString() {
        return "Meteoride{ name: " + getName() + "mass: " + getMass() + " radius: " + getRadius() + " rotationPeriod " + rotationPeriod + " }";
    }

    public int getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(int rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }
}
