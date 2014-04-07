package esben.chess.core;

import esben.chess.core.model.*;

import static esben.chess.core.model.Line.*;
import static esben.chess.core.model.Piece.*;
import static esben.chess.core.model.Row.*;
import static esben.chess.core.model.Square.*;

public class StandardInitializer {
    public void initialize(Board board) {

        board.setPieceAt(createSquare(LINE_A, ROW_1), WHITE_ROOK);
        board.setPieceAt(createSquare(LINE_B, ROW_1), WHITE_KNIGHT);
        board.setPieceAt(createSquare(LINE_C, ROW_1), WHITE_BISHOP);
        board.setPieceAt(createSquare(LINE_D, ROW_1), WHITE_QUEEN);
        board.setPieceAt(createSquare(LINE_E, ROW_1), WHITE_KING);
        board.setPieceAt(createSquare(LINE_F, ROW_1), WHITE_BISHOP);
        board.setPieceAt(createSquare(LINE_G, ROW_1), WHITE_KNIGHT);
        board.setPieceAt(createSquare(LINE_H, ROW_1), WHITE_ROOK);
        // White Pawn row
        for (Line line : Line.values()) {
            board.setPieceAt(createSquare(line, ROW_2), WHITE_PAWN);
        }

        // Black Pawn row
        for (Line line : Line.values()) {
            board.setPieceAt(createSquare(line, ROW_7), BLACK_PAWN);
        }
        board.setPieceAt(createSquare(LINE_A, ROW_8), BLACK_ROOK);
        board.setPieceAt(createSquare(LINE_B, ROW_8), BLACK_KNIGHT);
        board.setPieceAt(createSquare(LINE_C, ROW_8), BLACK_BISHOP);
        board.setPieceAt(createSquare(LINE_D, ROW_8), BLACK_QUEEN);
        board.setPieceAt(createSquare(LINE_E, ROW_8), BLACK_KING);
        board.setPieceAt(createSquare(LINE_F, ROW_8), BLACK_BISHOP);
        board.setPieceAt(createSquare(LINE_G, ROW_8), BLACK_KNIGHT);
        board.setPieceAt(createSquare(LINE_H, ROW_8), BLACK_ROOK);
    }
}
