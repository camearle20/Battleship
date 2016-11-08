package net.came20.battleship;

/**
 * Created by cameron on 11/5/16.
 */
public enum SpaceType {
    DESTROYER(2), //2
    CRUISER(3), //3
    SUBMARINE(3), //3
    BATTLESHIP(4), //4
    AIRCRAFT_CARRIER(5), //5
    NONE(0),
    ERROR(-1);

    private int length;


    SpaceType(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
