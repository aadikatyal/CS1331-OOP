package aadikatyal.cs1331.hw8;

/**
 * This class is a RuntimeException that is thrown when a file is not found
 *
 * @author aadikatyal
 * @version 1.0
 */
public class BadFileException extends RuntimeException {
    /**
     * Calling the constructor of the superclass (RuntimeException) and passing in
     * the message.
     *
     * @param message error message
     */
    public BadFileException(String message) {
        super(message);
    }

    /**
     * This is the default constructor. It is called when no arguments are passed to
     * the constructor.
     */
    public BadFileException() {
        super();
    }
}