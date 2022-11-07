package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import strategy.placement.RandomPlacement;
import strategy.player.CPUStrategy;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    Player p1;
    Player p2;

    @BeforeEach
    void setUp() {
        p1 = new Player(1, new CPUStrategy(), new RandomPlacement());
        p1.initialize();

        p2 = new Player(2, new CPUStrategy(), new RandomPlacement());
        p2.initialize();
    }

    @Test
    void initialize() {
        assertNotNull(p1.playerStrategy);
        assertNotNull(p1.placementStrategy);
    }
}