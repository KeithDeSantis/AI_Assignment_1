import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        BoardReader boardReader = new BoardReader();

        int[][] board = null;

        Coordinate start = new Coordinate(0,0);
        Coordinate goal = new Coordinate(0,0);

        try {

            board = boardReader.read("board.txt", start, goal);

        } catch (IOException e) { System.out.println("Could not find file.");}

        Coordinate[][] coordBoard = boardReader.translateToCoord(board);

        AStar test = AStarFactory.produceAstarWithSpecificHeuristics(1);
        start.setDirection(Direction.N);
        test.findPath(board, start, goal);
    }

}
