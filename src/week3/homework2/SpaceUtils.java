package week3.homework2;

public final class SpaceUtils {

    private SpaceUtils() {

    }

    public static double getGravitationalForce(CosmicBody cosmicBody1, CosmicBody cosmicBody2) {
        double gravitationalForce = Accelerable.GRAVITATIONAL_CONSTANT * cosmicBody1.getMass() * cosmicBody2.getMass() / Math.pow(149_597_870_700.0, 2);
        System.out.println("Сила гравитации между " + cosmicBody1.getName() + " и " + cosmicBody2.getName() + " равна: " + gravitationalForce);
        return gravitationalForce;
    }

    public static boolean isStar(CosmicBody cosmicBody) {
        boolean isStar = cosmicBody instanceof Star;
        if (isStar) {
            System.out.println(cosmicBody.getName() + " является звездой");
        } else {
            System.out.println(cosmicBody.getName() + " не является звездой");
        }
        return isStar;
    }
}
