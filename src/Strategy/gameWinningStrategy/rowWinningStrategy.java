package Strategy.gameWinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class rowWinningStrategy implements GameWinningStrategy {
    HashMap<Integer, Map<Symbol,Integer>> rowWinningMap = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
     int row = move.getCell().getRow(); //fetch the row number of the move
     Symbol symbol = move.getPlayer().getSymbol(); // fetch the Symbol of the player who played the move

       if(!rowWinningMap.containsKey(row)){
           rowWinningMap.put(row, new HashMap<>());
       }

       HashMap<Symbol,Integer> currentRowMap = (HashMap<Symbol, Integer>) rowWinningMap.get(row);
       currentRowMap.put(symbol, currentRowMap.getOrDefault(symbol,0) + 1);

       return  currentRowMap.get(symbol) == board.getSize();
    }
}
