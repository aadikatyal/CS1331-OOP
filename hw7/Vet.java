package aadikatyal.cs1331.hw7;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * @author aadikatyal
 * @version 1.0
 *
 * Declaring a class named Vet.
 */
public class Vet {
    /**
     * Prints pet as a String. If the pet is a dog, bark.
     *
     * @param pet The pet to inspect.
     */
    public void inspectPet(Pet pet) {
        System.out.println(pet);

        if (pet instanceof Dog) {
            ((Dog) pet).bark();
        }
    }

    /**
     * If the pet is a Treatable, then treat it
     *
     * @param pet This is the pet that we are treating.
     */
    public void treatPet(Pet pet) {
        if (pet instanceof Treatable) {
            System.out.println(String.format("Welcome to the vet %s", pet.getName()));
            ((Treatable) pet).treat();

            if (pet instanceof Dog) {
                System.out.println("Wow what a cute dog!");
                giveDogTreat((Dog) pet);
            }
        } else {
            System.out.println(String.format("Sorry, we cannot treat %s", pet.getName()));
        }
    }

    /**
     * This function takes a dog as a parameter and decreases its pain level by 2.
     *
     * @param dog The dog that is being given the treat.
     */
    public void giveDogTreat(Dog dog) {
        dog.setPainLevel(dog.getPainLevel() - 2);
    }
}