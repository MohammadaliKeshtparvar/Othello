import java.util.Objects;

/**
 * The Location class represents a place in a table.
 * It holds length and width of place.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */
public class Location {
    private int length;
    private int width;

    /**
     * Create a new Location with given a String.
     * @param input the length and the width of location.
     */
    public Location(String input) {
        String s1 = input.substring(0, 1);
        String s2 = input.substring(2, 3);
        setWidth(s2);
        width = Integer.parseInt(s1);
    }

    /**
     * Create a new location with given two integer.
     * @param length the length of location.
     * @param width the width of location.
     */
    public Location(int length, int width) {
        this.width = width;
        this.length = length;
    }

    /**
     * This method give a string and recognize the width of a location.
     * @param width the width of a location.
     */
    public void setWidth(String width) {

        if (width.compareToIgnoreCase("A") == 0) {
            this.length = 1;
        }else if (width.compareToIgnoreCase("B") == 0) {
            this.length = 2;
        }else if (width.compareToIgnoreCase("C") == 0) {
            this.length = 3;
        }else if (width.compareToIgnoreCase("D") == 0) {
            this.length = 4;
        }else if (width.compareToIgnoreCase("E") == 0) {
            this.length = 5;
        }else if (width.compareToIgnoreCase("F") == 0) {
            this.length = 6;
        }else if (width.compareToIgnoreCase("G") == 0) {
            this.length = 7;
        }else if (width.compareToIgnoreCase("H") == 0) {
            this.length = 8;
        }else
            System.out.println("Invalid input");
    }

    /**
     * Get length of location.
     * @return length of location.
     */
    public int getLength() {
        return length;
    }

    /**
     * Get the with of location.
     * @return the width of location.
     */
    public int getWidth() {
        return width;
    }

    /**
     * In this method we found two location are equal or no.
     * @param o the input that want to compare.
     * @return a boolean value.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getLength() == location.getLength() &&
                getWidth() == location.getWidth();
    }

    /**
     * Get the hash code of the location.
     * @return the hash code of a object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getLength(), getWidth());
    }
}
