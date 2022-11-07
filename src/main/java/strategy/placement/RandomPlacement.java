package strategy.placement;

import model.Board;
import model.Orientation;
import model.Ship;
import model.SquareStatus;

import java.util.Random;

/**
 * Randomly places a ship on a board with a randomly generated orientation.
 */
public class RandomPlacement implements IShipPlacementStrategy {

    @Override
    public void placeShips(Board board) {
        for (int i = 0; i < board.ships.size(); ) {
            int x = (int) (Math.random() * (board.numOfRows - 1));
            int y = (int) (Math.random() * (board.numOfColumns - 1));
            Orientation orientation = Orientation.values()[new Random().nextInt(Orientation.values().length)];

            if (canPlaceShips(board, board.ships.get(i), orientation, x, y)) {
                placeShips(board, board.ships.get(i), orientation, x, y);
                i++;
            }
        }
    }

    private boolean canPlaceShips(Board board, Ship ship, Orientation orientation, int x, int y) {
        for (int i = 0; i < ship.size.getLength(); i++) {
            if (Orientation.HORIZONTAL == orientation) {
                if ((x + i) < 0 || (x + i) >= board.numOfRows || y < 0 && y >= board.numOfColumns ||
                        board.grid[x + i][y].status != SquareStatus.EMPTY) {
                    return false;
                }
            } else {
                if (x < 0 && x >= board.numOfRows && (y + i) < 0 || (y + i) >= board.numOfColumns ||
                        board.grid[x][y + i].status != SquareStatus.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private void placeShips(Board board, Ship ship, Orientation orientation, int x, int y) {
        ship.orientation = orientation;
        for (int i = 0; i < ship.size.getLength(); i++) {
            if (ship.orientation == Orientation.HORIZONTAL) {
                board.grid[x + i][y].status = SquareStatus.SHIP;
                ship.locations.add(board.grid[x + i][y]);
                board.allShipLocations.put(board.grid[x + i][y], ship);
            } else {
                board.grid[x][y + i].status = SquareStatus.SHIP;
                ship.locations.add(board.grid[x][y + i]);
                board.allShipLocations.put(board.grid[x][y + i], ship);
            }
        }
    }
}
