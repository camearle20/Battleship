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
    private BoardSpace[][][] board; // [layer (0 PLAYER, 1 OPPONENT)][x][y]
    private int width;
    private int height;

    public Board(int x, int y) {
        width = x;
        height = y;
        board = new BoardSpace[2][width][height];
        for (int row = 0; row < board.length; row++) { //Set up the board with NONE types for all spaces
            for (int col = 0; col < board[row].length; col++) {
                board[0][row][col] = new BoardSpace(SpaceOwner.PLAYER, SpaceType.NONE);
                board[1][row][col] = new BoardSpace(SpaceOwner.OPPONENT, SpaceType.NONE);
            }
        }
    }

    public BoardSpace[][] getBoardArray(SpaceOwner owner) {
        if (owner == SpaceOwner.PLAYER) {
            return board[0];
        } else if (owner == SpaceOwner.OPPONENT) {
            return board[1];
        } else {
            return null;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    private boolean checkBounds(int x, int y) {
        if (x < 0 || x > width - 1 || y < 0 || y > height - 1) { //Quick method to ensure that any inputs are within set bounds
            Log.d("Space (" + x + ", " + y + ") is out of bounds");
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
            return board[0][x][y].getType();
        } else if (owner == SpaceOwner.OPPONENT) {
            return board[1][x][y].getType();
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
                for (int i = y; i > y-type.getLength(); i--) {
                    if (getSpaceType(x, i, owner) != SpaceType.NONE) {
                        Log.d("Space is taken");
                        return false;
                    }
                }

                for (int j = y; j > y-type.getLength(); j--) {
                    if (owner == SpaceOwner.PLAYER) {
                        board[0][x][j].setType(type);
                    } else if (owner == SpaceOwner.OPPONENT) {
                        board[1][x][j].setType(type);
                    } else {
                        return false;
                    }
                }
                break;
            default:
                return false;

        }
        return true;
    }

}
