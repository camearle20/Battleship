package net.came20.battleship.board;


/**
 * Created by cameronearle on 11/11/16.
 */
public class Move {

    private SpaceOwner owner;
    private int row;
    private int col;
    private boolean valid;

    public Move(int row, int col, SpaceOwner owner) {
        this.owner = owner;
        this.row = row;
        this.col = col;
        this.valid = true;
    }

    public Move() {
        this.valid = false;
    }

    public SpaceOwner getOwner() {
        return owner;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean getValid() {
        return valid;
    }
}
