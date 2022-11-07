package strategy.player;

import model.Board;
import model.Square;

import static runner.UserInput.requestHitSquare;

/**
 * Manual input game playing strategy. It will require human user input.
 */
public class ManualStrategy implements IPlayerStrategy {

    @Override
    public void initialize(Board board) {
        // Nothing to do.
    }

    @Override
    public Square getHitSquare(Board board) {
        Square s;
        do {
            s = requestHitSquare();
        } while (hitSquareIsInvalid(s, board));
        return s;
    }

    private boolean hitSquareIsInvalid(Square s, Board board) {
        return s.x < 0 || s.x > board.numOfRows || s.y < 0 || s.y > board.numOfColumns;
    }
}
