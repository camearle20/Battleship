package net.came20.battleship.board;

/**
 * Created by cameron on 11/5/16.
 */
public enum SpaceOwner {
    PLAYER(0),
    OPPONENT(1),
    NONE(-1);

    private int layer;


    SpaceOwner(int layer) {
        this.layer = layer;
    }

    public int getLayer() {
        return layer;
    }
}
