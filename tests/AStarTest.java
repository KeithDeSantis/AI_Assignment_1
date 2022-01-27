import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class AStarTest {

    @Test
    void testOne() {

        Coordinate start = new Coordinate(0,0);
        Coordinate goal = new Coordinate(0,0);
        BoardReader boardReader = new BoardReader();
        int[][] board = null;

        try {

            board = boardReader.read("testOne.txt", start, goal);

        } catch (IOException e) { System.out.println("Could not find file.");}

        AStar test = AStarFactory.produceAstarWithSpecificHeuristics(4);
        Result result = test.findPath(board, start, goal);

        Assertions.assertEquals(2, result.getNumActions());
        Assertions.assertEquals(98, result.getScore());
    }
}
