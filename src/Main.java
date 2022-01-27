import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        BoardReader boardReader = new BoardReader();

        int[][] board = null;

        Coordinate start = new Coordinate(0,0);
        Coordinate goal = new Coordinate(0,0);

        String filename = args[0];
        int heuristic = 0;
        try {
            heuristic = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.out.println("Second argument must be an integer 1-6.");
            return;
        }

        try {

            board = boardReader.read(filename, start, goal);

        } catch (IOException e) { System.out.println("Could not find file.");}

        long startTimer = System.currentTimeMillis();

        AStar test = AStarFactory.produceAstarWithSpecificHeuristics(heuristic);
        Result result = test.findPath(board, start, goal);

        System.out.println(result);

        long endTimer = System.currentTimeMillis();

        long timeElapsed = (endTimer - startTimer)/1000;

        System.out.println("Program took " + timeElapsed + " seconds");
    }

}
