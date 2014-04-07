package esben.chess.core.model;

import com.google.common.base.Objects;
import esben.chess.core.move.MoveValidator;

import java.util.*;

public class Board {

    private final Map<Square, Piece> positions;
    private MoveValidator moveValidator;

    public Board() {
        positions = new HashMap<Square, Piece>();
    }

    /* Used only for copying with copy() */
    private Board(Map<Square, Piece> newBoard) {
        this.positions = newBoard;
    }

    public Board copy() {
        return new Board(new HashMap<Square, Piece>(positions));
    }

    public Set<Square> occupiedSquares() {
        return positions.keySet();
    }

    public Set<Square> allSquares() {
        return Square.allSquares();
    }

    public Piece getPieceAt(Square square) {
        return positions.get(square);
    }

    public void removePieceAt(Square square) {
        this.positions.remove(square);
    }

    public void setPieceAt(Square position, Piece piece) {
        if (position != null && piece != null)
            positions.put(position, piece);
    }

    /** Maybe this responsability should be at a higher level */
    public void movePiece(Move move) {
        Square src = move.getFrom();
        Square dst = move.getTo();
        Piece piece = getPieceAt(src);
        moveValidator.validate(move, piece, this);
        removePieceAt(src);
        setPieceAt(dst, piece);
    }

    public boolean isFree(Square square) {
        if (square == null)
            return false;

        return !positions.containsKey(square);
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("positions", positions)
                .toString();
    }
}
