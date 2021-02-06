package usatenko.services;

import usatenko.constants.ConsoleConstants;
import usatenko.factory.pojo.FindPathInputReaderFileFactory;
import usatenko.pojo.FindPathInputReaderFile;
import usatenko.pojo.FindPathInputReaderStdIn;

import java.util.Scanner;

public class ConsoleService {

    public static void initMazeAndPrintResult() {
        log(ConsoleConstants.GREETING_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case ConsoleConstants.SELECT_FILE_INPUT: {
                String inputMaze = FindPathInputReaderFileFactory.create().readFileAsString();
                printMaze(inputMaze);
                FindPathInputReaderFile.setInputMaze(inputMaze);
                FindPathInputReaderFile.fillMazeArray();
                break;
            }
            case ConsoleConstants.SELECT_KEYBOARD_INPUT: {
                log(ConsoleConstants.KEYBOARD_INPUT_INSTRUCTION);
                FindPathInputReaderStdIn.writeFileToString(scanner);
                printMaze(FindPathInputReaderStdIn.getInputMaze());
                FindPathInputReaderStdIn.fillMazeArray();
                break;
            }
        }
    }

    private static void log(String message) {
        System.out.println(message);
    }

    private static void printMaze(String maze) {
        log(maze);
    }
}
