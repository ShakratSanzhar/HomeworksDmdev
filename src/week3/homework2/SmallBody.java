package week3.homework2;

public interface SmallBody {
    double PI = 3.14;

    default double getRotationSpeed(double radius, int rotationPeriod) {
        return 2*PI*radius/rotationPeriod;
    }
}
