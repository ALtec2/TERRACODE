import java.util.ArrayList;
public class Peice{
	private boolean isWhite;
	private int yPosition;
	private int xPosition;
	private int[] movex = new int[7];
	private int[] movey = new int[7];
	private int points;
	private int value;
	private String name;

	public Peice (boolean isWhite, int xPosition, int yPosition, String name){
		this.isWhite=isWhite;
		this.yPosition=yPosition;
		this.xPosition=xPosition;
		this.name=name;
	}

	private int pawnMove(ArrayList<Peice> map ){
		return 0;
	}



}
