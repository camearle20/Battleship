package net.came20.battleship.opponent;

import net.came20.battleship.board.Board;
import net.came20.battleship.board.Move;
import net.came20.battleship.board.Response;

import java.awt.*;

/**
 * Created by cameronearle on 11/9/16.
 */
public abstract class Opponent {
    Board board;
    public Opponent(Board board) {
        this.board = board;
    }

    public abstract void placeShips();
    public abstract Response sendMove(Move move);
}
