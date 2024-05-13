import java.io.*;
import java.util.*;

/**
 * WordListMain2 class handles the creation of a word list based on the type of data structure selected.
 * This class reads a text file, extracts verses, and adds words to the selected word list data structure.
 * @author TMyatt, modified by Luswepo Daniel Sinyinza
 * @version 5
 */
public class WordListMain2 {
	/**
     * Default constructor.
     * This class does not have any specific initialization in the default constructor.
     * It is created automatically by the compiler if no constructor is defined.
     */
    public WordListMain2() {
    }
    static WordList wordList;

    /**
     * Extracts the verse text from a line of input.
     *
     * @param inLine Input line containing tab-separated verse data.
     * @return Extracted verse text.
     */
    static String getVerse(String inLine) {
        String[] ver = inLine.split("\t");
        return ver[1];
    }

    /**
     * Sets the word list data structure based on the specified command.
     *
     * @param cmd Command string ('A', 'L', or 'H').
     */
    static void getCommand(String cmd) {
        switch (cmd.toLowerCase()) {
            case "a":
                wordList = new WordArrayList();
                break;
            case "l":
                wordList = new WordLinkedList();
                break;
            case "h":
                wordList = new WordHashMap();
                break;
            default:
                // Display error message for invalid command
                System.out.println("Invalid command: Please input 'A', 'L', or 'H' for the second argument.");
                System.exit(0); // Exit the program gracefully
        }
    }

    /**
     * Main method for processing the input file and building the word list.
     *
     * @param args Command line arguments: [0] input file path, [1] data structure type ('A', 'L', or 'H'),
     *             [2] maximum word frequency to display.
     */
    public static void main(String[] args) {
        if (args.length < 3) {
            // Display error message for insufficient arguments
            System.out.println("Error: insufficient arguments, please input all 3 valid arguments");
            return;
        }

        try {
            // Open the specified text file for reading
            File inputFile = new File(args[0]);
            if (!inputFile.exists()) {
                // Display error message for non-existent input file
                System.out.println("Error: The input file or directory does not exist. Please use the correct input file path for the first argument.");
                return;
            }

            Scanner scanner = new Scanner(inputFile);
            getCommand(args[1]);

            // Check if the third argument is a positive integer
            int maxFrequency = Integer.parseInt(args[2]);
            if (maxFrequency <= 0) {
                System.out.println("Error: Please only input positive integers for the third argument.");
                return;
            }

            // Read the input file line by line and process each verse
            while (scanner.hasNextLine()) {
                String inLine = scanner.nextLine();
                String verse = getVerse(inLine);
                String[] verseParsed = verse.split("[ :;,.'!?()-]+");

                for (String s : verseParsed) {
                    wordList.addWord(s.toLowerCase());
                }
            }

            scanner.close();
            wordList.printWordList(maxFrequency);
        } catch (NumberFormatException e) {
            // Display error message for invalid integer input
            System.out.println("Error: Please only use valid integers for the third argument.");
        } catch (Exception e) {
            // Display generic error message for other exceptions
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
