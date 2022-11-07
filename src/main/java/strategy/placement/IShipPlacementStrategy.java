package strategy.placement;

import model.Board;

import java.util.List;

/**
 * Interface to support various ShipPlacement strategies.
 */
public interface IShipPlacementStrategy {
    void placeShips(Board board);
}
