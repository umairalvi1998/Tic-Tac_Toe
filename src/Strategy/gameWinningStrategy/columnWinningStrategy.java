package Strategy.gameWinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;

import java.util.HashMap;

public class columnWinningStrategy implements GameWinningStrategy {
    HashMap<Integer,HashMap<Symbol,Integer>> colWinningMap  = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(!colWinningMap.containsKey(col)) colWinningMap.put(col, new HashMap<>());

        HashMap<Symbol,Integer> colMap = colWinningMap.get(col);
        if(colMap.containsKey(symbol))
            colMap.put(symbol, colMap.get(symbol) + 1);
        else
            colMap.put(symbol, 1);

        return colMap.get(symbol) == board.getSize();
    }
}
