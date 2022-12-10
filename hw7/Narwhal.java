package aadikatyal.cs1331.hw7;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * @author aadikatyal
 * @version 1.0
 *
 *          Declaring a class called Narwhal that extends the Pet class.
 */
public class Narwhal extends Pet {
    private int hornLength;

    /**
     * A constructor that takes in a name, age, pain level, and horn length and sets
     * the instance variables to those values.
     *
     * @param name       Narwhal name as a String
     * @param age        Narwhal age as an int
     * @param painLevel  Narwhal painLevel as an int
     * @param hornLength Narwhal hornLength as an int
     */
    public Narwhal(String name, int age, int painLevel, int hornLength) {
        super(name, age, painLevel);
        this.hornLength = hornLength;
    }

    /**
     * This is a constructor that takes in no parameters and sets the instance
     * variables to the values given.
     */
    public Narwhal() {
        this("Jelly", 19, 2, 7);
    }

    @Override
    public void playWith(Pet p) {
        if (p instanceof Narwhal) {
            System.out.println("Who needs dogs and cats when we have each other");
            this.setPainLevel(this.getPainLevel() - 2);
        } else {
            System.out.println("I live in the ocean so I can’t play with you");
            this.setPainLevel(this.getPainLevel() + 1);
        }
    }

    @Override
    public String toString() {
        return String.format(
                "My name is %s and I am %d. On a scale of one to ten my pain level is %d. I have a horn that is %d"
                + "feet long.", this.getName(), this.getAge(), this.getPainLevel(), this.hornLength);
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other) && this.hornLength == ((Narwhal) other).hornLength;
    }
}