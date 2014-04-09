package esben.chess.core.move;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;
import esben.chess.core.model.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static esben.chess.core.model.Move.createMove;
import static esben.chess.core.move.Direction.*;

/*
Rettninger en bonde kan forflyttes:
en frem
to frem
slå skrått frem (høyre, venstre)

Spesielt:
byttes i en offiser ved enden av brettet
en passant

 */
public class PawnMoveGenerator {
    public Set<Move> generateMoves(Square from, Board board) {
        Piece piece = board.getPieceAt(from);

        Predicate<Move> isTargetSquareEmpty = MovePredicates.isTargetSquareEmpty(board);
        Predicate<Move> targetSquareContainOpponentPiece = MovePredicates.targetSquareContainOpponentPiece(board, piece);
        Predicate<Move> isStartingSquarePawnStartingRow = MovePredicates.isStartingSquarePawnStartingRow(piece);
        Predicate<Move> pathIsClear = MovePredicates.pathIsClear(board, piece);

        Predicate<Move> twoMovesRule = Predicates.and(isStartingSquarePawnStartingRow, isTargetSquareEmpty, pathIsClear);
        Set<Move> legalMoves = Sets.newLinkedHashSet();


        Optional<Move> moveOneForward = Directions.createMove(from, N);
        Optional<Move> moveTwoForward = Directions.createMove(from, N, 2);

        Optional<Move> moveStrikeNorthEast = Directions.createMove(from, NE);
        Optional<Move> moveStrikeNorthWest = Directions.createMove(from, NW);

        legalMoves.addAll(MoveEvaluator.evaluate(moveOneForward, isTargetSquareEmpty));
        legalMoves.addAll(MoveEvaluator.evaluate(moveTwoForward, twoMovesRule));
        legalMoves.addAll(MoveEvaluator.evaluate(Sets.newHashSet(moveStrikeNorthEast,moveStrikeNorthWest), targetSquareContainOpponentPiece));

        return legalMoves;
    }
}
