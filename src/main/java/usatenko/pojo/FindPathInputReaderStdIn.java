package usatenko.pojo;

import usatenko.constants.ConsoleConstants;

import java.util.Scanner;

public class FindPathInputReaderStdIn extends AbstractFindPathInputReader {

    public static void writeFileToString(Scanner scanner) {
        boolean isEndEntering = true;
        StringBuilder inputMaze = new StringBuilder();
        do {
            String stringBuffer = scanner.nextLine();
            if (stringBuffer.equals(ConsoleConstants.END_ENTERING)) {
                isEndEntering = false;
            } else {
                inputMaze.append(stringBuffer + "\n");
            }
        }
        while (isEndEntering);
        FindPathInputReaderStdIn.setInputMaze(inputMaze.toString());
    }
}
