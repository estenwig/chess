package esben.chess.core.move;

import com.google.common.collect.Sets;
import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Square;

import java.util.Set;

public class BishopMoveGenerator extends MoveGenerator{

    @Override
    public Set<Move> generateMoves(Square from, Board board) {

        Set<Move> legalMoves = Sets.newLinkedHashSet();
        legalMoves.addAll(validMovesInDirection(board, from, Direction.NE));
        legalMoves.addAll(validMovesInDirection(board, from, Direction.NW));
        legalMoves.addAll(validMovesInDirection(board, from, Direction.SE));
        legalMoves.addAll(validMovesInDirection(board, from, Direction.SW));

        return legalMoves;
    }

}
