package esben.chess.core.move;

import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Piece;
import esben.chess.core.model.Square;

import java.util.List;

public class MoveValidator {

    public void validate(Move move, Piece dst, Board board) {
        List<Move> moves = new PawnMoveGenerator().generateMoves(move.getFrom(), board);

    }
}
