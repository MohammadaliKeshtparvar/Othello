/**
 * We can start to playing othello game with create three objects in this class .
 * This class creates and holds three objects.
 *
 * @author MohammadaliKeshtparvar
 * @version 0.0
 */

public class Main {
    public static void main(String[]args){


       LocationToMove l = new LocationToMove();
       Field f = new Field(l);
       Rules r = new Rules(f);
       r.othelloGame();

    }
}