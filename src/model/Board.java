package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Board {

    private final Cell[][] board;

    public Board(int row, int col) {
        this.board = new Cell[row][col];
    }

    public boolean addPiece(Piece piece, int row, int col) {
        if (this.inBounds(row, col)) {
            this.board[row][col].addPiece(piece);
            return true;
        }
        return false;
    }

    public boolean removePiece(Piece piece, int row, int col) {
        if (this.inBounds(row, col)) {
            this.board[row][col].removePiece(piece);
            return true;
        }
        return false;
    }

    public boolean cellContainsPiece(Piece piece, int row, int col) {
        if (this.inBounds(row, col)) {
            return this.board[row][col].getPieces().contains(piece);
        }
        return false;
    }

    public void clearCell(int row, int col) {
        this.board[row][col].clearCell();
    }

    public boolean cellEmpty(int row, int col) {
        if (this.inBounds(row, col)) {
            return getCell(row, col).getPieces().size() == 0;
        }
        return false;
    }

    public Collection<Cell> cellNeighbours(int row, int col) {
        List<Cell> neighbours = new ArrayList<>();
        // Row modifier
        for (int i = -1; i <= 1; i++) {
            // Column modifier
            for (int j = -1; j <= 1; j++) {
                Cell cell = getCell(row + i, col + j);
                // Only touching cells
                if (cell != null && i != j && (i == 0 || j == 0)) {
                    neighbours.add(this.board[row + i][j + i]);
                }
            }
        }
        return neighbours;
    }

    private Cell getCell(int row, int col) {
        if (this.inBounds(row, col)) {
            return this.board[row][col];
        }
        return null;
    }

    private boolean inBounds(int row, int col) {
        return row >= 0 && row < this.board.length && col >= 0 && col < this.board[row].length;
    }

}
