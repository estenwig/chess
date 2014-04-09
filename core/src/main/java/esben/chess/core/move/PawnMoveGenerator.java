package esben.chess.core.move;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import esben.chess.core.model.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import static esben.chess.core.model.Move.createMove;
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
    public List<Move> generateMoves(Square from, Board board) {
        List<Move> moveProposals = new LinkedList<>();
        // find all possible moves for this pies regardless iff it iss possible to use alle moves. Consider them preposals.
        // evaluate the axis if necessary
        Piece piece = board.getPieceAt(from);
        Optional<Move> move = Directions.createMove(from, Direction.N, 1);
        Predicate<Move> isTargetSquareEmpty = MovePredicates.isTargetSquareEmpty(board);
        Predicate<Move> targetSquareContainOpponentPiece = MovePredicates.targetSquareContainOpponentPiece(board, piece);
        Predicate<Move> isStartingSquarePawnStartingRow = MovePredicates.isStartingSquarePawnStartingRow(piece);
//        MoveSurgestion ms = MoveSurgestion.create(move, new Predicate<? extends Object>());
        if (from.getRow().equals(Row.ROW_2)) {
            Directions.createMove(from, Direction.N, 2);
        }

        Directions.createMove(from, Direction.NE, 1);
        Directions.createMove(from, Direction.NW, 1);
//Strike er også et implisitt move
//        roules(canMoveForward(1, 2), canStrike(1, Ahead), canStrikeOrMove(2, W))
        Collection<Move> muligeTrekk; // <- forflyttningsmønstere.getFromSquare(square)

        moveProposals.add(createMove(from, Square.getSquareFor("c2")));
        return moveProposals;
    }
}
