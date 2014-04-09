package esben.chess.core.move;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Piece;

import javax.annotation.Nullable;

import java.math.MathContext;

import static esben.chess.core.model.Color.BLACK;
import static esben.chess.core.model.Color.WHITE;
import static esben.chess.core.model.Row.ROW_2;
import static esben.chess.core.model.Row.ROW_7;

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
                return (WHITE.equals(piece.getColor()) && ROW_2.equals(input.getFrom().getRow())) ||
                        (BLACK.equals(piece.getColor()) && ROW_7.equals(input.getFrom().getRow()));
            }
        };
    }

    public static Predicate<Move> pathIsClear(Board board, Piece piece) {
        // moveIsInAStraigthLine && traverserLinjen og spør hver enkelt square om de er tomme.
        return Predicates.and(new Predicate<Move>() {
                                  @Override
                                  public boolean apply(@Nullable Move input) {
                                      int lineMovement = input.getTo().getLine().getIndex() - input.getFrom().getLine().getIndex();
                                      Integer rowMovement = input.getTo().getRow().getIndex() - input.getFrom().getRow().getIndex();

                                      return false;
                                  }
                              }, new Predicate<Move>() {
                                  @Override
                                  public boolean apply(@Nullable Move input) {
                                      return false;
                                  }
                              }
        );
    }
}
