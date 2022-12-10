package aadikatyal.cs1331.hw6;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * MechanicalEngr object, subclass of Course
 *
 * @author aadikatyal
 * @version 1.0
 *
 */
public class MechanicalEngr extends Course {
    private String[] equations;

    /**
     * @param title       title of the course as a String
     * @param subject     subject of the course as a String
     * @param courseCode  course code of the course as a String
     * @param creditHours number of credit hours of the course as an int
     * @param equations   equations used in the course as a String array
     */
    public MechanicalEngr(String title, String subject, String courseCode, int creditHours, String[] equations) {
        super(title, subject, courseCode, creditHours);
        this.equations = equations;
    }

    @Override
    public String summarize() {
        String equationsStr = "";

        for (int i = 0; i < equations.length; i++) {
            equationsStr += equations[i] + (i == equations.length - 1 ? "." : ", ");
        }
        return super.summarize() + " This course uses these equation(s): " + equationsStr;
    }
}