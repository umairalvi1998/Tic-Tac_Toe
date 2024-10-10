package Models;

public class Cell {
    private int row;
    private int col; //position of the cell on the board.
    private Player player; // player who played the move on that cell, initially it will be null
    private cellState state;

    Cell(int row,int col) {
        this.row = row;
        this.col = col;
        this.state = cellState.EMPTY;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public cellState getState() {
        return state;
    }
    public void setState(cellState state) {
        this.state = state;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

}
