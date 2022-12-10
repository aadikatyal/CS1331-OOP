package aadikatyal.cs1331.hw5;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * Represents FireBender object
 *
 * @author aadikatyal
 * @version 1.0
 */
public class FireBender extends Bender {
    private static double fireSourceStrength = 1;

    /**
     * @param name FireBender name as a String
     * @param strength FireBender strength as an int
     * @param health FireBender health as an int
     */
    public FireBender(String name, int strength, int health) {
        super(name, strength, health);
    }

    /**
     * @param name FireBender name as a String
     */
    public FireBender(String name) {
        super(name, 60, 50);
    }

    /**
     * @param b other Bender object
     */
    @Override
    public void attack(Bender b) {
        if (this.isAlive()) {
            if (b instanceof WaterBender) {
                b.setHealth(b.getHealth() - (int) (this.getStrength() * fireSourceStrength));
            } else if (b instanceof FireBender) {
                b.setHealth((int) (b.getHealth() - fireSourceStrength));
            }

            if (b.getHealth() < 0) {
                b.setHealth(0);
            }

            fireSourceStrength -= 0.05;
        }
    }

    /**
     * Modify fireSourceStrength based on strength
     */
    public void replenishFireSources() {
        if (this.getStrength() < 50) {
            if (fireSourceStrength < 0.8) {
                fireSourceStrength = 0.8;
            } else {
                fireSourceStrength = 1;
            }
        }
    }

    /**
     * @return if this and other are equal
     */
    @Override
    public boolean equals(Object other) {
        return other instanceof FireBender && super.equals(other);
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    /**
     * @return String representation of this
     */
    @Override
    public String toString() {
        return super.toString() + " I bend fire.";
    }

    /**
     * @return fireSourceStrength
     */
    public static double getFireSourceStrength() {
        return fireSourceStrength;
    }
}