package net.came20.battleship;

import java.util.Scanner;

/**
 * Created by cameron on 11/5/16.
 */
public class Battleship {

    Scanner scanner = new Scanner(System.in);
    static Board board;

    public static void main(String[] args) {
        //This is currently nothing but a display of board features

        board = new Board(10, 10); //Set up a 10x10 game board

        board.placeShip(0,0, ShipDirection.RIGHT, SpaceType.AIRCRAFT_CARRIER, SpaceOwner.PLAYER); //Place an aircraft carrier (5 long) on the player's board starting in the top left corner, and going towards the right

        board.placeShip(3,6, ShipDirection.DOWN, SpaceType.BATTLESHIP, SpaceOwner.PLAYER); //Shows that we can place other kinds of ships in other directions

        System.out.println(board.fire(0,0,SpaceOwner.PLAYER)); //Fire a missile at the first aircraft carrier coordinate, and print the type to ensure we hit
        System.out.println(board.fire(1,0,SpaceOwner.PLAYER)); //Show that the fire method returns NONE for a miss

        System.out.println(board.findNumRemaining(SpaceType.AIRCRAFT_CARRIER, SpaceOwner.PLAYER)); //Print the number of aircraft carrier spots remaining after our shot

        BoardSpace[][] boardArray = board.getBoardArray(SpaceOwner.PLAYER); //Grab the array of the gameboard in its current state, so we can print it out

        for (int row = 0; row < boardArray.length; row++) { //Run through the board and print a grid with different letters for each space type
            for (int col = 0; col < boardArray[row].length; col++) {
                switch (boardArray[row][col].getType()) {
                    case DESTROYER:
                        System.out.print("D ");
                        break;
                    case CRUISER:
                        System.out.print("C ");
                        break;
                    case SUBMARINE:
                        System.out.print("S ");
                        break;
                    case BATTLESHIP:
                        System.out.print("B ");
                        break;
                    case AIRCRAFT_CARRIER:
                        System.out.print("A ");
                        break;
                    case SUNK:
                        System.out.print("X ");
                        break;
                    case NONE:
                        System.out.print("O ");
                        break;
                }
            }
            System.out.println();
        }

        /*
        AIRCRAFT_CARRIER
        NONE
        4
        X A A A A O O O O O
        O O O O O O O O O O
        O O O O O O O O O O
        O O O O O O B O O O
        O O O O O O B O O O
        O O O O O O B O O O
        O O O O O O B O O O
        O O O O O O O O O O
        O O O O O O O O O O
        O O O O O O O O O O
        */

        //This should be the output of this demo
        //In this case, X is sunk, A is aircraft carrier, and B battleship
        //O is an empty space

    }
}
