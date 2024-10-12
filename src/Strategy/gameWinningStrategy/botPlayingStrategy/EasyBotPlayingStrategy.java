package Strategy.gameWinningStrategy.botPlayingStrategy;

import Models.Board;
import Models.Cell;
import Models.Move;
import Models.cellState;

import java.util.ArrayList;
import java.util.List;

public class EasyBotPlayingStrategy implements  BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for(ArrayList<Cell> cells : board.getBoard()) {
            for(Cell cell : cells) {
                if(cell.getState().equals(cellState.EMPTY)){
                    return  new Move(null,cell);
                }
            }
        }
        return null;
    }
}
