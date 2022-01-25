import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        BoardReader boardReader = new BoardReader();

        String[][] board = new String[0][0];

        try {

            board = boardReader.read("board.txt");
            System.out.println(Arrays.deepToString(board));

        } catch (IOException e) { System.out.println("Could not find file.");}

    }

}
