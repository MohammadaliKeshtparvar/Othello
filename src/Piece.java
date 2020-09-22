import java.util.Objects;

/**
 * The Piece class represents a piece in othello game.
 * It holds a location , type and unicode.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */
public class Piece {
    private Location location;
    private int type;
    private int unicode;

    /**
     * Create a new piece with given a string and a number for piece type.
     * @param input for creating a new location of the piece.
     * @param type the type of piece.
     */
    public Piece(String input, int type) {
        this.type = type;
        location = new Location(input);
        setUnicode();
    }

    /**
     * Create a new piece with given a location and a number for its type.
     * @param location the location of the piece.
     * @param type the type of the piece.
     */
    public Piece(Location location, int type) {
        this.location = location;
        this.type = type;
        setUnicode();
    }

    /**
     * Create a new piece with given length and width of the location
     * and a number for its type.
     * @param x the length of the location of the piece.
     * @param y the width of the location of the piece.
     * @param type  the type of the piece.
     */
    public Piece(int x, int y, int type) {
        location = new Location(x, y);
        this.type = type;
        setUnicode();
    }

    /**
     * Get the location of a piece.
     * @return the location of the piece.
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Get the type of a piece.
     * @return the type pf the piece.
     */
    public int getType() {
        return type;
    }

    /**
     * Get the unicode of a piece.
     * @return the unicode of a piece.
     */
    public int getUnicode() {
        return unicode;
    }

    /**
     * Set the unicode of a piece well as its type.
     */
    public void setUnicode() {
        if (type == 1)
            unicode = 9679;
        if (type == 2)
            unicode = 9675;
        if (type == 3)
            unicode = 0;
    }

    /**
     * Set the type of a piece.
     * @param type the type the piece.
     */
    public void setType(int type) {
        this.type = type;
        setUnicode();
    }

    public void printing() {
        System.out.println("X : "+location.getLength()+" | Y : "+location.getWidth()+" | unicode : "+unicode+" | Type : "+type);
    }

    /**
     * In this method we found two Pieces are equal or no.
     * @param o the object that want to compare with a piece.
     * @return a boolean value.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piece)) return false;
        Piece piece = (Piece) o;
        return getType() == piece.getType() &&
                getUnicode() == piece.getUnicode() &&
                getLocation().equals(piece.getLocation());
    }

    /**
     * Get the hash code of a piece.
     * @return hash code of a piece.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getLocation(), getType(), getUnicode());
    }
}