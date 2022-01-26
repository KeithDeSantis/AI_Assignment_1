import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        String filename = args[1]; // First command line arg, the name of the board file
        String heuristic = args[2]; // Second command line arg, the number heuristic to use
        BoardReader boardReader = new BoardReader();
        int[][] board = null;
        Coordinate start = new Coordinate(0,0);
        Coordinate goal = new Coordinate(0,0);

        try { board = boardReader.read("board.txt", start, goal); } //TODO change input to filename for final
        catch (IOException e) {
            System.out.println("Could not find file.");
            return; }

        Coordinate[][] coordBoard = boardReader.translateToCoord(board); // May end up not being necessary

        AStar test = new AStar();

        start.setDirection(Direction.N);
        test.findPath(board, start, goal);
    }

}
