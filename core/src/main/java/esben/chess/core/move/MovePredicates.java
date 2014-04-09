package esben.chess.core.move;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import esben.chess.core.model.*;

import javax.annotation.Nullable;

import static esben.chess.core.model.Color.*;
import static esben.chess.core.model.Row.*;

public class MovePredicates {

    public static Predicate<Move> isTargetSquareEmpty(final Board board) {
        return new Predicate<Move>() {
            @Override
            public boolean apply(@Nullable Move input) {
                return board.isFree(input.getTo());
            }
        };
    }

    private static Predicate<Move> targetSquarePieceIsOpponent(final Board board, final Piece piece) {
        return new Predicate<Move>() {
            @Override
            public boolean apply(@Nullable Move input) {
                return (!board.getPieceAt(input.getTo()).getColor().equals(piece.getColor()));
            }
        };
    }

    public static Predicate<Move> targetSquareContainOpponentPiece(final Board board, final Piece piece) {
        return Predicates.and(isTargetSquareEmpty(board),
                targetSquarePieceIsOpponent(board, piece));
    }

    public static Predicate<Move> isStartingSquarePawnStartingRow(final Piece piece) {
        return new Predicate<Move>() {
            @Override
            public boolean apply(@Nullable Move input) {
                return (WHITE.equals(piece.getColor()) && ROW_2.equals(input.getFrom().getRow()))||
                        (BLACK.equals(piece.getColor()) && ROW_7.equals(input.getFrom().getRow()));
            }
        };
    }
}
