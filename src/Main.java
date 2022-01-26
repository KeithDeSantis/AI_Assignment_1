import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        BoardReader boardReader = new BoardReader();

        int[][] board = null;

        Coordinate start = new Coordinate(0,0);
        Coordinate goal = new Coordinate(0,0);

        try {

            board = boardReader.read("board.txt", start, goal);
            //System.out.println(Arrays.deepToString(board));
//            System.out.println(board[1][0]);

        } catch (IOException e) { System.out.println("Could not find file.");}

        Coordinate[][] coordBoard = boardReader.translateToCoord(board);

        AStar test = new AStar();
//        Coordinate s = CoordinateFactory.makeCoorWithPriority(1,0, 3);
//        Coordinate g = CoordinateFactory.makeCoorWithPriority(2,1, 4);
//        PriorityQueue<Coordinate> pQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.priority));
//        pQueue.add(s);
//        pQueue.add(g);
//        System.out.println(pQueue.remove().priority);
//        System.out.println(pQueue.remove().priority);

        start.setDirection(Direction.N);
        test.findPath(board, start, goal);
    }

}
