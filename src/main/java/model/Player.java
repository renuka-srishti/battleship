package model;

import strategy.placement.IShipPlacementStrategy;
import strategy.player.IPlayerStrategy;

/**
 * Game's player.
 */
public class Player {
    public Board board;
    public int playerId;

    // Player's playing strategy. It can be Human (ManualStrategy) / CPU (CPUStrategy).
    IPlayerStrategy playerStrategy;
    // Player's ship placement strategy. Currently, supports RandomStrategy.
    IShipPlacementStrategy placementStrategy;

    public Player(int playerId, IPlayerStrategy playerStrategy, IShipPlacementStrategy placementStrategy) {
        this.board = new Board(10, 10);
        this.playerId = playerId;
        this.playerStrategy = playerStrategy;
        this.placementStrategy = placementStrategy;
    }

    /**
     * Initializing a player. Steps include:
     * - Initialize player's board.
     * - Initialize player's ship.
     * - Arrange ships on board.
     * - Initialize player's player strategy.
     */
    public void initialize() {
        board.initBoard();
        board.initShips();
        placementStrategy.placeShips(board);
        playerStrategy.initialize(board);
    }

    /**
     * Perform a hit on the given player.
     */
    public void takeHit(Player p) {
        // GetHitSquare based on player's playing strategy.
        Square hitLocation = playerStrategy.getHitSquare(board);
//        System.out.printf("Player %s Hit Square: %s,%s%n", playerId, hitLocation.x, hitLocation.y);

        // Check if it is ship location that has not been hit.
        if (p.board.allShipLocations.containsKey(hitLocation) &&
                p.board.grid[hitLocation.x][hitLocation.y].status == SquareStatus.SHIP) {
            p.board.takeHit(hitLocation.x, hitLocation.y);
            System.out.println("Its a Hit!\n");
            return;
        }

        p.board.takeMiss(hitLocation.x, hitLocation.y);
        System.out.println("Its a Miss!\n");
    }

    public boolean areAllShipsHit() {
        return board.remainingShipLocations == 0;
    }
}
