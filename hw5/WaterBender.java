package aadikatyal.cs1331.hw5;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * Represents WaterBender object
 *
 * @author aadikatyal
 * @version 1.0
 *
 */
public class WaterBender extends Bender {
    private boolean healer;

    /**
     * @param name WaterBender name as a String
     * @param strength WaterBender strength as an int
     * @param health WaterBender health as an int
     * @param healer defines if WaterBender is a healer
     */
    public WaterBender(String name, int strength, int health, boolean healer) {
        super(name, strength, health);
        this.healer = healer;
    }

    /**
     * @param name WaterBender name as a String
     */
    public WaterBender(String name) {
        super(name, 40, 80);
        this.healer = false;
    }

    /**
     * @param b other Bender object
     */
    @Override
    public void attack(Bender b) {
        if (this.isAlive()) {
            if (b instanceof FireBender) {
                b.setHealth(b.getHealth() - this.getStrength());
            } else if (b instanceof WaterBender) {
                b.setHealth(b.getHealth() - 1);
            }

            if (b.getHealth() < 0) {
                b.setHealth(0);
            }
        }
    }

    /**
     * @param wb other WaterBender object
     */
    public void heal(WaterBender wb) {
        if (this.healer || (!this.isAlive() || !wb.isAlive())) {
            return;
        }

        if (!wb.isHealer()) {
            wb.setHealth(wb.getHealth() + 20);
        } else {
            wb.setHealth(wb.getHealth() + 40);
        }
    }

    /**
     * @return if this and other are equal
     */
    @Override
    public boolean equals(Object other) {
        return super.equals(other) && this.healer == ((WaterBender) other).isHealer();
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    /**
     * @return String representation of WaterBender
     */
    @Override
    public String toString() {
        return super.toString()
                + String.format(" With my waterbending, I %s heal others.", this.healer ? "can" : "cannot");
    }

    /**
     * @return healer
     */
    public boolean isHealer() {
        return healer;
    }
}