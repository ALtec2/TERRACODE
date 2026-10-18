import java.util.ArrayList;

public class Peice {
    private boolean isWhite;
    private int yPosition;
    private int xPosition;
    private int points;
    private int value;
    private String name;
    private ArrayList<Peice> important;
    private ArrayList<Peice> important2;
    private int bestMoveX;
    private int bestMoveY;

    public Peice(boolean isWhite, int xPosition, int yPosition, String name) {
        this.isWhite = isWhite;
        this.yPosition = yPosition;
        this.xPosition = xPosition;
        this.name = name;
        this.important = new ArrayList<>();
        this.important2 = new ArrayList<>();
        
        if (name.equalsIgnoreCase("Rook")) {
            points = 5;
        } else if (name.equalsIgnoreCase("Knight") || name.equalsIgnoreCase("Bishop")) {
            points = 3;
        } else if (name.equalsIgnoreCase("King")) {
            points = 999;
        } else if (name.equalsIgnoreCase("Queen")) {
            points = 9;
        } else if (name.equalsIgnoreCase("Pawn")) {
            points = 1;
        }
    }

    public void pawnMove(ArrayList<Peice> map) {
    important.clear();
    if (isWhite) {
        for (int x = 0; x < map.size(); x++) {
            if (xPosition == map.get(x).getXPosition() + 1) {
                important.add(map.get(x));
            }
        }
        // REMOVED map.clear() here!
        for (int x = 0; x < important.size(); x++) {
            if (Math.abs(yPosition - important.get(x).getYPosition()) < 2) {
                if (yPosition - important.get(x).getYPosition() != 0) {
                    int maxValue = 0;
                    for (int y = 0; y < important.size(); y++) {
                        if (maxValue < important.get(y).getPoints() - points) {
                            maxValue = important.get(y).getPoints();
                            bestMoveX = important.get(y).getXPosition();
                            bestMoveY = important.get(y).getYPosition();
                        }
                    }
                    value = maxValue;
                }
            }
        }
    } else {
        for (int x = 0; x < map.size(); x++) {
            if (xPosition == map.get(x).getXPosition() - 1) {
                important.add(map.get(x));
            }
        }
        // REMOVED map.clear() here too!
        for (int x = 0; x < important.size(); x++) {
            if (Math.abs(yPosition - important.get(x).getYPosition()) < 2) {
                if (yPosition - important.get(x).getYPosition() != 0) {
                    if (isWhite != important.get(x).getColor()) {
                        int maxValue = 0;
                        for (int y = 0; y < important.size(); y++) {
                            if (maxValue < important.get(y).getPoints() - points) {
                                maxValue = important.get(y).getPoints();
                                bestMoveX = important.get(y).getXPosition();
                                bestMoveY = important.get(y).getYPosition();
                            }
                        }
                        value = maxValue;
                    }
                }
            }
        }
    }
}

    public void rookMove(ArrayList<Peice> map) {
        important.clear();
        for (int x = 0; x < map.size(); x++) {
            if (xPosition == map.get(x).getXPosition() || yPosition == map.get(x).getYPosition()) {
                important.add(map.get(x));
            }
        }
        
        // Remove friendly pieces
        important.removeIf(p -> p.getColor() == isWhite);

        int maxValue = 0;
        for (int x = 0; x < important.size(); x++) {
            int diff = important.get(x).getPoints() - points;
            if (maxValue < diff) {
                maxValue = diff;
                bestMoveX = important.get(x).getXPosition();
                bestMoveY = important.get(x).getYPosition();
            }
        }
        value = maxValue;
    }

    public void knightMove(ArrayList<Peice> map) {
        important.clear();
        for (int x = 0; x < map.size(); x++) {
            int dx = Math.abs(xPosition - map.get(x).getXPosition());
            int dy = Math.abs(yPosition - map.get(x).getYPosition());
            if ((dx == 2 && dy == 1) || (dx == 1 && dy == 2)) {
                important.add(map.get(x));
            }
        }
        
        important.removeIf(p -> p.getColor() == isWhite);

        int maxValue = 0;
        for (int x = 0; x < important.size(); x++) {
            int diff = important.get(x).getPoints() - points;
            if (maxValue < diff) {
                maxValue = diff;
                bestMoveX = important.get(x).getXPosition();
                bestMoveY = important.get(x).getYPosition();
            }
        }
        value = maxValue;
    }

    public void bishopMove(ArrayList<Peice> map) {
        important.clear();
        for (int x = 0; x < map.size(); x++) {
            Peice p = map.get(x);
            if (Math.abs(xPosition - p.getXPosition()) == Math.abs(yPosition - p.getYPosition())) {
                important.add(p);
            }
        }
        
        important.removeIf(p -> p.getColor() == isWhite);

        int maxValue = 0;
        for (int x = 0; x < important.size(); x++) {
            int diff = important.get(x).getPoints() - points;
            if (maxValue < diff) {
                maxValue = diff;
                bestMoveX = important.get(x).getXPosition();
                bestMoveY = important.get(x).getYPosition();
            }
        }
        value = maxValue;
    }

    public void queenMove(ArrayList<Peice> map) {
        important.clear();
        for (int x = 0; x < map.size(); x++) {
            Peice p = map.get(x);
            boolean isStraight = (xPosition == p.getXPosition() || yPosition == p.getYPosition());
            boolean isDiagonal = (Math.abs(xPosition - p.getXPosition()) == Math.abs(yPosition - p.getYPosition()));
            if (isStraight || isDiagonal) {
                important.add(p);
            }
        }
        
        important.removeIf(p -> p.getColor() == isWhite);

        int maxValue = 0;
        for (int x = 0; x < important.size(); x++) {
            int diff = important.get(x).getPoints() - points;
            if (maxValue < diff) {
                maxValue = diff;
                bestMoveX = important.get(x).getXPosition();
                bestMoveY = important.get(x).getYPosition();
            }
        }
        value = maxValue;
    }

    public void kingMove(ArrayList<Peice> map) {
        important.clear();
        for (int x = 0; x < map.size(); x++) {
            Peice p = map.get(x);
            if (Math.abs(xPosition - p.getXPosition()) <= 1 && Math.abs(yPosition - p.getYPosition()) <= 1) {
                important.add(p);
            }
        }
        
        important.removeIf(p -> p.getColor() == isWhite);

        int maxValue = 0;
        for (int x = 0; x < important.size(); x++) {
            int diff = important.get(x).getPoints() - points;
            if (maxValue < diff) {
                maxValue = diff;
                bestMoveX = important.get(x).getXPosition();
                bestMoveY = important.get(x).getYPosition();
            }
        }
        value = maxValue;
    } 

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getPoints() {
        return points;
    }

    public boolean getColor() {
        return isWhite;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return name + " takes " + bestMoveX + ", " + bestMoveY;
    }
}
