Our Members:
187241102 / Farhan Zuzo Putra Jaya
187241107 / Faisal Akbar
187241109 / Alfarrel Yuri Ramadhani

# Tic Tac Toe Game in Java

A simple implementation of the classic Tic Tac Toe game in Java with two game modes: Player vs Player and Player vs Computer (with easy and hard difficulty levels).

## Project Structure

The project consists of three Java files:

1. `Board.java` - Handles the game board logic and state
2. `TicTacToe.java` - Main class that runs the game and handles user interaction
3. `StrategyCompWin.java` - Implements the computer's AI strategy for hard difficulty

## File Descriptions

### 1. Board.java

This class represents the game board and contains all the core game logic:

- Manages the 3x3 game board state (using 0 for empty, 1 for 'O', -1 for 'X')
- Tracks whose turn it is (1 for 'O', -1 for 'X')
- Provides methods for:
  - Displaying the board (`disp()`)
  - Making moves (`setBoard()`)
  - Checking for a winner (`winner()`)
  - Determining if the game is over (`gameOver()`)
  - Checking if the board is full (`isFull()`)
  - Resetting the board (`resetBoard()`)
  - Accessing current game state (`getTurn()`, `getData()`)

### 2. TicTacToe.java

The main class that runs the Tic Tac Toe game:

- Provides a console-based interface for players
- Offers two game modes:
  1. Player vs Player
  2. Player vs Computer (with easy and hard difficulty options)
- Handles:
  - Game initialization
  - Player input validation
  - Turn management
  - Game result display
  - Play-again functionality

The hard difficulty mode uses the `StrategyCompWin` class to make intelligent moves.

### 3. StrategyCompWin.java

Implements the computer's AI strategy for the hard difficulty level:

- Uses a prioritized approach to determine the best move:
  1. First checks if computer can win immediately
  2. Then checks if it needs to block the player from winning
  3. Takes the center if available
  4. Takes a corner if available
  5. Finally takes any available space
- Contains helper methods to:
  - Find winning moves (`findWinningMove()`)
  - Check if a player has won (`checkWinForPlayer()`)

## How to Run

1. Make sure you have Java installed on your system
2. Compile all three Java files:
   ```
   javac Board.java TicTacToe.java StrategyCompWin.java
   ```
3. Run the main class:
   ```
   java TicTacToe
   ```

## Game Features

- Clean console-based interface
- Two game modes (PvP and PvC)
- Two difficulty levels for computer opponent
- Input validation
- Clear display of game results
- Option to play again

## Future Improvements

Some potential enhancements could include:

1. Adding a GUI interface
2. Implementing more advanced AI algorithms
3. Adding score tracking across multiple games
4. Supporting network multiplayer
5. Adding animations or sound effects

Feel free to contribute to this project by forking the repository and submitting pull requests!
