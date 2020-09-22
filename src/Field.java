import java.util.ArrayList;

/**
 * The Field class is a class to print the map of the game.
 * It holds two static value for the row and the column.
 * Also it holds a locationToMove object.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */

public class Field {
    private static final int row = 8;
    private static final int column = 8;
    private static String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static String ANSI_RESET = "\u001B[0m";
    private static String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private LocationToMove locationToMove;

    /**
     * Create a new Field with given a locationToMove object.
     * @param locationToMove the locationToMove of a field.
     */
    public Field(LocationToMove locationToMove) {
       this.locationToMove = locationToMove;
    }

    /**
     * Print the map of the othello game.
     * It shows the locations piece and the location that we can add a new piece.
     * @param turn the turn of the player.
     */
    public void printMap(int turn) {
        //System.out.println("Player turn ; "+turn);
        ArrayList<Piece> collectionOfPiece = locationToMove.getCollectionOfPiece(turn);

        System.out.println("       A         B         C         D         E         F         G         H");
        System.out.print("  ");
        for(int i = 0; i < column; i++) {
            System.out.print(" _________");
        }
        System.out.println();
        for (int i = 0; i < 3 * row ; i++) {
            if (i % 3 == 1) {
                System.out.print((i / 3) + 1+" ");
            }else
                System.out.print("  ");
            for (int j = 0; j < column; j++) {
                if (i % 3 == 0) {
                    boolean flag = true;
                    for (Piece piece : collectionOfPiece) {
                        if (piece.getLocation().getLength() == j+1 && (piece.getLocation().getWidth() == (i / 3) + 1)) {
                            flag = false;
                            int unicode = collectionOfPiece.get(collectionOfPiece.indexOf(piece)).getUnicode();
                            if (unicode == 0) {
                                System.out.print(ANSI_PURPLE_BACKGROUND+"|         "+ANSI_RESET);
                            }else{
                                if (unicode == 9679)
                                    System.out.print(ANSI_CYAN_BACKGROUND+"|         "+ANSI_RESET);
                                if (unicode == 9675)
                                    System.out.print(ANSI_RED_BACKGROUND+"|         "+ANSI_RESET);
                            }
                        }
                    }
                    if (flag){
                        System.out.print(ANSI_GREEN_BACKGROUND + "|         "+ANSI_RESET);

                    }

                }
                if (i % 3 == 1) {
                    boolean flag = true;
                    for (Piece piece : collectionOfPiece) {
                        if (piece.getLocation().getLength() == j+1 && (piece.getLocation().getWidth() == (i / 3) + 1)) {
                            flag = false;
                            int unicode = collectionOfPiece.get(collectionOfPiece.indexOf(piece)).getUnicode();
                            if (unicode == 0) {
                                System.out.print(ANSI_PURPLE_BACKGROUND+"|         "+ANSI_RESET);
                            }else{
                                if (unicode == 9679)
                                    System.out.print(ANSI_CYAN_BACKGROUND+"|         "+ANSI_RESET);
                                if (unicode == 9675)
                                    System.out.print(ANSI_RED_BACKGROUND+"|         "+ANSI_RESET);
                            }
                        }
                    }
                    if (flag){

                        System.out.print(ANSI_GREEN_BACKGROUND + "|         "+ANSI_RESET);
                    }
                }
                if (i % 3 == 2){
                    boolean flag = true;
                    for (Piece piece : collectionOfPiece) {
                        if (piece.getLocation().getLength() == j+1 && (piece.getLocation().getWidth() == (i / 3) + 1)) {
                            flag = false;
                            int unicode = collectionOfPiece.get(collectionOfPiece.indexOf(piece)).getUnicode();
                            if (unicode == 0) {
                                System.out.print(ANSI_PURPLE_BACKGROUND+"|_________"+ANSI_RESET);
                            }else{
                                if (unicode == 9679)
                                    System.out.print(ANSI_CYAN_BACKGROUND+"|_________"+ANSI_RESET);
                                if (unicode == 9675)
                                    System.out.print(ANSI_RED_BACKGROUND+"|_________"+ANSI_RESET);
                            }
                        }
                    }
                    if (flag){

                        System.out.print(ANSI_GREEN_BACKGROUND + "|_________"+ANSI_RESET);
                    }
                }

            }
            System.out.println("|");
        }
    }

    public void print() {
        for (Piece p : locationToMove.getCollectionOfPiece(1)) {
            p.printing();
        }
    }

    /**
     * Get the locationToMove of a field.
     * @return the locationToMove of the field.
     */
    public LocationToMove getLocationToMove() {
        return locationToMove;
    }

}
