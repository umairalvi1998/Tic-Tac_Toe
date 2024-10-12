package Factory;

import Models.BotDifficultyLevel;
import Strategy.gameWinningStrategy.botPlayingStrategy.BotPlayingStrategy;
import Strategy.gameWinningStrategy.botPlayingStrategy.EasyBotPlayingStrategy;
import Strategy.gameWinningStrategy.botPlayingStrategy.HardBotPlayingStrategy;
import Strategy.gameWinningStrategy.botPlayingStrategy.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {
    public static BotPlayingStrategy getBotPlayingStrategy(BotDifficultyLevel level) {
        switch (level) {
            case EASY: return new EasyBotPlayingStrategy();
            case MEDIUM: return new MediumBotPlayingStrategy();
            case HARD: return new HardBotPlayingStrategy();
        }
        return null;
    }
}
