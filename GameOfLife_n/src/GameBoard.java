import Cell.*;

import java.util.Arrays;

public class GameBoard {

    private Cell[][] board = new Cell[200][100];

    public void initialize(int[][] states) {        //fills 2 dimensional Array with DeadCells and a starting Pattern
        for (Cell[] cellArray : board) {
            Arrays.fill(cellArray, CellFactory.getCell(cellStatus.DEAD));
        }

        board[49][49] = CellFactory.getCell(cellStatus.BLUE);
        board[149][49] = CellFactory.getCell(cellStatus.RED);
    }
    public void update() {      //sets the next state of the cells according to game rules but doesn't apply them yet
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 100; j++) {
                board[i][j].nextState(getNext(i,j));
            }
        }
    }

    public void nextGeneration() {      //generates new generation of cells (with updated states)
        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 100; j++) {
                board[i][j] = CellFactory.getCell(board[i][j].getNextState());
            }
        }
    }



    private Neighbors getNext(int i, int j) {       //gets neighboring colors of a cell

        short RedCounter = 0;
        short BlueCounter = 0;

        for (int x = i-1; x <= i+1; x++) {          //iterates through neighboring x-values
            if(x < 0 || x >= 200) continue;         //if a value is out of bounds (edge of map) then skip
            for (int y = j-1; y <= j+1; y++) {      //iterates through neighboring y-values
                if(y < 0 || y >= 100) continue;     //if a value is out of bounds (edge of map) then skip

                if(board[x][y].getClass() == BlueCell.class) BlueCounter += 1;
                if(board[x][y].getClass() == RedCell.class) RedCounter += 1;
            }
        }

        return new Neighbors(RedCounter, BlueCounter);
    }

}
