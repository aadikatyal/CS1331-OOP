package aadikatyal.cs1331.hw6;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * Course superclass
 *
 * @author aadikatyal
 * @version 1.0
 *
 */
public abstract class Course implements Comparable<Course>, Summarizable {
    private String title;
    private String subject;
    protected String courseCode;
    private int creditHours;

    /**
     * @param title       title of the course as a String
     * @param subject     subject of the course as a String
     * @param courseCode  course code of the course as a String
     * @param creditHours number of credit hours of the course as an int
     */
    public Course(String title, String subject, String courseCode, int creditHours) {
        this.title = title;
        this.subject = subject;
        this.courseCode = courseCode;
        this.creditHours = creditHours;
    }

    @Override
    public int compareTo(Course o) {
        return this.courseCode.compareTo(o.courseCode);
    }

    @Override
    public String summarize() {
        return String.format("This course is %s. The course is %d credit hours.", this.title, this.creditHours);
    }
}