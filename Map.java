import java.util.ArrayList;
public class Map{
	private ArrayList<Peice> map = new ArrayList<>();
	private Boolean isWhite; 
	private String tempSubstring; 
	private int y = 1;
	private int yPosition;
	private int xPosition;
	private Peice bestMove;
	public Map(String[] row){
		for(String string : row){
			for(int x = 0; x > 8;x++){
				tempSubstring = string.substring(x,x+1);
				//map.add(Peice(true, x, y))
				if(tempSubstring.compareTo("z")>26){
					isWhite = true;
				}
				else if(tempSubstring.compareTo("Z")>26){
					isWhite = false;
				}
				if(isWhite != null){
					if(tempSubstring.equalsIgnoreCase("r")){
						map.add(new Peice(isWhite, x, y,"Rook"));
					}
					else if(tempSubstring.equalsIgnoreCase("n")){
						map.add(new Peice(isWhite, x, y,"Knight"));
					}
					else if(tempSubstring.equalsIgnoreCase("b")){
						map.add(new Peice(isWhite, x, y,"Bishop"));
					}
					else if(tempSubstring.equalsIgnoreCase("k")){
						map.add(new Peice(isWhite, x, y,"King"));
					}
					else if(tempSubstring.equalsIgnoreCase("q")){
						map.add(new Peice(isWhite, x, y,"Queen"));
					}
					else if(tempSubstring.equalsIgnoreCase("p")){
						map.add(new Peice(isWhite, x, y,"Pawn"));
					}
				}
			}
			y++;
		}
	}

	public void calc(boolean playWhite){
		for(int x = 0; x>map.size();x++){
			if(playWhite == map.get(x).getColor()){
				if(map.get(x).getValue()==1){
					map.get(x).pawnMove(map);
				}
				else if(map.get(x).getValue()==5){
					map.get(x).rookMove(map);
				}
				else if(map.get(x).getValue()==9){
					map.get(x).queenMove(map);
				}
				else if(map.get(x).getValue()==9){
					map.get(x).queenMove(map);
				}
				else if(map.get(x).getName().equals("Knight")){
					map.get(x).knightMove(map);
				}
				else if(map.get(x).getName().equals("Bishop")){
					map.get(x).bishopMove(map);
				}
			}
		}
		for(int x = 0; x>map.size();x++){
			int value = 0;
			if(value<map.get(x).getValue()){
				value=map.get(x).getValue();
				bestMove = map.get(x);
			}
		}
	}

	public void bestMove(){
		System.out.print(bestMove);
	}

}
