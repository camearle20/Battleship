package net.came20.battleship.board;



/**
 * Created by cameronearle on 11/12/16.
 */
public class Response {
    private SpaceType type;
    private Move move;

    public Response(SpaceType type, Move move) {
        this.type = type;
        this.move = move;
    }

    public SpaceType getType() {
        return type;
    }

    public Move getMove() {
        return move;
    }
}
