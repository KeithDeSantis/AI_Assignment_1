import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateBoard {
    String fileName = "random.txt";
    File file = new File(fileName);
    FileWriter fileWriter = new FileWriter(file, true);
    Random random = new Random();


    public GenerateBoard() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        GenerateBoard generateBoard = new GenerateBoard();
        for (int i = 0; i < 1; i++) {
            generateBoard.fileWriter.write(System.lineSeparator());
            generateBoard.generateBoard(8,8);
            generateBoard.fileWriter.flush();
        }
        generateBoard.fileWriter.close();

    }

    public void generateBoard(int boundI, int boundJ) throws IOException {
        int startI = random.nextInt(boundI);
        int startJ = random.nextInt(boundI);
        int goalI = random.nextInt(boundI);
        int goalJ = random.nextInt(boundI);

        for (int i = 0; i < boundI; i++) {
            for (int j = 0; j < boundJ; j++) {
                if(i == startI && j == startJ){
                    fileWriter.write("S" + "\t");
                    continue;
                }
                if(i == goalI && j == goalJ){
                    fileWriter.write("G" + "\t");
                    continue;
                }
                int cur = random.nextInt(9) +1;
                fileWriter.write(cur + "\t");
            }
            fileWriter.write(System.lineSeparator());
        }
    }
}