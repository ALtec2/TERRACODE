import java.util.ArrayList;
public class Map{
	private ArrayList<Peice> map = new ArrayList<>();
	private Boolean isWhite; 
	private String tempSubstring; 
	private int y = 1;
	private int yPosition;
	private int xPosition;
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
				}
			}
			y++;
		}
	}

}
