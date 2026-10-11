import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class chessDriver{
	public static void main(String[] arg){
		Scanner input = new Scanner("Chessboard.txt");
		String[] row = new String [7];
		int count = 1;
		try{
			while(input.hasNextLine()){
				row[count] = input.nextLine();
				count++;
			}
		}
		finally{
			input.close();
		}
		Map map = new Map(row);

		map.calc(true);
		map.bestMove();
		
	}

}
