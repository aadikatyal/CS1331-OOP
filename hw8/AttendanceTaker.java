package aadikatyal.cs1331.hw8;

/* I worked on the assignment alone, using only course-provided materials. */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * AttendanceTaker class declaration.
 *
 * @author aadikatyal
 * @version 1.0
 */
public class AttendanceTaker {
    private File inputFile;
    private File outputFile;

    /**
     * A constructor that takes in two files and sets the instance variables to
     * those files.
     *
     * @param inputFile  input file
     * @param outputFile output file
     */
    public AttendanceTaker(File inputFile, File outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    /**
     * It's a constructor that takes in two strings and sets the instance variables
     * to those strings.
     *
     * @param inputFileName  input file name
     * @param outputFileName output file name
     */
    public AttendanceTaker(String inputFileName, String outputFileName) {
        this(new File(inputFileName), new File(outputFileName));
    }

    /**
     * The function takes attendance by reading in a list of names from a file,
     * asking the user for attendance information for each name, and writing the
     * attendance information to an output file
     */
    public void takeAttendance() throws FileNotFoundException {
        Scanner scanner = null;
        String[] names = null;

        try {
            scanner = new Scanner(inputFile);

            if (inputFile.length() == 0) {
                throw new BadFileException("The input file was empty");
            }

            String info = scanner.nextLine();
            if (!(info.startsWith("|--") && info.endsWith("--|"))) {
                throw new BadFileException("The file doesn't have correct beginning or end");
            }

            info = info.substring(3, info.length() - 3);

            names = info.split("---");
        } catch (NoSuchElementException e) {
            throw new BadFileException();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        Scanner consoleScanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(outputFile);

        for (String name : names) {
            try {
                processStudentAttendance(name, consoleScanner, pw);
            } catch (InvalidNameFormatException e) {
                System.out.println(
                        String.format("Skipping %s because of an invalid name format: %s", name, e.getMessage()));
            } catch (InvalidAttendanceInformationException e) {
                System.out.println(String.format("Skipping %s because of an invalid attendance information: %s", name,
                        e.getMessage()));
            }
        }

        consoleScanner.close();
        pw.close();
    }

    /**
     * It reads a student's name and attendance information from the console, and
     * writes the attendance information to a file
     *
     * @param name           The name of the student
     * @param consoleScanner A Scanner object that reads from the console.
     * @param printWriter    The PrintWriter object that will be used to write to
     *                       the output file.
     */
    private static void processStudentAttendance(String name, Scanner consoleScanner, PrintWriter printWriter)
            throws InvalidNameFormatException, InvalidAttendanceInformationException {
        if (!name.equals(name.toUpperCase())) {
            printWriter.println("-");
            throw new InvalidNameFormatException("The name isn't uppercase only");
        } else {
            for (char c : name.toCharArray()) {
                if (Character.isDigit(c)) {
                    printWriter.println("-");
                    throw new InvalidNameFormatException("The name has a digit");
                }

                if (c == '|') {
                    printWriter.println("-");
                    throw new InvalidNameFormatException("The name has a pipe character");
                }
            }

            System.out.print(name + ": ");
            String str = consoleScanner.nextLine();

            if (str.isEmpty()) {
                printWriter.println("-");
                throw new InvalidAttendanceInformationException("Attendance information missing");
            }

            if (!(str.equals("A") || str.equals("P"))) {
                printWriter.println("-");
                throw new InvalidAttendanceInformationException("Attendance information is not P or A");
            }

            printWriter.println(str);
        }
    }

    /**
     * The main function takes in two command line arguments, the first being the
     * name of the file containing the list of students, and the second being the
     * name of the file to write the attendance to. It then creates an
     * AttendanceTaker object, and calls the takeAttendance function on it
     *
     * @param args console arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        AttendanceTaker at = new AttendanceTaker(args[0], args[1]);
        at.takeAttendance();
    }
}