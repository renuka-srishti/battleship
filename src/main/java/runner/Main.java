package runner;

import model.Player;
import strategy.placement.RandomPlacement;
import strategy.player.CPUStrategy;
import strategy.player.ManualStrategy;

import java.util.ArrayList;
import java.util.List;

import static runner.UserInput.requestNumericInput;

public class Main {
    public static void main(String[] args) {
        // Generating the Game Menu.
        System.out.println("Welcome to Battleship!");
        System.out.println("Menu:");
        System.out.println("1.\t Start Game.");
        System.out.println("2.\t Exit.");
        System.out.print("Select: ");
        int input = requestNumericInput(2);
        do {
            switch (input) {
                case 1 -> {
                    // Creating Player 1
                    int playerType;
                    List<Player> players = new ArrayList<>();

                    System.out.print("Select Player 1 type [Human-1/CPU-2]: ");
                    playerType = requestNumericInput(2);
                    if (playerType == 1) {
                        players.add(new Player(1, new ManualStrategy(), new RandomPlacement()));
                    } else {
                        players.add(new Player(1, new CPUStrategy(), new RandomPlacement()));
                    }
                    // Creating Player 2
                    System.out.print("Select Player 2 type [Human-1/CPU-2]: ");
                    playerType = requestNumericInput(2);
                    if (playerType == 1) {
                        players.add(new Player(2, new ManualStrategy(), new RandomPlacement()));
                    } else {
                        players.add(new Player(2, new CPUStrategy(), new RandomPlacement()));
                    }

                    Game game = new Game(players);
                    System.out.println("-------------- Battle --------------");
                    // Starting Game Loop.
                    game.start();
                    System.out.println();
                    System.out.print("Want to play again [Y-1/N-2]: ");
                    input = requestNumericInput(2);
                }
                case 2 -> System.out.println("Exiting Game. Bye!");
                default -> input = requestNumericInput(2);
            }
        } while (input != 2);

        System.out.println("Ending Battleship");
    }
}
