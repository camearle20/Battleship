package net.came20.battleship;

import java.util.Scanner;

/**
 * Created by cameron on 11/5/16.
 */
public class Battleship {

    Scanner scanner = new Scanner(System.in);
    static Board board;

    public static void main(String[] args) {

        board = new Board(5,5);

        boolean test = board.placeShip(0, 4, ShipDirection.UP, SpaceType.BATTLESHIP, SpaceOwner.PLAYER);

        if (test) {
            System.out.println("Worked");
        } else {
            System.out.println("Didn't work");
        }

        test = board.placeShip(0, 4, ShipDirection.UP, SpaceType.DESTROYER, SpaceOwner.OPPONENT);

        if (test) {
            System.out.println("Worked");
        } else {
            System.out.println("Didn't work");
        }

        System.out.println(board.getSpaceType(0,4,SpaceOwner.OPPONENT));

        BoardSpace[][] boardArray = board.getBoardArray(SpaceOwner.PLAYER);

    }
}
