import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class chessDriver {
    public static void main(String[] arg) {
        String[] row = new String[8];
        int count = 0;
        
        try {
            Scanner input = new Scanner(new File("Chessboard.txt"));
            while (input.hasNextLine() && count < 8) {
                row[count] = input.nextLine();
                count++;
                System.out.println(row[count-1]);
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("Chessboard.txt file not found!");
            e.printStackTrace();
            return;
        }

        Map map = new Map(row);
        map.calc(true);   
        map.bestMove(); 
    }
}
