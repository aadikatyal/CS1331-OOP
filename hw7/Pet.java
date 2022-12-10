package aadikatyal.cs1331.hw7;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * @author aadikatyal
 * @version 1.0
 *
 *          Declaring a class called Pet that is public and abstract.
 */
public abstract class Pet {
    private String name;
    private int age;
    private int painLevel;

    /**
     * A constructor that takes in a name, age, and pain level and sets the instance
     * variables to those values.
     *
     * @param name      Pet name as a String
     * @param age       Pet age as an int
     * @param painLevel Pet painLevel as an int
     */
    public Pet(String name, int age, int painLevel) {
        this.name = name;
        this.age = (age < 1) ? 1 : (age > 100) ? 100 : age;
        this.painLevel = (painLevel < 1) ? 1 : (painLevel > 10) ? 10 : painLevel;
    }

    /**
     * This function takes a Pet as an argument and plays with it.
     *
     * @param p the Pet object to play with
     */
    public abstract void playWith(Pet p);

    @Override
    public String toString() {
        return String.format("My name is %s and I am %d. On a scale of one to ten my pain level is %d.", this.name,
                this.getAge(), this.painLevel);
    }

    @Override
    public boolean equals(Object other) {
        Pet otherPet = (Pet) other;
        return (other instanceof Pet) && (this.name.equals(otherPet.name) && this.getAge() == otherPet.getAge()
                && this.painLevel == otherPet.painLevel);
    }

    /**
     * If the age is less than 1, set it to 1. If the age is greater than 100, set
     * it to 100. Otherwise, set it to the age
     *
     * @param age The age of the person.
     */
    public void setAge(int age) {
        this.age = (age < 1) ? 1 : (age > 100) ? 100 : age;
    }

    /**
     * If the painLevel is less than 1, set it to 1. If the painLevel is greater
     * than 10, set it to 10. Otherwise, set it to the painLevel
     *
     * @param painLevel The pain level of the patient.
     */
    public void setPainLevel(int painLevel) {
        this.painLevel = (painLevel < 1) ? 1 : (painLevel > 10) ? 10 : painLevel;
    }

    /**
     * This function returns the value of the painLevel variable.
     *
     * @return The painLevel variable is being returned.
     */
    public int getPainLevel() {
        return this.painLevel;
    }

    /**
     * This function returns the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This function returns the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }
}