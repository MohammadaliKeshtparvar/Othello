import java.util.ArrayList;
import java.util.Scanner;

/**
 * The Rule class represents all of the rules of the othello game.
 * It holds a field object.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */

public class Rules {

    private Field field;
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_CYAN = "\u001B[36m";

    /**
     * Create a new Rule object with given a field object.
     * @param field the field of the rule object.
     */
    public Rules(Field field) {
        this.field = field;
    }

    /**
     * In this method we get a input from the user.
     * @param turn the turn of the player.
     */
    public void choice(int turn) {
        //System.out.println("Player 1 : ");
        Scanner input = new Scanner(System.in);
        if (field.getLocationToMove().numberOfMoving(turn) == 0) {
            System.out.println("PASS");
        }else {
            System.out.println(ANSI_GREEN+"\nPlease enter a location : "+ANSI_RESET);
            String str = null;
            while (true) {
                str = input.nextLine();
                if (correctInput(str, turn)) {
                    break;
                }else
                    System.out.println(ANSI_RED+"Please enter correct location : "+ANSI_RESET);
            }
            Piece piece = new Piece(str, turn);
            /*if (turn == 1)
                piece = new Piece(str, 2);
            if (turn == 2)
                piece = new Piece(str, 1);*/

            field.getLocationToMove().addPiece(piece);
            ruleOfGame(piece);

        }

    }

    /**
     * In this method we check the input that user enter is correct or no.
     * @param input the string that user entered.
     * @param turn the turn of the player.
     * @return a boolean value.
     */
    public boolean correctInput(String input, int turn) {
        Location location = new Location(input);
        for (Piece p : field.getLocationToMove().getPiece3(turn)) {
            if (p.getLocation().equals(location))
                return true;
        }
        return false;
    }

    /**
     * In this method we add new piece and change type of pieces that are
     * between the input location and the piece that has same type.
     * @param piece the piece that with user input is made.
     */
    public void ruleOfGame(Piece piece) {
        int x = piece.getLocation().getLength();
        int y = piece.getLocation().getWidth();

        ArrayList<Piece> pieces;
        if (field.getLocationToMove().getPiece1().contains(piece)) {
            pieces = field.getLocationToMove().getPiece2();
        }else
            pieces = field.getLocationToMove().getPiece1();

        int i1 = 1;
        int j1 = 1;
        for (;i1 <= 8 - x; i1++) {
            boolean flag = false;
            for (Piece p : pieces) {
                if (p.getLocation().getLength() == x+i1 && p.getLocation().getWidth() == y) {
                    j1++;
                    flag = true;
                    break;
                }
            }
            if (!flag)
                break;
        }
        if (x + j1 != 9 && j1 != 1) {
            Location l = new Location(x+j1-1, y);
            Location l1 = new Location(x+j1, y);
            if (field.getLocationToMove().findType(l) != 3 && field.getLocationToMove().findType(l) != piece.getType() && field.getLocationToMove().findType(l1) == piece.getType()) {
                for(int i = 1; i < j1; i++) {
                    Piece pieceToAdd = new Piece(x+i, y, piece.getType());
                    int n = 0;
                    if (piece.getType() == 2) {
                        n = 1;
                    }else
                        n = 2;
                    field.getLocationToMove().removePiece(new Piece(x+i, y, n));
                    field.getLocationToMove().addPiece(pieceToAdd);
                }
            }
        }

        int j2 = 1;
        int i2 = 1;
        for (;i2 < x; i2++) {
            boolean flag = false;
            for (Piece p2 : pieces) {
                if (p2.getLocation().getLength() == x-i2 && p2.getLocation().getWidth() == y) {
                    j2++;
                    flag = true;
                    break;
                }
            }
            if (!flag)
                break;
        }
        if (x - j2 != 0 && j2 != 1) {
            Location l = new Location(x-j2+1, y);
            Location l1 = new Location(x-j2, y);
            if (field.getLocationToMove().findType(l) != 3 && field.getLocationToMove().findType(l) != piece.getType() && field.getLocationToMove().findType(l1) == piece.getType()) {
                for(int i = 1; i < j2; i++) {
                    Piece pieceToAdd = new Piece(x-i, y, piece.getType());

                    int n = 0;
                    if (piece.getType() == 2) {
                        n = 1;
                    }else
                        n = 2;
                    field.getLocationToMove().removePiece(new Piece(x-i, y, n));
                    field.getLocationToMove().addPiece(pieceToAdd);
                }
            }
        }

        int j3 = 1;
        int i3 = 1;
        for (;i3 <= 8 - y; i3++) {
            boolean flag = false;
            for (Piece p2 : pieces) {
                if (p2.getLocation().getLength() == x && p2.getLocation().getWidth() == y+i3) {
                    j3++;
                    flag = true;
                    break;
                }
            }
            if (!flag)
                break;
        }
        if (y + j3 != 9 && j3 != 1) {
            Location l = new Location(x, y+j3-1);
            Location l1 = new Location(x, y+j3);
            if (field.getLocationToMove().findType(l) != 3 && field.getLocationToMove().findType(l) != piece.getType() && field.getLocationToMove().findType(l1) == piece.getType()) {
                for(int i = 1; i < j3; i++) {
                    Piece pieceToAdd = new Piece(x, y+i, piece.getType());
                    int n = 0;
                    if (piece.getType() == 2) {
                        n = 1;
                    }else
                        n = 2;
                    field.getLocationToMove().removePiece(new Piece(x, y+i, n));
                    field.getLocationToMove().addPiece(pieceToAdd);
                }
            }
        }

        int j4 = 1;
        int i4 = 1;
        for (;i4 < y; i4++) {
            boolean flag = false;
            for (Piece p2 : pieces) {
                if (p2.getLocation().getLength() == x && p2.getLocation().getWidth() == y-i4) {
                    j4++;
                    flag = true;
                    break;
                }
            }
            if (!flag)
                break;
        }
        if (y - j4 != 0 && j4 != 1) {
            Location l = new Location(x, y-j4+1);
            Location l1 = new Location(x, y-j4);
            if (field.getLocationToMove().findType(l) != 0 && field.getLocationToMove().findType(l) != piece.getType() && field.getLocationToMove().findType(l1) == piece.getType()) {
                for(int i = 1; i < j4; i++) {
                    Piece pieceToAdd = new Piece(x, y-i, piece.getType());
                    int n = 0;
                    if (piece.getType() == 2) {
                        n = 1;
                    }else
                        n = 2;
                    field.getLocationToMove().removePiece(new Piece(x, y-i, n));
                    field.getLocationToMove().addPiece(pieceToAdd);
                }
            }
        }

        int j5 = 1;
        int i5 = 1;
        while (x - i5 != 0 && y - i5 != 0) {
            boolean flag = false;
            for (Piece p2 : pieces) {
                if (p2.getLocation().getLength() == x-i5 && p2.getLocation().getWidth() == y-i5) {
                    j5++;
                    flag = true;
                    break;
                }
            }
            i5++;
            if (!flag)
                break;
        }
        if (j5 != 1 && x - j5 != 0 && y - j5 != 0) {
            Location l = new Location(x-j5+1, y-j5+1);
            Location l1 = new Location(x-j5, y-j5);
            if (field.getLocationToMove().findType(l) != 0 && field.getLocationToMove().findType(l) != piece.getType() && field.getLocationToMove().findType(l1) == piece.getType()) {
                for(int i = 1; i < j5; i++) {
                    Piece pieceToAdd = new Piece(x-i, y-i, piece.getType());
                    int n = 0;
                    if (piece.getType() == 2) {
                        n = 1;
                    }else
                        n = 2;
                    field.getLocationToMove().removePiece(new Piece(x-i, y-i, n));
                    field.getLocationToMove().addPiece(pieceToAdd);

                }
            }
        }

        int j6 = 1;
        int i6 = 1;
        while (x + i6 != 9 && y + i6 != 9) {
            boolean flag = false;
            for (Piece p2 : pieces) {
                if (p2.getLocation().getLength() == x+i6 && p2.getLocation().getWidth() == y+i6) {
                    j6++;
                    flag = true;
                    break;
                }
            }
            i6++;
            if (!flag)
                break;
        }
        if (j6 != 1 && x + i6 != 9 && y + i6 != 9) {
            Location l = new Location(x+j6-1, y+j6-1);
            Location l1 = new Location(x+j6, y+j6);
            if (field.getLocationToMove().findType(l) != 0 && field.getLocationToMove().findType(l) != piece.getType() && field.getLocationToMove().findType(l1) == piece.getType()) {
                for(int i = 1; i < j6; i++) {
                    Piece pieceToAdd = new Piece(x+i, y+i, piece.getType());
                    int n = 0;
                    if (piece.getType() == 2) {
                        n = 1;
                    }else
                        n = 2;

                    field.getLocationToMove().removePiece(new Piece(x+i, y+i, n));
                    field.getLocationToMove().addPiece(pieceToAdd);

                }
            }
        }

        int j7 = 1;
        int i7 = 1;
        while (x + i7 != 9 && y - i7 != 0) {
            boolean flag = false;
            for (Piece p2 : pieces) {
                if (p2.getLocation().getLength() == x+i7 && p2.getLocation().getWidth() == y-i7) {
                    j7++;
                    flag = true;
                    break;
                }
            }
            i7++;
            if (!flag)
                break;
        }
        if (j7 != 1 && x + j7 != 9 && y - j7 != 0) {
            Location l = new Location(x+j7-1, y-j7+1);
            Location l1 = new Location(x+j7, y-j7);
            if (field.getLocationToMove().findType(l) != 0 && field.getLocationToMove().findType(l) != piece.getType() && field.getLocationToMove().findType(l1) == piece.getType()) {
                for(int i = 1; i < j7; i++) {
                    Piece pieceToAdd = new Piece(x+i, y-i, piece.getType());
                    int n = 0;
                    if (piece.getType() == 2) {
                        n = 1;
                    }else
                        n = 2;

                    field.getLocationToMove().removePiece(new Piece(x+i, y-i, n));
                    field.getLocationToMove().addPiece(pieceToAdd);
                }
            }
        }

        int j8 = 1;
        int i8 = 1;
        while (y + i8 != 9 && x - i8 != 0) {
            boolean flag = false;
            for (Piece p2 : pieces) {
                if (p2.getLocation().getLength() == x-i8 && p2.getLocation().getWidth() == y+i8) {
                    j8++;
                    flag = true;
                    break;
                }
            }
            i8++;
            if (!flag)
                break;
        }
        if (j8 != 1 && y + j8 != 9 && x - j8 != 0) {
            Location l = new Location(x-j8+1, y+j8-1);
            Location l1 = new Location(x-j8, y+j8);
            if (field.getLocationToMove().findType(l) != 0 && field.getLocationToMove().findType(l) != piece.getType() && field.getLocationToMove().findType(l1) == piece.getType()) {
                for(int i = 1; i < j8; i++) {
                    Piece pieceToAdd = new Piece(x-i, y+i, piece.getType());
                    int n = 0;
                    if (piece.getType() == 2) {
                        n = 1;
                    }else
                        n = 2;

                    field.getLocationToMove().removePiece(new Piece(x-i, y+i, n));
                    field.getLocationToMove().addPiece(pieceToAdd);
                }
            }
        }
    }

    /**
     * the othelloGame method is the main method in this project.
     * It use another method and keep on until the number of pieces
     * that their type is 3 equal by zero for one player and two player.
     */
    public void othelloGame() {
        Piece p1 = new Piece("4 d", 2);
        Piece p2 = new Piece("5 e", 2);
        Piece p3 = new Piece("4 e", 1);
        Piece p4 = new Piece("5 d", 1);

        field.getLocationToMove().addPiece(p1);
        field.getLocationToMove().addPiece(p2);
        field.getLocationToMove().addPiece(p3);
        field.getLocationToMove().addPiece(p4);
        field.printMap(1);
        while (true) {
            System.out.print(ANSI_CYAN+"Point of player one : "+field.getLocationToMove().getPiece1().size());
            System.out.println(ANSI_RESET);
            System.out.print(ANSI_RED+"Point of Player two : "+field.getLocationToMove().getPiece2().size());
            System.out.println(ANSI_RESET);
            choice(1);
            field.printMap(2);
            int num = field.getLocationToMove().numberOfMoving(1);
            System.out.println();
            System.out.print(ANSI_CYAN+"Point of player one : "+field.getLocationToMove().getPiece1().size());
            System.out.println(ANSI_RESET);
            System.out.print(ANSI_RED+"Point of Player two : "+field.getLocationToMove().getPiece2().size());
            System.out.println(ANSI_RESET);
            choice(2);
            if (field.getLocationToMove().numberOfMoving(2) == 0 && num == 0){
                if (field.getLocationToMove().getPiece1().size() > field.getLocationToMove().getPiece2().size()) {
                    System.out.println(ANSI_CYAN+"PLAYER ONE WINS."+ANSI_RESET);
                }else
                    System.out.println(ANSI_RED+"PLAYER TWO WINS."+ANSI_RESET);
                System.out.println(ANSI_YELLOW+"GAME FINISHED"+ANSI_RESET);
                break;
            }

            field.printMap(1);
        }
    }
}
