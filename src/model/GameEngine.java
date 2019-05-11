package model;

import java.util.Random;

public class GameEngine {

    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static final int PLAYER_COUNT = 1;
    private static final int WUMPUS_COUNT = 1;
    private static final int PIT_COUNT = 2;
    private static final int GOLD_COUNT = 1;

    private final Board board;

    private int

    public GameEngine() {
        this.board = new Board(ROWS, COLUMNS);
        generateBoard();
    }

    private void generateBoard() {
        // Place Wumpus and stench pieces
        this.placePieceWithNeighbours(Piece.WUMPUS, Piece.STENCH, WUMPUS_COUNT);
        // Place Pit with breeze pieces
        this.placePieceWithNeighbours(Piece.PIT, Piece.BREEZE, PIT_COUNT);
        // Place Gold
        this.placePiece(Piece.GOLD, GOLD_COUNT);
        // Place Player
        this.placePiece(Piece.PLAYER, PLAYER_COUNT);
    }

    private void placePiece(Piece piece, int count) {
        Random rowRand = new Random(ROWS);
        Random colRand = new Random(COLUMNS);
        for (int i = 0; i < count; i++) {
            int row = rowRand.nextInt();
            int col = colRand.nextInt();
            // Try again if piece couldn't be placed
            if (!this.board.addPiece(piece, row, col)) {
                i--;
            }
        }
    }

    private void placePieceWithNeighbours(Piece piece, Piece neighbour, int count) {
        Random rowRand = new Random(ROWS);
        Random colRand = new Random(COLUMNS);
        for (int i = 0; i < count; i++) {
            int row = rowRand.nextInt();
            int col = colRand.nextInt();
            // Add neighbours if successfully placed
            if (this.board.addPiece(piece, row, col)) {
                for (Cell cell : this.board.cellNeighbours(row, col)) {
                    cell.addPiece(neighbour);
                }
            // Try again
            } else {
                i--;
            }
        }
    }

    private void gameLoop() {

    }


}
