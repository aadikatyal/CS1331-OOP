package aadikatyal.cs1331.hw6;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * ComputerScience object, subclass of Course
 *
 * @author aadikatyal
 * @version 1.0
 *
 */
public class ComputerScience extends Course {
    private String language;
    private boolean hasLab;

    /**
     * @param title       title of the course as a String
     * @param subject     subject of the course as a String
     * @param courseCode  course code of the course as a String
     * @param creditHours number of credit hours of the course as an int
     * @param language programming language of the course as a String
     * @param hasLab boolean value that indicates if course has a lab
     */
    public ComputerScience(String title, String subject, String courseCode, int creditHours, String language,
            boolean hasLab) {
        super(title, subject, courseCode, creditHours);
        this.language = language;
        this.hasLab = hasLab;
    }

    @Override
    public String summarize() {
        return super.summarize() + String.format(" The language used in this course is %s, and it %s a lab component.",
                this.language, hasLab ? "has" : "doesn’t have");
    }
}