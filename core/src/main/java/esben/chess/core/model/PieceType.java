package esben.chess.core.model;

public enum PieceType {
    PAWN(1), KNIGHT(3), BISHOP(3), ROOK(5), QUEEN(9), KING(100);

    PieceType(int heuristicsValue) {
        this.heuristicsValue = heuristicsValue;
    }

    public int getHeuristicsValue() {
        return heuristicsValue;
    }

    private int heuristicsValue;
}
