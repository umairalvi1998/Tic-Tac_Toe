package Models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private ArrayList<ArrayList<Cell>> board;

    public Board(int dimension) { //Initially an empty board will be created hence we require only the dimension
        this.size = dimension;

        //Initializing an Empty Board
        board = new ArrayList<>(3);

            for(int i = 0; i < dimension; i++) {
                board.add(new ArrayList<>());
                for(int j = 0; j < dimension; j++)
                    board.get(i).add(new Cell(i, j));
            }
        }


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public ArrayList<ArrayList<Cell>> getBoard() {
        return board;
    }
    public void setBoard(ArrayList<ArrayList<Cell>> board) {
        this.board = board;
    }

    public void displayBoard() {
        int counter = 0;
        for(List<Cell> row : board) {
            counter++;
            for(Cell cell : row) {
                if(cell.getState().equals(cellState.EMPTY)) {
                    System.out.print("   |");
                }
                else {
                    System.out.print(" "+cell.getPlayer().getSymbol().getSymbol()+" |");
                }
            }
            System.out.println();
            if(counter!=board.size())  System.out.println("---------------");
        }
    }
}
