import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

/**
 * WordListGUI is a graphical user interface for building and displaying word lists
 * based on specified input file, data structure type, and maximum word frequency.
 *
 * @author Luswepo Daniel Sinyinza
 * @version 6
 */

public class WordListGUI extends JFrame {

    /**
     * Text field for specifying the input file path.
     */
    private JTextField inputFileField;

    /**
     * Text field for specifying the data structure type ('A', 'L', or 'H').
     */
    private JTextField structureTypeField;

    /**
     * Text field for specifying the maximum word frequency.
     */
    private JTextField maxFrequencyField;

    /**
     * Text area used for displaying output messages or word lists.
     */
    private JTextArea outputArea;

    // Rest of your class code...


    /**
     * Constructs a WordListGUI instance with the necessary components.
     */
    public WordListGUI() {
        super("Word List Builder");

        JLabel inputFileLabel = new JLabel("Input File Path:");
        inputFileField = new JTextField(30);

        JLabel structureTypeLabel = new JLabel("Data Structure ('A', 'L', or 'H'):");
        structureTypeField = new JTextField(10);

        JLabel maxFrequencyLabel = new JLabel("Max Word Frequency:");
        maxFrequencyField = new JTextField(5);

        JButton buildButton = new JButton("Build Word List");
        buildButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buildWordList();
            }
        });

        outputArea = new JTextArea(20, 60);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        inputPanel.add(inputFileLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(inputFileField, gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        inputPanel.add(structureTypeLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(structureTypeField, gbc);
        gbc.gridy = 2;
        gbc.gridx = 0;
        inputPanel.add(maxFrequencyLabel, gbc);
        gbc.gridx = 1;
        inputPanel.add(maxFrequencyField, gbc);
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(buildButton, gbc);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Builds the word list based on the input parameters specified by the user.
     * Handles validation and processing of user inputs and displays results in the output area.
     */
    private void buildWordList() {
        // Clear the output area before displaying new content
        outputArea.setText("");

        while (true) {
            String inputFile = inputFileField.getText().trim();
            String structureType = structureTypeField.getText().trim().toLowerCase();
            String maxFrequencyStr = maxFrequencyField.getText().trim();

            if (inputFile.isEmpty() || structureType.isEmpty() || maxFrequencyStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all 3 fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int maxFrequency = Integer.parseInt(maxFrequencyStr);
                if (maxFrequency <= 0) {
                    JOptionPane.showMessageDialog(this, "Max Frequency must be a positive integer.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (!structureType.equals("a") && !structureType.equals("l") && !structureType.equals("h")) {
                    JOptionPane.showMessageDialog(this, "Invalid data structure type. Please use 'A', 'L', or 'H'.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                PrintStream printStream = new PrintStream(new CustomOutputStream(outputArea));
                System.setOut(printStream);

                String[] args = {inputFile, structureType, maxFrequencyStr};
                WordListMain2.main(args);

                // Ask user to continue or exit
                String userInput = JOptionPane.showInputDialog(this, "Press '0' to view the output or any other key to continue inputting arguments.");
                if ("0".equals(userInput)) {
                    break; // Exit the loop if user enters '0'
                }

                // Clear input fields for next iteration
                inputFileField.setText("");
                structureTypeField.setText("");
                maxFrequencyField.setText("");

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Max Frequency must be a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * The main method to start the WordListGUI application.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new WordListGUI();
            }
        });
    }

    /**
     * CustomOutputStream is an OutputStream that writes its output to a JTextArea component.
     */
    class CustomOutputStream extends OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) throws IOException {
            textArea.append(String.valueOf((char) b));
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
}
