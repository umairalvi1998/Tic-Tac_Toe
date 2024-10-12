package Strategy.gameWinningStrategy.botPlayingStrategy;

import Models.Board;
import Models.Move;

public interface BotPlayingStrategy {
    public Move makeMove(Board board);
}
