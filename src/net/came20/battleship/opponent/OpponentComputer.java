package net.came20.battleship.opponent;

import net.came20.battleship.board.*;

import java.util.Random;

/**
 * Created by cameronearle on 11/9/16.
 */
public class OpponentComputer extends Opponent {

    Random random = new Random();

    public OpponentComputer(Board board) {
        super(board);
        placeShips();
    }

    @Override
    public void placeShips() {
        while (true) {
            if (board.placeShip(random.nextInt(5), random.nextInt(10), ShipDirection.DOWN, SpaceType.DESTROYER, SpaceOwner.OPPONENT)) {
                break;
            }
        }
        while (true) {
            if (board.placeShip(random.nextInt(5), random.nextInt(10), ShipDirection.DOWN, SpaceType.CRUISER, SpaceOwner.OPPONENT)) {
                break;
            }
        }
        while (true) {
            if (board.placeShip(random.nextInt(5), random.nextInt(10), ShipDirection.DOWN, SpaceType.SUBMARINE, SpaceOwner.OPPONENT)) {
                break;
            }
        }
        while (true) {
            if (board.placeShip(random.nextInt(5), random.nextInt(10), ShipDirection.DOWN, SpaceType.BATTLESHIP, SpaceOwner.OPPONENT)) {
                break;
            }
        }
        while (true) {
            if (board.placeShip(random.nextInt(5), random.nextInt(10), ShipDirection.DOWN, SpaceType.AIRCRAFT_CARRIER, SpaceOwner.OPPONENT)) {
                break;
            }
        }
    }

    @Override
    public Response sendMove(Move move) {
        //SpaceType type = board.fire(move);
        return null;
    }
}
