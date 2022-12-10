package aadikatyal.cs1331.hw8;

/* I worked on the assignment alone, using only course-provided materials. */

/**
 * This class is a custom exception that is thrown when the attendance
 * information is invalid
 *
 * @author aadikatyal
 * @version 1.0
 */
public class InvalidAttendanceInformationException extends Exception {
    /**
     * Calling the superclass's constructor with the message parameter.
     *
     * @param message error message
     */
    public InvalidAttendanceInformationException(String message) {
        super(message);
    }

    /**
     * Calling the superclass's constructor with no parameters.
     */
    public InvalidAttendanceInformationException() {
        super();
    }
}