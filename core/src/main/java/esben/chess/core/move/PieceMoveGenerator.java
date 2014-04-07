package esben.chess.core.move;

import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Piece;

import java.util.List;

public abstract class PieceMoveGenerator {
    public abstract List<Move> generateMoves(Piece piece, Board board);
}
