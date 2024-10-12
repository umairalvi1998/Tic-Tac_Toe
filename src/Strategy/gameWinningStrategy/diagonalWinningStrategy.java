package Strategy.gameWinningStrategy;

import Models.Board;
import Models.Move;
import Models.Symbol;
import java.util.HashMap;

public class diagonalWinningStrategy implements GameWinningStrategy {
    HashMap<Symbol,Integer> leftDiagonalMap = new HashMap<>();
    HashMap<Symbol,Integer> rightDiagonalMap = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        if(row==col) {
            leftDiagonalMap.put(symbol,leftDiagonalMap.getOrDefault(symbol,0)+1);
            return  leftDiagonalMap.get(symbol) == board.getSize();
        }
        else if(row+col == board.getSize()-1 ) {
           rightDiagonalMap.put(symbol,rightDiagonalMap.getOrDefault(symbol,0)+1);
           return rightDiagonalMap.get(symbol) == board.getSize();
        }
        return false;
    }
}
