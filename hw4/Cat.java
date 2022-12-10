package aadikatyal.cs1331.hw4;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * Class represents the Cat object
 *
 * @author Aadi Katyal
 * @version 1.0
 */
public class Cat {

    /** @name of Cat instance */
    private String name;

    /** age (in months) of Cat instance */
    private int age;

    /** running speed of Cat instance */
    private double runningSpeed;

    /** denotes if Cat instance is considered a kitten */
    private boolean isKitten;

    /** default breed amongst all Cat instances */
    private static String breed = "Persian Tabby";

    /**
     * Constructor that generates Cat object
     *
     * @param name         name of Cat represented as a String
     * @param age          age of Cat in months represented as an int
     * @param runningSpeed speed of Cat represented as a double
     */
    public Cat(String name, int age, double runningSpeed) {
        this.name = name;
        this.age = age;
        this.runningSpeed = runningSpeed;
        this.isKitten = this.age <= 6 ? true : false;
    }

    /**
     * Constructor that generates Cat object
     *
     * @param name         name of Cat represented as a String
     * @param ageInYears   age of Cat in years represented as a double
     * @param runningSpeed speed of Cat represented as a double
     */
    public Cat(String name, double ageInYears, double runningSpeed) {
        this(name, (int) (ageInYears * 12), runningSpeed);
    }

    /**
     * Constructor that generates Cat object
     *
     * @param name name of Cat represented as a String
     */
    public Cat(String name) {
        this(name, 5, 5);
    }

    /**
     * Increases age by numMonths param; modifies runningSpeed
     *
     * @param numMonths number of months age
     */
    public void increaseAge(int numMonths) {
        for (int i = 0; i < numMonths; i++) {
            if (this.age < 12) {
                this.runningSpeed += 2;
            } else if (this.age > 30) {
                this.runningSpeed -= 3;
            }

            if (this.runningSpeed < 5) {
                this.runningSpeed = 5;
            }

            this.age++;
        }

        this.isKitten = this.age <= 6 ? true : false;
    }

    /**
     * Calls overloaded increaseAge
     */
    public void increaseAge() {
        increaseAge(1);
    }

    /**
     * Cat instance tries to eat a Mouse
     *
     * @param mouse instance of Mouse
     */
    public void eat(Mouse mouse) {
        if (mouse.isDead()) {
            return;
        }

        if (this.runningSpeed > mouse.getSpeed()) {
            if (mouse.getMass() * 0.65 >= this.age) {
                increaseAge();
            }
            mouse.setMass(0);
        } else {
            mouse.consumeCheese();
        }
    }

    @Override
    public String toString() {
        return this.isKitten
                ? String.format("My name is %s and I'm a Kitten! I'm %d months old and I run at the speed of %.2f.",
                        this.name, this.age, this.runningSpeed)
                : String.format("My name is %s and I'm a %s. I'm %d months old and I run at the speed of %.2f.",
                        this.name, breed, this.age, this.runningSpeed);
    }

    /**
     *
     * @return breed
     */
    public static String getBreed() {
        return breed;
    }

    /**
     * Sets newBreed param to breed
     *
     * @param newBreed new breed
     */
    public static void setBreed(String newBreed) {
        breed = newBreed;
    }

    /**
     *
     * @return name Cat name
     */
    String getName() {
        return this.name;
    }

    /**
     * Sets newName param to name
     *
     * @param newName new name
     */
    public void setName(String newName) {
        this.name = newName;
    }

    /**
     *
     * @return age Cat age
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Sets newAge param to age
     *
     * @param newAge new age
     */
    public void setAge(int newAge) {
        this.age = newAge;
        this.isKitten = this.age <= 6 ? true : false;
    }

    /**
     *
     * @return runningSpeed running speed
     */
    public double getRunningSpeed() {
        return this.runningSpeed;
    }

    /**
     * Sets newRunningSpeed param to runningSpeed
     *
     * @param newRunningSpeed new running speed
     */
    public void setRunningSpeed(double newRunningSpeed) {
        this.runningSpeed = newRunningSpeed;
    }

    /**
     *
     * @return isKitten is kitten
     */
    public boolean getIsKitten() {
        return this.isKitten;
    }
}