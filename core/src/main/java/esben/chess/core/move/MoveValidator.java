package esben.chess.core.move;

import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Piece;
import esben.chess.core.model.Square;

import java.util.List;
import java.util.Set;

public class MoveValidator {

    public void validate(Move move, Piece dst, Board board) {
        Set<Move> moves = new PawnMoveGenerator().generateMoves(move.getFrom(), board);

    }
}
