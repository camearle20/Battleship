package net.came20.battleship.board;


import net.came20.battleship.Log;

import javax.swing.JLabel;

/**
 * came20's Battleship
 * Copyright (C) 2016 came20 (http://came20.net)
 * License information can be found in the "LICENSE" file,
 * found inside this package.  Should a "LICENSE" file not
 * be present, it is most likely not an official package,
 * released by myself (came20), and should be used with caution
 */
public class Board {
    private BoardSpace[][][] board; // [layer (0 PLAYER, 1 OPPONENT)][row][col]
    private int num_rows;
    private int num_cols;

    public Board(int rows, int cols) {
        num_rows = rows;
        num_cols = cols;
        board = new BoardSpace[2][num_rows][num_cols];
        for (int row = 0; row < board[0].length; row++) { //Set up player board
            for (int col = 0; col < board[0][row].length; col++) {
                board[0][row][col] = new BoardSpace(SpaceOwner.PLAYER, SpaceType.NONE, new JLabel());
            }
        }

        for (int row = 0; row < board[1].length; row++) { //Set up opponent board
            for (int col = 0; col < board[1][row].length; col++) {
                board[1][row][col] = new BoardSpace(SpaceOwner.OPPONENT, SpaceType.NONE, new JLabel());
            }
        }
    }


    public BoardSpace[][] getBoardArray(SpaceOwner owner) {
        return board[owner.getLayer()];
    }

    public void setBoardArray(BoardSpace[][] spaces, SpaceOwner owner) {
        board[owner.getLayer()] = spaces;
    }

    public int getNumRows() {
        return num_rows;
    }

    public int getNumCols() {
        return num_cols;
    }
    
    private boolean checkBounds(int row, int col) {
        if (row < 0 || row > num_rows - 1 || col < 0 || col > num_cols - 1) { //Quick method to ensure that any inputs are within set bounds
            Log.d("Space (" + row + ", " + col + ") is out of bounds");
            return false;
        } else {
            return true;
        }
    }

    public SpaceType getSpaceType(int row, int col, SpaceOwner owner) {
        if (!checkBounds(row, col)) {
            return SpaceType.ERROR;
        }
        return board[owner.getLayer()][row][col].getType();
    }

    public int findNumRemaining(SpaceType type, SpaceOwner owner) {
        int i = 0;
        for (BoardSpace[] spaces : board[owner.getLayer()]) {
            for (BoardSpace space : spaces) {
                if (space.getType() == type) {
                    i++;
                }
            }
        }
        return i;
    }

    public SpaceType fire(Move move) {
        if (!checkBounds(move.getRow(), move.getCol())) {
            return SpaceType.ERROR;
        }
        SpaceType type = getSpaceType(move.getRow(), move.getCol(), move.getOwner());
        if (type != SpaceType.NONE) {
            board[move.getOwner().getLayer()][move.getRow()][move.getCol()].setType(SpaceType.SUNK);
        }
        return type;
    }

    public boolean checkPossible(int row, int col, SpaceType type, ShipDirection direction, SpaceOwner owner) {
        switch (direction) {
            case UP:
                if (!checkBounds(row - (type.getLength() - 1), col)) {
                    return false;
                }
                for (int i = row; i > row - type.getLength(); i--) {
                    if (getSpaceType(i, col, owner) != SpaceType.NONE) {
                        Log.d("Space is taken");
                        return false;
                    }
                }
                break;
            case DOWN:
                if (!checkBounds(row + (type.getLength() - 1), col)) {
                    return false;
                }
                for (int i = row; i < row + type.getLength(); i++) {
                    if (getSpaceType(i, col, owner) != SpaceType.NONE) {
                        Log.d("Space is taken");
                        return false;
                    }
                }
                break;
            case LEFT:
                if (!checkBounds(row, col - (type.getLength() - 1))) {
                    return false;
                }
                for (int i = col; i > col - type.getLength(); i--) {
                    if (getSpaceType(row, i, owner) != SpaceType.NONE) {
                        Log.d("Space is taken");
                        return false;
                    }
                }
                break;
            case RIGHT:
                if (!checkBounds(row, col + (type.getLength() - 1))) {
                    return false;
                }
                for (int i = col; i < col + type.getLength(); i++) {
                    if (getSpaceType(row, i, owner) != SpaceType.NONE) {
                        Log.d("Space is taken");
                        return false;
                    }
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public boolean placeShip(int row, int col, ShipDirection direction, SpaceType type, SpaceOwner owner) {
        if (!checkBounds(row, col)) {
            return false;
        }

        if (!checkPossible(row, col, type, direction, owner)) {
            return false;
        }

        switch (direction) {
            case UP:
                for (int j = row; j > row-type.getLength(); j--) {
                    board[owner.getLayer()][j][col].setType(type);
                }
                break;
            case DOWN:
                for (int j = row; j < row+type.getLength(); j++) {
                    board[owner.getLayer()][j][col].setType(type);
                }
                break;
            case LEFT:
                for (int j = col; j > col-type.getLength(); j--) {
                    board[owner.getLayer()][row][j].setType(type);
                }
                break;
            case RIGHT:
                for (int j = col; j < col+type.getLength(); j++) {
                    board[owner.getLayer()][row][j].setType(type);
                }
                break;
            default:
                return false;

        }
        return true;
    }

}
