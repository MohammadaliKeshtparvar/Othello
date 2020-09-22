import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * The LocationToMove class represents four collection of pieces in othello game.
 * It holds pieces that have same type in a same collection.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */

public class LocationToMove {

    ArrayList<Piece> collectionOfPiece;
    HashSet<Piece> piece3;
    ArrayList<Piece> piece1;
    ArrayList<Piece> piece2;

    /**
     * Create a new LocationToMove with create four collection.
     */
    public LocationToMove() {
        collectionOfPiece = new ArrayList<>();
        piece1 = new ArrayList<>();
        piece2 = new ArrayList<>();
        piece3 = new HashSet<>();
    }

    /**
     * This method is for separating pieces that have same type.
     * This method we use when turn is one.
     */
    public void setPiece1() {
        piece1.clear();
        piece2.clear();
        for (Piece p : collectionOfPiece) {
            if (p.getType() == 1)
                piece1.add(p);
            if (p.getType() == 2)
                piece2.add(p);
        }
    }

    /**
     * This method is for separating pieces that have same type.
     * This method we use when turn is two.
     */
    public void setPiece2() {
        piece1.clear();
        piece2.clear();
        for (Piece p : collectionOfPiece) {
            if (p.getType() == 2)
                piece1.add(p);
            if (p.getType() == 1)
                piece2.add(p);
        }
    }

    /**
     * This method add a location of a piece that can move.
     * @param turn the turn of a player.
     */
    public void movingLocation(int turn) {

        clearLocation();
        clearLocations();

        int x = 0;
        int y = 0;
        if (turn == 1)
            setPiece1();

        if (turn == 2)
            setPiece2();


        for (Piece p1 : piece1) {
            x = p1.getLocation().getLength();
            y = p1.getLocation().getWidth();
            int i1 = 1;
            int j1 = 1;
            for (;i1 <= 8 - x; i1++) {
                boolean flag = false;
                for (Piece p2 : piece2) {
                    if (p2.getLocation().getLength() == x+i1 && p2.getLocation().getWidth() == y) {
                        j1++;
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    break;
            }
            if (x + j1 != 9 && j1 != 1) {
                Location l = new Location(x+j1, y);
                if (findType(l) != 1 && findType(l) != 2) {
                    Piece p = new Piece(l, 3);
                    piece3.add(p);
                }

            }

            int j2 = 1;
            int i2 = 1;
            for (;i2 < x; i2++) {
                boolean flag = false;
                for (Piece p2 : piece2) {
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
                Location l = new Location(x-j2, y);
                if (findType(l) != 1 && findType(l) != 2) {
                    Piece p = new Piece(l, 3);
                    piece3.add(p);
                }
            }

            int j3 = 1;
            int i3 = 1;
            for (;i3 <= 8 - y; i3++) {
                boolean flag = false;
                for (Piece p2 : piece2) {
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
                Location l = new Location(x, y+j3);
                if (findType(l) != 1 && findType(l) != 2){
                    Piece p = new Piece(l, 3);
                    piece3.add(p);
                }
            }

            int j4 = 1;
            int i4 = 1;
            for (;i4 < y; i4++) {
                boolean flag = false;
                for (Piece p2 : piece2) {
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
                Location l = new Location(x, y-j4);
                if (findType(l) != 1 && findType(l) != 2) {
                    Piece p = new Piece(l, 3);
                    piece3.add(p);
                }

            }

            int j5 = 1;
            int i5 = 1;
            while (x - i5 != 0 && y - i5 != 0) {
                boolean flag = false;
                for (Piece p2 : piece2) {
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
                Location l = new Location(x-j5, y-j5);
                if (findType(l) != 1 && findType(l) != 2) {
                    Piece p = new Piece(l, 3);
                    piece3.add(p);
                }

            }

            int j6 = 1;
            int i6 = 1;
            while (x + i6 != 9 && y + i6 != 9) {
                boolean flag = false;
                for (Piece p2 : piece2) {
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
                Location l = new Location(x+j6, y+j6);
                if (findType(l) != 1 && findType(l) != 2) {
                    Piece p = new Piece(l, 3);
                    piece3.add(p);
                }
            }

            int j7 = 1;
            int i7 = 1;
            while (x + i7 != 9 && y - i7 != 0) {
                boolean flag = false;
                for (Piece p2 : piece2) {
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
                Location l = new Location(x+j7, y-j7);
                if (findType(l) != 1 && findType(l) != 2) {
                    Piece p = new Piece(l, 3);
                    piece3.add(p);
                }
            }

            int j8 = 1;
            int i8 = 1;
            while (y + i8 != 9 && x - i8 != 0) {
                boolean flag = false;
                for (Piece p2 : piece2) {
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
                Location l = new Location(x-j8, y+j8);
                if (findType(l) != 1 && findType(l) != 2) {
                    Piece p = new Piece(l, 3);
                    piece3.add(p);
                }
            }
        }
    }

    /**
     * Clear the pieces that their type is 3.
     */
    public void clearLocation() {
        Iterator<Piece> it = collectionOfPiece.iterator();
        while (it.hasNext()) {
            Piece p = it.next();
            if (p.getType() == 3) {
                it.remove();
            }
        }
    }

    /**
     * Clear the collection that save pieces that their type is 3.
     */
    public void clearLocations() {
        piece3.clear();
    }

    /**
     * Get the collection that have all pieces.
     * It holds all of the type of a piece.
     * @param turn the turn of the player.
     * @return the arrayList that save all pieces.
     */
    public ArrayList<Piece> getCollectionOfPiece(int turn) {
        movingLocation(turn);
        ArrayList<Piece> locationToPrint;
        locationToPrint = collectionOfPiece;
        for (Piece p : piece3) {
            locationToPrint.add(p);
        }

        return collectionOfPiece;
    }

    /**
     * Get the pieces that their type is one.
     * @return the arrayList of the pieces that their type is one.
     */
    public ArrayList<Piece> getPiece1() {
        ArrayList<Piece> piecesSameType = new ArrayList<>();
        for (Piece p : collectionOfPiece) {
            if (p.getType() == 1)
                piecesSameType.add(p);
        }
        return piecesSameType;
    }

    /**
     * Get the pieces that their type is two.
     * @return the arrayList of the pieces that their type is two.
     */
    public ArrayList<Piece> getPiece2() {
        ArrayList<Piece> piecesSameType = new ArrayList<>();
        for (Piece p : collectionOfPiece) {
            if (p.getType() == 2)
                piecesSameType.add(p);
        }
        return piecesSameType;
    }

    /**
     * Get the pieces that their type is three.
     * @param turn the turn of a player.
     * @return the arrayList of the pieces that their type is three.
     */
    public HashSet<Piece> getPiece3(int turn) {
        movingLocation(turn);
        return piece3;
    }

    /**
     * Get the point of player one.
     * @return the size arrayList that save the pieces that their type is one.
     */
    public int point1() {
        return piece1.size();
    }

    /**
     * Get the point of player two.
     * @return the size arrayList that save the pieces that their type is two.
     */
    public int point2() {
        return piece2.size();
    }

    /**
     * Add new piece to the collection of pieces.
     * @param piece the piece that we want to add.
     */
    public void addPiece(Piece piece) {
        collectionOfPiece.add(piece);
    }

    /**
     * Get the number of pieces that their type is three.
     * @param turn the turn of the player.
     * @return the number of moving.
     */
    public int numberOfMoving(int turn) {
        movingLocation(turn);
        return piece3.size();
    }

    /**
     * Found the type of a location's piece.
     * @param location the location that we want its type.
     * @return the type of the location's piece.
     */
    public int findType(Location location) {
        for (Piece p : collectionOfPiece) {
            if (p.getLocation().equals(location))
                return p.getType();
        }
        return 3;
    }

    /**
     * Remove a piece in the collection.
     * @param piece the piece that we want to remove it.
     */
    public void removePiece(Piece piece) {
        collectionOfPiece.remove(piece);
    }

    public int getIndex(Piece piece) {
        int i = 0;
        movingLocation(1);
        for (Piece p : collectionOfPiece) {
            if (p.equals(piece))
                break;
            i++;
        }
        return i;
    }

    public void print() {
        for (Piece p : collectionOfPiece) {
            System.out.println("type:"+p.getType()+" | unicode:"+p.getUnicode()+" | location:("+p.getLocation().getLength()+","+p.getLocation().getWidth()+")");
        }
    }
}
