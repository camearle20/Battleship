package net.came20.battleship;

/**
 * Created by cameron on 11/5/16.
 */
public class Battleship {
    static BoardSpace[][] board = new BoardSpace[5][5];

    public static void main(String[] args) {
        for (int row = 0; row < board.length; row++) { //Set up the board with NONE types for all spaces
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new BoardSpace(SpaceOwner.NONE, SpaceType.NONE);
            }
        }

        

    }
}
