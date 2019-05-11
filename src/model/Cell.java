package model;

import java.util.HashSet;
import java.util.Set;

public class Cell {

    private final Set<Piece> pieces;

    public Cell() {
        this.pieces = new HashSet<>();
    }

    public void addPiece(Piece piece) {
        this.pieces.add(piece);
    }

    public void removePiece(Piece piece) {
        this.pieces.remove(piece);
    }

    public void clearCell() {
        this.pieces.clear();
    }

    public Set<Piece> getPieces() {
        return this.pieces;
    }

}
