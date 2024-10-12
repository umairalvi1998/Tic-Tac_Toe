package Models;

import Factory.BotPlayingStrategyFactory;
import Strategy.gameWinningStrategy.botPlayingStrategy.BotPlayingStrategy;

public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;
    public  Bot(String name, Long id, Symbol symbol,BotDifficultyLevel difficultyLevel) {
        super(name,id,symbol,playerType.BOT);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(difficultyLevel);
    }
    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }


    @Override
    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);
        return move;
    }
}
