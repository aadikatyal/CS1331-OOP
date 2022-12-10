package aadikatyal.cs1331.hw7;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * @author aadikatyal
 * @version 1.0
 *
 *          This class is a subclass of Pet that implements the Treatable
 *          interface
 */
public class Cat extends Pet implements Treatable {
    private boolean hasStripes;

    /**
     * This is a constructor for the Cat class. It takes in a name, age, pain level,
     * and whether or not the cat has stripes.
     *
     * @param name       Cat name as a String
     * @param age        Cat age as an int
     * @param painLevel  Cat painLevel as an int
     * @param hasStripes decides if Cat has stripes or not
     */
    public Cat(String name, int age, int painLevel, boolean hasStripes) {
        super(name, age, painLevel);
        this.hasStripes = hasStripes;
    }

    /**
     * A constructor that takes in a boolean value for whether or not the cat has
     * stripes.
     *
     * @param hasStripes decides if Cat has stripes or not
     */
    public Cat(boolean hasStripes) {
        this("Purrfect", 4, 9, hasStripes);
    }

    @Override
    public void playWith(Pet p) {
        if (p instanceof Cat) {
            if (this.hasStripes == ((Cat) p).hasStripes) {
                setPainLevel(this.getPainLevel() - 4);
                System.out.println("Meow! I love playing with other cats with the same pattern as me");
            } else {
                setPainLevel(this.getPainLevel() - 2);
                System.out.println("Meow! I like playing with other cats without the same pattern as me");
            }
        } else if (p instanceof Dog) {
            setPainLevel(this.getPainLevel() - 1);
            System.out.println(String.format("Meow. Go away %s! I don’t like playing with Dogs!", ((Dog) p).getName()));
        }
    }

    @Override
    public void treat() {
        this.setPainLevel(this.getPainLevel() - 1);
    }

    @Override
    public String toString() {
        return String.format(
                "My name is %s, and I am %d. On a scale of one to ten my pain level is %d. My age in human years is %d"
                + ".", this.getName(), this.getAge(), this.getPainLevel(),
                Treatable.convertDogToHumanYears(this.getAge()));
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other) && this.hasStripes == ((Cat) other).hasStripes;
    }

    /**
     * A getter method for the hasStripes field.
     *
     * @return hasStripes
     */
    public boolean getHasStripes() {
        return hasStripes;
    }
}