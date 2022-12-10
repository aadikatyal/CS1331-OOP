package aadikatyal.cs1331.hw6;

/* I worked on the assignment alone, using only course-provided materials. */

import java.util.Arrays;

/**
 * CourseCatalog object that holds all types of courses
 *
 * @author aadikatyal
 * @version 1.0
 *
 */
public class CourseCatalog {
    private Course[] catalog;

    /**
     * Constructs new CourseCatalog, no parameters
     */
    public CourseCatalog() {
        this.catalog = new Course[0];
    }

    /**
     * Constructs new CourseCatalog
     *
     * @param catalog course catalog
     *
     */
    public CourseCatalog(Course[] catalog) {
        Arrays.sort(catalog);
        this.catalog = catalog;
    }

    /**
     * Prints course catalog (including course code and course summary)
     */
    public void browseCourseCatalog() {
        Arrays.asList(this.catalog)
                .forEach(course -> System.out.println(course.courseCode + ": " + course.summarize()));
    }

    /**
     * adds newCourse to course catalog
     *
     * @param newCourse new Course
     */
    public void addCourse(Course newCourse) {
        Course[] newCatalog = new Course[getNumberOfCourses() + 1];
        System.out.println(newCatalog.length);

        Arrays.asList(newCatalog).addAll(Arrays.asList(this.catalog));
        newCatalog[newCatalog.length - 1] = newCourse;

        Arrays.sort(newCatalog);
        this.catalog = newCatalog;
    }

    /**
     * @param courseCode course code
     * @return Course corresponding to courseCode parameter
     */
    public Course getCourse(String courseCode) {
        return (Course) Arrays.stream(this.catalog).filter(course -> course.courseCode.equals(courseCode)).toArray()[0];
    }

    /**
     * @return number of courses in catalog
     */
    public int getNumberOfCourses() {
        return this.catalog.length;
    }
}