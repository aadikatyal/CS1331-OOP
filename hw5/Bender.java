package aadikatyal.cs1331.hw5;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * Represents abstract Bender object
 *
 * @author aadikatyal
 * @version 1.0
 */

public abstract class Bender {
    private String name;
    private int strength;
    private int health;

    /**
     * @param name Bender name as a String
     * @param strength Bender strength as an int
     * @param health Bender health as an int
     */
    public Bender(String name, int strength, int health) {
        this.name = name;
        this.strength = strength;
        this.health = health;
    }

    /**
     * @return if bender instance is alive based on health value
     */
    public boolean isAlive() {
        return this.health > 0;
    }

    /**
     * @param b Bender that this instance will attack
     */
    public abstract void attack(Bender b);

    /**
     * @return if this and other are equal
     */
    @Override
    public boolean equals(Object other) {
        Bender otherBender = (Bender) other;
        return other instanceof Bender && this.name.equals(otherBender.getName())
                && this.strength == otherBender.getStrength() && this.health == otherBender.getHealth();
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    /**
     * @return String representation of Bender
     */
    @Override
    public String toString() {
        return String.format("My name is %s. I am a bender. My strength is %s and my current health is %s.", this.name,
                this.strength, this.health);
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    public int getStrength() {
        return strength;
    }

    /**
     * @param strength new strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health new health
     */
    public void setHealth(int health) {
        this.health = health;
    }
}