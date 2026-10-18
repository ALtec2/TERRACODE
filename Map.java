import java.util.ArrayList;

public class Map {
    private ArrayList<Peice> map = new ArrayList<>();
    private Boolean isWhite; 
    private String tempSubstring; 
    private int y = 1;
    private Peice bestMove;

    public Map(String[] row) {
        for (String string : row) {
            // Prevent NullPointerException if an element in the row array is null
            if (string == null) {
                y++;
                continue; 
            }

            for (int x = 0; x < string.length() && x < 8; x++) {
                tempSubstring = string.substring(x, x + 1);
                
                if (tempSubstring.trim().isEmpty()) {
                    continue; // Skip empty spaces if represented by spaces
                }

                // Determine color based on uppercase (white) vs lowercase (black)
                if (!tempSubstring.equals(tempSubstring.toLowerCase())) {
                    isWhite = true;
                } else {
                    isWhite = false;
                }

                if (isWhite != null) {
                    if (tempSubstring.equalsIgnoreCase("r")) {
                        map.add(new Peice(isWhite, x, y, "Rook"));
                    } else if (tempSubstring.equalsIgnoreCase("n")) {
                        map.add(new Peice(isWhite, x, y, "Knight"));
                    } else if (tempSubstring.equalsIgnoreCase("b")) {
                        map.add(new Peice(isWhite, x, y, "Bishop"));
                    } else if (tempSubstring.equalsIgnoreCase("k")) {
                        map.add(new Peice(isWhite, x, y, "King"));
                    } else if (tempSubstring.equalsIgnoreCase("q")) {
                        map.add(new Peice(isWhite, x, y, "Queen"));
                    } else if (tempSubstring.equalsIgnoreCase("p")) {
                        map.add(new Peice(isWhite, x, y, "Pawn"));
                    }
                }
            }
            y++;
        }
    }

    public void calc(boolean playWhite) {
        // Step 1: Calculate potential moves for each piece belonging to the player
        for (int x = 0; x < map.size(); x++) {
            Peice currentPiece = map.get(x);
            if (playWhite == currentPiece.getColor()) {
                String name = currentPiece.getName();
                
                if (name.equalsIgnoreCase("Pawn")) {
                    currentPiece.pawnMove(map);
                } else if (name.equalsIgnoreCase("Rook")) {
                    currentPiece.rookMove(map);
                } else if (name.equalsIgnoreCase("Queen")) {
                    currentPiece.queenMove(map);
                } else if (name.equalsIgnoreCase("King")) {
                    currentPiece.kingMove(map);
                } else if (name.equalsIgnoreCase("Knight")) {
                    currentPiece.knightMove(map);
                } else if (name.equalsIgnoreCase("Bishop")) {
                    currentPiece.bishopMove(map);
                }
            }
        }

        // Step 2: Find the best move overall from the evaluated pieces
        int maxVal = -1;
        for (int x = 0; x < map.size(); x++) {
            Peice currentPiece = map.get(x);
            if (playWhite == currentPiece.getColor()) {
                if (maxVal < currentPiece.getValue()) {
                    maxVal = currentPiece.getValue();
                    bestMove = currentPiece;
                }
            }
        }
    }

    public void bestMove() {
        if (bestMove != null) {
            System.out.print(bestMove);
        } else {
            System.out.print("No valid moves found.");
        }
    }
}
