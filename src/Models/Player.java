package Models;

import java.util.Scanner;

public class Player {
    private String name;
    private Long id;
    private Symbol symbol; //Each player has a symbol which is unique to them.
    private playerType playerType;
    private static Scanner scanner = new Scanner(System.in);
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

     public  boolean validateMove(int row,int col,Board board){
            Cell cell =  board.getBoard().get(row).get(col);
         return cell.getState().equals(cellState.EMPTY);


     }
     public Move makeMove(Board board) {
        System.out.println("Please enter the row number where you want to make the move");
        int row = scanner.nextInt();
        System.out.println("Please enter the column number where you want to make the move");
        int column = scanner.nextInt();

        if(validateMove(row,column,board))
        return new Move(this,new Cell(row,column));
        else {
            System.out.println("Invalid move,Cell is already Occupied");
            return this.makeMove(board);
        }

     }

}
