# Battleship Game

- This is a command line, text-only game to simulate battleship against an easy computer opponent
- The game is played between 2 players, who each have a 10x10 grid with rows A-J and columns 1-10
- Ships are all 1 square wide and the player gets 1 each of length 2 (Small), 3 (Medium), 4 (Large), and 5 (Giant).
- Upon program start the computer lays out the ships for both players. Ships can only be horizontal or vertical and
  cannot intersect.
- The players alternate turns and pick a coordinate to fire upon during each turn.
- After the user selects a square, the computer informs them of the result. If the square has no ship, it was a miss. If
  the square has a ship that has not been hit, it was a hit. When the user hits all the squares of the ship, they have
  sunk the ship. When they have sunk all the opponents’ ships, they win.

## About the Project

Project uses maven for building and packaging.

### model

- Board: Model to represent player's board.
- Orientation: Enum to represent ship's orientation.
- Player: Model to represent Game's player.
- Ship: Model to represent battleship.
- ShipType: Model to represent ship types / length
- Square: Model to represent single square of board.
- SquareStatus: Model to represent a square's status.

### strategy

#### ShipPlacement Strategy

- RandomPlacement: Implements IShipPlacementStrategy and randomly arranges the ships in random orientation on the board.

#### PlayerStrategy

- ManualStrategy: Implements IPlayerStrategy and represents a Human player.
- CPUStrategy: Implements IPlayerStrategy and represents a CPU player. CPU player randomly picks a square to hit.

### runner

- Game: Logic to run the battleship game.
- Main: Contains main class to start the game.

## Run the Project

### From IDE

Project can be imported in any IDE that supports maven.

#### For Intellij (preferred):

[These](https://www.jetbrains.com/idea/guide/tutorials/working-with-maven/importing-a-project/) instructions can be
followed to import a maven project in intellij. Once imported, run `Main` class under `runner` package.

### From Command Line

Follow below instructions to run this project from command line.

- `mvn package`
- `java -jar .\target\Battleship-1.0-SNAPSHOT.jar`

Note: Above instructions assumes maven is pre-installed.

## Example Run
Use one of the below options on the menu:
#### Between Human Player & CPU
- Enter `1` to Start Game.
- Enter `1` for Human Player 1.
- Enter `2` for CPU Player 2.
#### Between CPU & CPU
- Enter `1` to Start Game.
- Enter `2` for CPU Player 1.
- Enter `2` for CPU Player 2.
#### Between Human Player & Humar Player
- Enter `1` to Start Game.
- Enter `1` for Human Player 1.
- Enter `1` for Human Player 2.
