package strategy.player;

import model.Board;
import model.Square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CPU strategy that randomly returns a square from board only once.
 */
public class CPUStrategy implements IPlayerStrategy {
    private List<Square> allSquares;
    private int currIndex = 0;

    @Override
    public void initialize(Board board) {
        allSquares = new ArrayList<>();
        for (int i = 0; i < board.numOfRows; i++) {
            for (int j = 0; j < board.numOfColumns; j++) {
                allSquares.add(new Square(i, j, null));
            }
        }

        Collections.shuffle(allSquares);
    }

    @Override
    public Square getHitSquare(Board board) {
        return allSquares.get(currIndex++);
    }
}
