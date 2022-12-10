package aadikatyal.cs1331.hw4;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * Class represents the Mouse object
 * 
 * @author Aadi Katyal
 * @version 1.0
 */
public class Mouse {

    /** mass of Cat instance */
    private double mass;

    /** speed of Cat instance */
    private double speed;

    /**
     * Constructor that generates Mouse object
     *
     * @param mass  mass of Mouse represented as a double
     * @param speed speed of Mouse represented as a double
     */
    public Mouse(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    /**
     * Constructor that generates Mouse object
     *
     * @param mass mass of Mouse represented as a double
     */
    public Mouse(double mass) {
        this(mass, 10);
    }

    /**
     * Constructor that generates Mouse object
     */
    public Mouse() {
        this(50, 10);
    }

    /**
     * Increases mass by constant and modifies speed based on change
     */
    public void consumeCheese() {
        this.mass += 20;

        if (this.mass < 100) {
            this.speed++;
        } else {
            this.speed -= 0.5;
        }
    }

    /**
     * 
     * @return if Mouse instance is dead
     */
    public boolean isDead() {
        return mass == 0;
    }

    @Override
    public String toString() {
		if (this.mass == 0) {
			return String.format("I’m dead, but I used to be a mouse with a speed of %.2f", this.speed);
		} else {
			return String.format("I'm a speedy mouse with %.2f speed and %.2f mass.", this.speed, this.mass);
		}
	}

    /**
     *
     * @return mass mass instance
     */
    public double getMass() {
        return mass;
    }

    /**
     * Sets newMass param to mass
     *
     * @param newMass new mass
     */
    public void setMass(double newMass) {
        this.mass = newMass;
    }

    /**
     *
     * @return speed speed instance
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Sets newSpeed param to speed
     *
     * @param newSpeed new speed
     */
    public void setSpeed(double newSpeed) {
        this.speed = newSpeed;
    }
}