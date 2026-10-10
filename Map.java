import java.util.ArrayList;
import java.util.Scanner;
public class Map{
	private ArrayList<Peice> map = new ArrayList<>(); 
	private Scanner input = new Scanner(System.in);
	private String inputMap;
	public Map(){

		inputMap = input.nextLine();

		//import the peices and set up the board
		map.add(new Peice (true, 1, 1, "Rook"));
		map.add(new Peice (true, 2, 1, "Knight"));
		map.add(new Peice (true, 3, 1, "Bishop"));
		map.add(new Peice (true, 4, 1, "King"));
		map.add(new Peice (true, 5, 1, "Queen"));
		map.add(new Peice (true, 6, 1, "Bishop"));
		map.add(new Peice (true, 7, 1, "Knight"));
		map.add(new Peice (true, 8, 1, "Rook"));

		map.add(new Peice (true, 1, 2, "Pawn"));
		map.add(new Peice (true, 2, 2, "Pawn"));
		map.add(new Peice (true, 3, 2, "Pawn"));
		map.add(new Peice (true, 4, 2, "Pawn"));
		map.add(new Peice (true, 5, 2, "Pawn"));
		map.add(new Peice (true, 6, 2, "Pawn"));
		map.add(new Peice (true, 7, 2, "Pawn"));
		map.add(new Peice (true, 8, 2, "Pawn"));

		map.add(new Peice (false, 1, 8, "Rook"));
		map.add(new Peice (false, 2, 8, "Knight"));
		map.add(new Peice (false, 3, 8, "Bishop"));
		map.add(new Peice (false, 4, 8, "King"));
		map.add(new Peice (false, 5, 8, "Queen"));
		map.add(new Peice (false, 6, 8, "Bishop"));
		map.add(new Peice (false, 7, 8, "Knight"));
		map.add(new Peice (false, 8, 8, "Rook"));
		
		map.add(new Peice (false, 1, 7, "Pawn"));
		map.add(new Peice (false, 2, 7, "Pawn"));
		map.add(new Peice (false, 3, 7, "Pawn"));
		map.add(new Peice (false, 4, 7, "Pawn"));
		map.add(new Peice (false, 5, 7, "Pawn"));
		map.add(new Peice (false, 6, 7, "Pawn"));
		map.add(new Peice (false, 7, 7, "Pawn"));
		map.add(new Peice (false, 8, 7, "Pawn"));
	}
}