package esben.chess.core.model;

import static esben.chess.core.model.Color.*;
import static esben.chess.core.model.PieceType.*;

public enum Piece {
    WHITE_PAWN(WHITE, PAWN),
    WHITE_KNIGHT(WHITE, KNIGHT),
    WHITE_BISHOP(WHITE, BISHOP),
    WHITE_ROOK(WHITE, ROOK),
    WHITE_QUEEN(WHITE, QUEEN),
    WHITE_KING(WHITE, KING),
    //
    BLACK_PAWN(BLACK, PAWN),
    BLACK_KNIGHT(BLACK, KNIGHT),
    BLACK_BISHOP(BLACK, BISHOP),
    BLACK_ROOK(BLACK, ROOK),
    BLACK_QUEEN(BLACK, QUEEN),
    BLACK_KING(BLACK, KING);

    Piece(Color color, PieceType pieceType) {
        this.color = color;
        this.pieceType = pieceType;
    }

    private Color color;
    private PieceType pieceType;

    public Color getColor() {
        return color;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
