package usatenko.pojo;

public abstract class AbstractFindPathInputReader {
    private static int [] startCharIndex;
    private static  int [] endCharIndex;
    private static char [][] maze;
    private static String inputMaze;

    public static void fillMazeArray() {
        // read
        String text = AbstractFindPathInputReader.inputMaze;
        char[] textChars = text.toCharArray();
        int sizeX = (int) text.chars().filter(ch -> ch == '\n').count() + 1;
        int sizeY = text.indexOf('\n') + 1;
        AbstractFindPathInputReader.maze = new char[sizeX][sizeY];
        AbstractFindPathInputReader.startCharIndex = new int[2];
        AbstractFindPathInputReader.endCharIndex = new int[2];
        int x = 0, y = 0;
        boolean isNChar;
        boolean isStartChar;
        boolean isEndChar;
        for (char c : textChars) {
            isNChar = c == '\n';
            isStartChar = c == 'S';
            isEndChar = c == 'X';

            if (isNChar) {
                y = -1;
                x++;
            } else {
                maze[x][y] = c;
                if (isStartChar) {
                    startCharIndex[0] = x;
                    startCharIndex[1] = y;
                    maze[x][y] = '.';
                }
                if (isEndChar) {
                    endCharIndex[0] = x;
                    endCharIndex[1] = y;
                    maze[x][y] = '.';
                }
            }
            y++;
        }
        ShortestPath.shortestPath(maze, startCharIndex, endCharIndex);
    }

    public static int[] getStartCharIndex() {
        return startCharIndex;
    }

    public static void setStartCharIndex(int[] startCharIndex) {
        AbstractFindPathInputReader.startCharIndex = startCharIndex;
    }

    public static int[] getEndCharIndex() {
        return endCharIndex;
    }

    public static void setEndCharIndex(int[] endCharIndex) {
        AbstractFindPathInputReader.endCharIndex = endCharIndex;
    }

    public static char[][] getMaze() {
        return maze;
    }

    public static void setMaze(char[][] maze) {
        AbstractFindPathInputReader.maze = maze;
    }

    public static String getInputMaze() {
        return inputMaze;
    }

    public static void setInputMaze(String inputMaze) {
        AbstractFindPathInputReader.inputMaze = inputMaze;
    }
}
