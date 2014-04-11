package esben.chess.core.move;

import com.google.common.collect.Sets;
import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Square;

import java.util.Set;

public class RookMoveGenerator extends MoveGenerator{
    @Override
    public Set<Move> generateMoves(Square from, Board board) {

        Set<Move> legalMoves = Sets.newLinkedHashSet();
        legalMoves.addAll(validMovesInDirection(board, from, Direction.E));
        legalMoves.addAll(validMovesInDirection(board, from, Direction.W));
        legalMoves.addAll(validMovesInDirection(board, from, Direction.N));
        legalMoves.addAll(validMovesInDirection(board, from, Direction.S));

       return legalMoves;
     }


}
