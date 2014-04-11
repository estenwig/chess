package esben.chess.core.move;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Piece;
import esben.chess.core.model.Square;

import java.util.Set;

abstract class MoveGenerator {

    public abstract Set<Move> generateMoves(Square from, Board board);

    protected Set<Move> validMovesInDirection(Board board, Square from, Direction direction) {

        Piece piece = board.getPieceAt(from);
        Predicate<Move> isTargetSquareEmpty = MovePredicates.isTargetSquareEmpty(board);
        Predicate<Move> targetSquareContainOpponentPiece = MovePredicates.targetSquareContainOpponentPiece(board, piece);

        Set<Move> legalMoves = Sets.newHashSet();
        Optional<Move> move = Directions.createMove(from, direction);
        int distance = 1;

        while (move.isPresent()) {
            Move moveWithinBounds = move.get();
            if (isTargetSquareEmpty.apply(moveWithinBounds)) {
                legalMoves.add(moveWithinBounds);
                move = Directions.createMove(from, direction, ++distance);
            } else if (targetSquareContainOpponentPiece.apply(moveWithinBounds)) {
                legalMoves.add(moveWithinBounds);
                break;
            } else {
                break;
            }
        }
        return legalMoves;
    }
}
