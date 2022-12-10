package aadikatyal.cs1331.hw4;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * Class represents the House runner
 *
 * @author Aadi Katyal
 * @version 1.0
 */
class House {
	/**
	 * 
	 * @param args args
	 */
    public static void main(String[] args) {
        Cat cat1 = new Cat("Garfield");
        Cat cat2 = new Cat("Tom", 10, 15);
        Cat cat3 = new Cat("Meowth", 4.6, 5);
        Cat customCat = new Cat("Max");

        Mouse mouse1 = new Mouse(100, 3);
        Mouse mouse2 = new Mouse(60);
        Mouse mouse3 = new Mouse();

        Cat.setBreed("1331 Cats");

        System.out.println(cat1);
        System.out.println(mouse2);

        cat3.increaseAge(8);

        cat3.eat(mouse2);
        System.out.println(mouse2);
        System.out.println(cat2);
        System.out.println(customCat);

        cat3.increaseAge(4);

        System.out.println(cat3);
        System.out.println(cat1);
    }
}