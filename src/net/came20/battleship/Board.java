package net.came20.battleship;

/**
 * came20's Battleship
 * Copyright (C) 2016 came20 (http://came20.net)
 * License information can be found in the "LICENSE" file,
 * found inside this package.  Should a "LICENSE" file not
 * be present, it is most likely not an official package,
 * released by myself (came20), and should be used with caution
 */
public class Board {
    private BoardSpace[][][] board; // [x][y][layer (0 PLAYER, 1 OPPONENT)]
    private int width;
    private int height;

    public Board(int x, int y) {
        width = x;
        height = y;
        board = new BoardSpace[width][height][2];
        for (int row = 0; row < board.length; row++) { //Set up the board with NONE types for all spaces
            for (int col = 0; col < board[row].length; col++) {
                board[row][col][0] = new BoardSpace(SpaceOwner.PLAYER, SpaceType.NONE);
                board[row][col][1] = new BoardSpace(SpaceOwner.OPPONENT, SpaceType.NONE);
            }
        }
    }

    private boolean checkBounds(int x, int y) {
        if (x < 0 || x > width || y < 0 || y > height) { //Quick method to ensure that any inputs are within set bounds
            return false;
        } else {
            return true;
        }
    }

    public SpaceType getSpaceType(int x, int y, SpaceOwner owner) {
        if (!checkBounds(x, y)) {
            return SpaceType.ERROR;
        }

        if (owner == SpaceOwner.PLAYER) {
            return board[x][y][0].getType();
        } else if (owner == SpaceOwner.OPPONENT) {
            return board[x][y][1].getType();
        } else {
            return SpaceType.ERROR;
        }
    }

    public boolean placeShip(int x, int y, ShipDirection direction, SpaceType type, SpaceOwner owner) {
        if (!checkBounds(x, y)) {
            return false;
        }

        switch (direction) {
            case UP:
                if (!checkBounds(x, y - (type.getLength()-1))) {
                    return false;
                }
                break;

        }
        return true;
    }

}
