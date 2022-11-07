package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.placement.RandomPlacement;
import strategy.player.ManualStrategy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    Player p;

    @BeforeEach
    public void setUp() {
        p = new Player(2, new ManualStrategy(), new RandomPlacement());
        p.initialize();
    }

    @Test
    public void initShips() {
        assertEquals(p.board.ships.size(), 4);
    }

    @Test
    public void takeHit() {
        p.board.takeHit(0, 0);

        assertEquals(p.board.remainingShipLocations, 13);
        assertEquals(p.board.grid[0][0].status, SquareStatus.HIT);
    }
}