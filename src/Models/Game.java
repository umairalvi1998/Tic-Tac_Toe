package Models;

import Exceptions.InvalidBotCountException;
import Exceptions.InvalidPlayerCountException;
import Exceptions.InvalidSymbolsException;
import Strategy.gameWinningStrategy.GameWinningStrategy;
import Strategy.gameWinningStrategy.columnWinningStrategy;
import Strategy.gameWinningStrategy.diagonalWinningStrategy;
import Strategy.gameWinningStrategy.rowWinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerMoveIndex;
    private gameState gamestate;
    private List<GameWinningStrategy> winningStrategies;

    private Game(int dimension,List<Player> players,List<GameWinningStrategy> winningStrategies) {
        this.board = new Board(dimension); //Initialize the Board
        this.players = players;
        this.moves = new ArrayList<>();
        this.nextPlayerMoveIndex = 0;
        this.gamestate = gameState.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
    }

    public static gameBuilder getBuilder() {
        return new gameBuilder();
    }

    public gameState getGamestate() {
        return gamestate;
    }

    public void setGamestate(gameState gamestate) {
        this.gamestate = gamestate;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
    public List<Move> getMoves() {
        return moves;
    }
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
    public Player getWinner() {
        return winner;
    }
    public void setWinner(Player winner) {
        this.winner = winner;
    }
    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }
    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public void displayBoard() {
        board.displayBoard();
    }

    private boolean validateMove(Move move,Board board) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getBoard().get(row).get(col); //fetches the particular cell from the board,to which player made the move

        return (row >= 0) && (row < board.getSize()) && (col >= 0) && (col < board.getSize()) && cell.getState().equals(cellState.EMPTY);
    }
    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("It is "+currentPlayer.getName()+"'s turn");

        //Since player is making a move it is better that we make the move in the player class.
        Move move = currentPlayer.makeMove(board);

        validateMove(move,board); //Validate the move made by player

        //Place the move on the  board.
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell cell = board.getBoard().get(row).get(col);

        cell.setPlayer(currentPlayer);
        cell.setState(cellState.FILLED);

        //Add the moves to the List of moves to track the moves
        Move move1 = new Move(currentPlayer, cell);
        moves.add(move1);
        nextPlayerMoveIndex++;
        nextPlayerMoveIndex %= players.size();

        //After every move we should check if the game is in a Winning state or Draw State
        if(checkWinner(board,move1)) {
            gamestate = gameState.END;
            winner = currentPlayer;
        }
        else if(moves.size() == board.getSize()*board.getSize()) {
            gamestate = gameState.DRAW;
        }
    }

    private boolean checkWinner(Board board,Move move) {
       //check all the game winning strategies
        for(GameWinningStrategy winningStrategy : winningStrategies) {
            if(winningStrategy.checkWinner(board,move)) return true;
        }
        return false;
    }


    public static class gameBuilder {
        //To build the Game we only need the dimension and List of players
        private int dimension;
        private List<Player> players;

        public int getDimension() {
            return dimension;
        }

        public gameBuilder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public List<Player> getPlayers() {
            return players;
        }

        public gameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }
        private void validateUniqueSymbols(List<Player> players) {
            HashSet<Character> set = new HashSet<>();
            for(Player player : players) {
                set.add(player.getSymbol().getSymbol());
            }
            if(set.size() != players.size()) {
                throw new InvalidSymbolsException("Players did not choose the Unique Symbols");
            }
        }
        private void validateBotCount() {
            int botCount = 0;
            for(Player player : players) {
                if(player.getPlayerType().equals(playerType.BOT)) botCount++;
                if(botCount > 1) {
                    throw new InvalidBotCountException("Only one Bot is Allowed in a gama");
                }
            }
        }
        private void validateGame(int dimension, List<Player> players) {
            //validate the Player Count
            if(players.size() != dimension-1) throw new InvalidPlayerCountException("Invalid number of players");
            //Validate Each player has Unique Symbols
            validateUniqueSymbols(players);
            validateBotCount();
        }

        public Game build() {
            //Validations
            validateGame(dimension, players);

            return  new Game(dimension,players,List.of(
                    new rowWinningStrategy(),
                    new columnWinningStrategy(),
                    new diagonalWinningStrategy()
            ));

        }


    }
}
