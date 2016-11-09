package net.came20.battleship.board;

/**
 * Created by cameron on 11/5/16.
 */
public class BoardSpace {

    private SpaceOwner owner;
    private SpaceType type;

    public BoardSpace(SpaceOwner owner, SpaceType type) {
        this.owner = owner;
        this.type = type;
    }

    public SpaceOwner getOwner() {
        return owner;
    }

    public SpaceType getType() {
        return type;
    }

    public void setOwner(SpaceOwner owner) {
        this.owner = owner;
    }

    public void setType(SpaceType type) {
        this.type = type;
    }
}
