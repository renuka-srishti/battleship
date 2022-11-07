package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Game board for a player.
 */
public class Board {
    public int numOfRows;
    public int numOfColumns;
    public Square[][] grid;
    public List<Ship> ships;
    // count of ship locations that are not hit.
    public int remainingShipLocations;
    // map ship location to ship.
    public Map<Square, Ship> allShipLocations;

    public Board(int numOfRows, int numOfColumns) {
        this.numOfRows = numOfRows;
        this.numOfColumns = numOfColumns;
        this.remainingShipLocations = 0;
        this.ships = new ArrayList<>();
        this.allShipLocations = new HashMap<>();
    }

    // Initialing board's grid.
    public void initBoard() {
        grid = new Square[numOfRows][numOfColumns];

        for (int x = 0; x < numOfRows; x++) {
            for (int y = 0; y < numOfColumns; y++) {
                grid[x][y] = new Square(x, y, SquareStatus.EMPTY);
            }
        }
    }

    /**
     * Adding Ships on board. Each Player gets 1 ship of each size.
     * Total number of ship locations is sum of all ship length, i.e, 14.
     */
    public void initShips() {
        ships.add(new Ship(ShipType.SMALL));
        ships.add(new Ship(ShipType.MEDIUM));
        ships.add(new Ship(ShipType.LARGE));
        ships.add(new Ship(ShipType.GIANT));

        remainingShipLocations = 14;
    }

    /**
     * Perform a successful hit on board.
     *
     * @param x row number
     * @param y col number
     */
    public void takeHit(int x, int y) {
        grid[x][y].status = SquareStatus.HIT;
        remainingShipLocations--;
    }

    /**
     * Perform a miss on board.
     *
     * @param x row number
     * @param y col number
     */
    public void takeMiss(int x, int y) {
        grid[x][y].status = SquareStatus.HIT;
    }

    /**
     * Print current player's board.
     */
    public void printBoard() {
        System.out.println("Board: ");
        for (int i = 1; i < numOfColumns + 1; i++) {
            System.out.print("\t|" + i + "|\t");
        }
        System.out.println();
        for (int i = 1; i < numOfColumns + 1; i++) {
            System.out.print("\t---\t");
        }
        System.out.println();
        for (char i = 'A'; i < numOfRows + 'A'; i++) {
            System.out.print(i + "|\t");
            for (Square c : grid[i - 'A']) {
                if (allShipLocations.containsKey(c)) {
                    Ship s = allShipLocations.get(c);
                    if (c.status != SquareStatus.HIT) {
                        System.out.printf("\t%s\t", s.size.getLabel());
                    } else {
                        System.out.print("\tX\t");
                    }
                } else {
                    if (c.status != SquareStatus.HIT) {
                        System.out.print("\t.\t");
                    } else {
                        System.out.print("\tX\t");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

//    public void printBoard() {
//        System.out.println("Board: ");
//        for (Square[] r : grid) {
//            for (Square c : r) {
//                if (allShipLocations.containsKey(c)) {
//                    Ship s = allShipLocations.get(c);
//                    if (c.status != SquareStatus.HIT) {
//                        System.out.printf("|(-%s-)| ", s.size.getLabel());
//                    } else {
//                        System.out.print("|(-X-)| ");
//                    }
//                } else {
//                    if (c.status != SquareStatus.HIT) {
//                        System.out.print("|(" + c.x + "," + c.y + ")| ");
//                    } else {
//                        System.out.print("|(-X-)| ");
//                    }
//                }
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
}
