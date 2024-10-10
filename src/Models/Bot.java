package Models;

public class Bot extends Player {
    private BotDifficultyLevel difficultyLevel;

    public  Bot(String name, Long id, Symbol symbol,BotDifficultyLevel difficultyLevel) {
        super(name,id,symbol,playerType.BOT);
        this.difficultyLevel = difficultyLevel;

    }
    public BotDifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(BotDifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
}
