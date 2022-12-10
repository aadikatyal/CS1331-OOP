package aadikatyal.cs1331.hw7;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * @author aadikatyal
 * @version 1.0
 *
 * Declaring a class called Dog that extends the Pet class and implements the
 * Treatable interface.
 */
public class Dog extends Pet implements Treatable {
    private String breed;

    /**
     * A constructor that takes in a name, age, pain level, and breed and sets the
     * instance variables to those values.
     *
     * @param name Dog name as a String
     * @param age Dog age as an int
     * @param painLevel Dog painLevel as an int
     * @param breed Dog breed as a String
     */
    public Dog(String name, int age, int painLevel, String breed) {
        super(name, age, painLevel);
        this.breed = breed;
    }

    /**
     * This is a constructor that takes in a breed and sets the name, age, and pain
     * level to default values.
     *
     * @param breed Dog breed as a String
     */
    public Dog(String breed) {
        this("Buzz", 6, 3, breed);
    }

    @Override
    public void playWith(Pet p) {
        if (p instanceof Dog) {
            int oldPainLevel = this.getPainLevel();
            treat();
            System.out.println(
                    String.format("Woof! I love playing with other dogs so much that my pain level went from %d to %d",
                            oldPainLevel, this.getPainLevel()));
        } else if (p instanceof Cat) {
            Cat cat = (Cat) p;
            if (!cat.getHasStripes()) {
                this.setPainLevel(this.getPainLevel() - 1);
            } else {
                this.setPainLevel(this.getPainLevel() + 2);
            }
        }
    }

    @Override
    public void treat() {
        this.setPainLevel(this.getPainLevel() - 3);
    }

    /**
     * Function prints the string `"bark bark"` to the console
     */
    public void bark() {
        System.out.println("bark bark");
    }

    @Override
    public String toString() {
        return String.format(
                "My name is %s, I am %d, and I am a %s. On a scale of one to ten my pain level is %d. My age in human"
                + "years is %d.", this.getName(), this.getAge(), this.breed, this.getPainLevel(),
                Treatable.convertDogToHumanYears(this.getAge()));
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other) && this.breed.equals(((Dog) other).breed);
    }
}