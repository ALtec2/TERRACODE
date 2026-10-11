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
	private ArrayList<Peice> important;
	private ArrayList<Peice> important2;

	public Peice (boolean isWhite, int xPosition, int yPosition, String name){
		this.isWhite=isWhite;
		this.yPosition=yPosition;
		this.xPosition=xPosition;
		this.name=name;
		if(name.equalsIgnoreCase("Rook")){
			points = 5;
		}
		else if(name.equalsIgnoreCase("Knight")){
			points = 3;
		}
		else if(name.equalsIgnoreCase("Bishop")){
			points = 3;
		}
		else if(name.equalsIgnoreCase("King")){
			points = 999;
		}
		else if(name.equalsIgnoreCase("Queen")){
			points = 8;
		}
		else if(name.equalsIgnoreCase("Pawn")){
			points = 1;
		}
	}

	public void pawnMove(ArrayList<Peice> map ){
		if(isWhite){
			for(int x= 0; x>map.size();x++){
				if (xPosition == map.get(x).getXPosition()+1){
					important.add(map.get(x));
				}
			}
			map.clear();
			for(int x = 0; x> important.size();x++){
				if(Math.abs(yPosition - important.get(x).getYPosition()) > 2 ){
					if(yPosition - important.get(x).getYPosition() == 0){
						;
					}
					else{
						if(isWhite != important.get(x).getColor())
							value = important.get(x).getPoints() - points;
					}
				}
			}
		}
		else{
			for(int x= 0; x>map.size();x++){
				if (xPosition == map.get(x).getXPosition()-1){
					important.add(map.get(x));
				}
			}
			map.clear();
			for(int x = 0; x> important.size();x++){
				if(Math.abs(yPosition - important.get(x).getYPosition()) > 2 ){
					if(yPosition - important.get(x).getYPosition() == 0){
						;
					}
					else{
						if(isWhite != important.get(x).getColor())
							value = important.get(x).getPoints() - points;
					}
				}
			}
		}
	}

	public void rookMove(ArrayList<Peice> map){
		for(int x= 0; x>map.size();x++){
			if (xPosition == map.get(x).getXPosition()){
				important.add(map.get(x));
			}
		}
		for(int x= 0; x>map.size();x++){
			if (yPosition == map.get(x).getYPosition()){
				important.add(map.get(x));
			}
		}
		int minX = 8;
		int maxX = 1;
		int minY = 8;
		int maxY = 1;
		map.clear();
		for(int x= 0; x> important.size();x++){
			if(xPosition == important.get(x).getXPosition()){
				if(minX < important.get(x).getXPosition()){
					minX = important.get(x).getXPosition();
					map.add(important.get(x));
				}
				else if (maxX> xPosition){
					maxX = important.get(x).getXPosition();
					map.add(important.get(x));
				}
			}
		}
		for(int y= 0; y> important.size();y++){
			if(yPosition == important.get(y).getYPosition()){
				if(minY < important.get(y).getYPosition()){
					minY = important.get(y).getYPosition();
					map.add(important.get(y));
				}
				else if (maxY> yPosition){
					maxY = important.get(y).getYPosition();;
					map.add(important.get(y));
				}
			}
		}


		for(int x = 0; x>map.size();x++){
			if(map.get(x).getColor() == isWhite){
				map.remove(x);
			}
		}
		int maxValue = 0;
		for(int x = 0; x>map.size();x++){
			if(maxValue < (map.get(x).getPoints()-points)){
				maxValue = map.get(x).getPoints()-points;
			}
		}
		value = maxValue;
	}

	public void knightMove(ArrayList<Peice> map){
		for(int x = 0; x>map.size();x++){
			if( Math.abs(xPosition - map.get(x).getXPosition()) == 2 && Math.abs(yPosition-map.get(x).getYPosition()) == 1){
				important.add(map.get(x));
			}
			else if(Math.abs(xPosition - map.get(x).getXPosition()) == 1 && Math.abs(yPosition-map.get(x).getYPosition()) == 2){
				important.add(map.get(x));
			}
		}
		for(int x = 0; x>important.size();x++){
			if(important.get(x).getColor() == isWhite){
				important.remove(x);
			}
		}
		int maxValue = 0;
		for(int x = 0; x>important.size();x++){
			if(maxValue<important.get(x).getPoints()-points){
				maxValue=important.get(x).getPoints();
			}
		}
		value=maxValue;
	}

	public void bishopMove(ArrayList<Peice> map){
		for(int x = 0; x > map.size();x++){
			if(xPosition%2 == 1&&yPosition%2==1){//black
				if(xPosition-yPosition==0){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==2){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==4){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==6){
					important.add(map.get(x));  
				}
				if(map.get(x).getXPosition()+map.get(x).getYPosition()/xPosition==1){
					important.add(map.get(x));
				}

			} 
			else{
				if(xPosition-yPosition==1){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==3){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==5){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==7){
					important.add(map.get(x));  
				}
				if(map.get(x).getXPosition()+map.get(x).getYPosition() == yPosition+xPosition){
					important.add(map.get(x));
				}
			}
		}
		for (int x = 0;x >important.size() ;x++ ) {
			if(important.get(x).getColor() == isWhite){
				important.remove(x);
			}
		}
		int maxValue = 0;
		for(int x = 0; x>important.size();x++){
			if(maxValue<important.get(x).getPoints()-points){
				maxValue=important.get(x).getPoints();
			}
		}
		value=maxValue;
	}

 	public void queenMove(ArrayList<Peice> map){
 		for(int x= 0; x>map.size();x++){
			if (xPosition == map.get(x).getXPosition()){
				important.add(map.get(x));
			}
		}
		for(int x= 0; x>map.size();x++){
			if (yPosition == map.get(x).getYPosition()){
				important.add(map.get(x));
			}
		}
		int minX = 8;
		int maxX = 1;
		int minY = 8;
		int maxY = 1;
		for(int x = 0; x>map.size();x++){
			important2.add(map.get(x));
		}
		map.clear();
		for(int x= 0; x> important.size();x++){
			if(xPosition == important.get(x).getXPosition()){
				if(minX < important.get(x).getXPosition()){
					minX = important.get(x).getXPosition();
					map.add(important.get(x));
				}
				else if (maxX> xPosition){
					maxX = important.get(x).getXPosition();
					map.add(important.get(x));
				}
			}
		}
		for(int y= 0; y> important.size();y++){
			if(yPosition == important.get(y).getYPosition()){
				if(minY < important.get(y).getYPosition()){
					minY = important.get(y).getYPosition();
					map.add(important.get(y));
				}
				else if (maxY> yPosition){
					maxY = important.get(y).getYPosition();;
					map.add(important.get(y));
				}
			}
		}
		important.clear();
		for(int x = 0; x>map.size();x++){
			important.add(map.get(x));
		}	
		map.clear();
		for(int x = 0; x>important2.size();x++){
			map.add(important2.get(x));
		}
		

		for(int x = 0; x > map.size();x++){
			if(xPosition%2 == 1&&yPosition%2==1){//black
				if(xPosition-yPosition==0){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==2){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==4){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==6){
					important.add(map.get(x));  
				}
				if(map.get(x).getXPosition()+map.get(x).getYPosition()/xPosition==1){
					important.add(map.get(x));
				}

			} 
			else{
				if(xPosition-yPosition==1){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==3){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==5){
					important.add(map.get(x));  
				}
				else if(xPosition-yPosition==7){
					important.add(map.get(x));  
				}
				if(map.get(x).getXPosition()+map.get(x).getYPosition() == yPosition+xPosition){
					important.add(map.get(x));
				}
			}
		}
		for (int x = 0;x >important.size() ;x++ ) {
			if(important.get(x).getColor() == isWhite){
				important.remove(x);
			}
		}
		int maxValue = 0;
		for(int x = 0; x>important.size();x++){
			if(maxValue<important.get(x).getPoints()-points){
				maxValue=important.get(x).getPoints();
			}
		}
		value=maxValue;
 	}
 	public void kingMove(ArrayList<Peice> map){
 		for(int x = 0; x>map.size();x++){
 			if(Math.abs(xPosition-map.get(x).getXPosition())>2){
 				important.add(map.get(x));
 			}
 			if(Math.abs(yPosition-map.get(x).getYPosition())>2){
 				important.add(map.get(x));
 			}
 		}
 		for (int x = 0;x >important.size() ;x++ ) {
			if(important.get(x).getColor() == isWhite){
				important.remove(x);
			}
		}
		int maxValue = 0;
		for(int x = 0; x>important.size();x++){
			if(maxValue<important.get(x).getPoints()-points){
				maxValue=important.get(x).getPoints();
			}
		}
		value=maxValue;
 	} 

	public int getXPosition(){
		return xPosition;
	}

	public int getYPosition(){
		return yPosition;
	}

	public int getPoints(){
		return points;
	}

	public boolean getColor(){
		return isWhite;
	}

	public int getValue(){
		return value;
	}
}
