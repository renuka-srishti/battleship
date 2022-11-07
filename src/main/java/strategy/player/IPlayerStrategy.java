package strategy.player;

import model.Board;
import model.Square;

/**
 * Interface for various game playing strategies.
 */
public interface IPlayerStrategy {
    void initialize(Board board);

    Square getHitSquare(Board board);
}
