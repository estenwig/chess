package esben.chess.core.move;

import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Square;

import java.util.Set;

public class QueenMoveGenerator extends MoveGenerator{

    @Override
    public Set<Move> generateMoves(Square from, Board board) {
        Set<Move> queenMoves = new RookMoveGenerator().generateMoves(from, board);
        queenMoves.addAll(new BishopMoveGenerator().generateMoves(from, board));
        return queenMoves;
    }
}
