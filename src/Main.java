import Controller.GameController;
import Models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting the Tic-Tac-Toe Game!!!!!!!!!!!!!!!!!");
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        List<Player> players = new ArrayList<>();
        players.add(
                new Player("Umair", 1L,new Symbol('X'), playerType.HUMAN)
        );
        players.add(
                new Bot("Bot",2L,new Symbol('O'), BotDifficultyLevel.EASY)
        );

        Collections.shuffle(players);

        Game game = gameController.startGame(3,players);
        while(gameController.getGameState().equals(gameState.IN_PROGRESS)) {
            gameController.displayBoard();

            gameController.makeMove(game);


        }
        if(gameController.getGameState().equals(gameState.END)) {
            gameController.displayBoard();
            System.out.println(gameController.getWinner(game).getName()+" has WON the GAME!");
        }else {
            gameController.displayBoard();
            System.out.println("GAME is DRAW");
        }
    }
}