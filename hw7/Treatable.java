package aadikatyal.cs1331.hw7;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * @author aadikatyal
 * @version 1.0
 *
 * Defining a new interface called Treatable.
 */
public interface Treatable {
    /**
     * The function returns the human age
     *
     * @param dogAge The age of the dog in dog years.
     * @return The human age of the dog.
     */
    static int convertDogToHumanYears(int dogAge) {
        return (int) (16 * Math.log(dogAge) + 31);
    }

    /**
     * Given a cat's age, return the equivalent human age.
     *
     * @param catAge The age of the cat in cat years.
     * @return The human age of the cat.
     */
    static int convertCatToHumanYears(int catAge) {
        return (int) (9 * Math.log(catAge) + 18);
    }

    /**
     * This function treats a Pet.
     */
     void treat();
}