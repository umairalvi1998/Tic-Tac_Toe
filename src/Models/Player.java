package Models;

public class Player {
    private String name;
    private Long id;
    private Symbol symbol; //Each player has a symbol which is unique to them.
    private playerType playerType;

    public Player(String name, Long id, Symbol symbol, playerType playerType) {
        this.name = name;
        this.id = id;
        this.symbol = symbol;
        this.playerType = playerType;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
     public Long getId() {
        return id;
     }
     public void setId(Long id) {
        this.id = id;
     }
     public Symbol getSymbol() {
        return symbol;
     }
     public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
     }
     public playerType getPlayerType() {
        return playerType;
     }
     public void setPlayerType(playerType playerType) {
        this.playerType = playerType;
     }

}
