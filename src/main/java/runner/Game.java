package runner;

import model.Player;

import java.util.List;

public class Game {
    private final List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
        initPlayers();
    }

    public void initPlayers() {
        // Initializing game players.
        for (Player p : players) {
            p.initialize();
        }
    }

    /**
     * One game loop is completed when both player takes their turn.
     */
    public void start() {
        while (true) {
            System.out.println("****** Player 1 turn ******");
            players.get(0).board.printBoard();
            players.get(0).takeHit(players.get(1));
            if (isGameOver(players.get(1))) {
                System.out.println("Player 1 wins");
                break;
            }

            System.out.println("****** Player 2 turn ******");
            players.get(1).board.printBoard();
            players.get(1).takeHit(players.get(0));
            if (isGameOver(players.get(0))) {
                System.out.println("Player 2 wins");
                break;
            }
        }
    }

    /**
     * Checks if all ships of the player are destroyed.
     */
    private boolean isGameOver(Player player) {
        return player.areAllShipsHit();
    }
}
