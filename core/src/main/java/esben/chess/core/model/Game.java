package esben.chess.core.model;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Objects.toStringHelper;

/**
 * utgangspunkt, progresjon over en rekke trekk
 */
public class Game {
    private List<Move> moves = new ArrayList<Move>();
    private Board board = new Board();
    private Color playerToMakeMove = Color.WHITE;

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("moves", moves)
                .add("board", board)
                .toString();
    }
}
