package usatenko.pojo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ShortestPathTest {

    private static char[][] matrix = {
            {'S','.','.'},
            {'#','#','.'},
            {'X','.','.'}


    };

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shortestPath() {
        // arrange
        int[] startIndexes = {0 ,0};
        int[] endIndexes = {0 ,0};
        // act
        Executable action = () -> ShortestPath.shortestPath(matrix, startIndexes, endIndexes);
        // assert
        assertDoesNotThrow(action);
    }
}