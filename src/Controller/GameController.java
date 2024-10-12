package Controller;

import Models.Game;
import Models.Player;
import Models.gameState;

import java.util.List;

public class GameController {
    Game game;
    public  Game startGame(int dimension, List<Player> players) {
          game = Game.getBuilder().setDimension(dimension).setPlayers(players).build();
          return game;
    }

    public void makeMove(Game game) {
       game.makeMove();
    }

    public gameState getGameState() {
        return game.getGamestate();
    }

    public Player getWinner(Game game) {
        return  game.getWinner();
    }

    public void undo(Game game) {

    }

    public void displayBoard() {
      game.displayBoard();
    }
}
