import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BoardReader {

    public BoardReader() {
    }

    public String[][] read(String fileName) throws IOException {

        int numLines = 0;

        File text = new File(fileName);

        // Get number of rows
        Scanner sc = new Scanner(text);
        while(sc.hasNextLine()) {
            sc.nextLine();
            numLines++;
        }

        Scanner scanner = new Scanner(text);

        String line;

        // Look at first line to get number of columns
        String[] firstLine = scanner.nextLine().split(" ");

        int numColumns = firstLine.length;

        String[][] board = new String[numLines][numColumns];
        board[0] = firstLine; //Does this work?

        int boardRowNum = 1;

        // Load each other line into the board
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            board[boardRowNum] = line.split(" ");
            boardRowNum++;

        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
        return board;

    }


}
