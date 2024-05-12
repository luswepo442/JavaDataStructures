## Word List Builder

This repository contains Java code for building and displaying word lists based on specified input files, data structure types, and maximum word frequencies.

### Getting Started

To use this application, follow these steps:

1. **Clone the Repository**
   ```bash
   git clone https://github.com/luswepo442/JavaDataStructures.git
   ```

2. **Navigate to the Repository**
   ```bash
   cd JavaDataStructures
   ```

3. **Compile and Run**
   - **Recommended (GUI):** Run `WordListGUI.java` to use the graphical user interface.
     ```bash
     javac WordListGUI.java
     java WordListGUI
     ```

   - **Alternative (Command Line):** If you prefer using command-line arguments, run `WordListMain2.java`.
     ```bash
     javac WordListMain2.java
     java WordListMain2 <input_file> <structure_type> <max_frequency>
     ```

### WordListGUI

- `WordListGUI.java` provides a graphical interface for inputting file paths, data structure types ('A', 'L', or 'H'), and maximum word frequencies. It uses Swing components to display the output word lists.

### WordListMain2

- `WordListMain2.java` is the main class responsible for processing the input file and building the word list based on the specified data structure type.

### Usage

#### Using WordListGUI (Graphical Interface)

1. Run `WordListGUI.java`.
2. Input the file path, data structure type ('A', 'L', or 'H'), and maximum word frequency.
3. Click "Build Word List" to generate the word list.
4. View the output directly in the graphical interface.

#### Using WordListMain2 (Command Line)

1. Compile `WordListMain2.java`.
   ```bash
   javac WordListMain2.java
   ```

2. Run with command line arguments:
   ```bash
   java WordListMain2 <input_file> <structure_type> <max_frequency>
   ```
   - `<input_file>`: Path to the input text file.
   - `<structure_type>`: Specify data structure type ('A' for ArrayList, 'L' for LinkedList, or 'H' for HashMap).
   - `<max_frequency>`: Maximum word frequency to display.

### Example

To build a word list using the GUI:

- Run `WordListGUI.java` and input the required information in the provided fields.

To build a word list using command-line arguments:

- Compile and run `WordListMain2.java` with specified arguments:
  ```bash
  java WordListMain2 input.txt A 5
  ```
  Replace `input.txt` with your input file path, `A` with desired data structure type, and `5` with the maximum word frequency.

### Sample Input Files

In this repository, you will find 3 sample input files that you can use:

- `bible-complete.txt`
- `bible-complete10.txt`
- `bible-psalms.txt`

Feel free to use them as input files when testing the application.

### Important Notes

- Ensure the input file exists and is accessible.
- Use valid data structure types ('A', 'L', or 'H') when running `WordListMain2`.
- Make sure to provide a positive integer value for the maximum word frequency.

### Author

- **Luswepo Daniel Sinyinza**
- Version: 6

For any issues or questions, please contact the author at daniel.luswepo@gmail.com
