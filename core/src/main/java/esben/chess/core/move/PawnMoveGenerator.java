package esben.chess.core.move;

import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Piece;
import esben.chess.core.model.Square;

import java.util.LinkedList;
import java.util.List;

import static esben.chess.core.model.Move.createMove;

public class PawnMoveGenerator {
    public List<Move> generateMoves(Square from, Board board) {
        List<Move> moveProposals = new LinkedList<>();
        // find all possible moves for this pies regardless iff it iss possible to use alle moves. Consider them preposals.
        // evaluate the axis if necessary
        Piece piece = board.getPieceAt(from);
        moveProposals.add(createMove(from, Square.getSquareFor("c1")));
        return moveProposals;
    }
}
