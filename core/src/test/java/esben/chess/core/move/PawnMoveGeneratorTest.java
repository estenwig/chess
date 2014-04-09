package esben.chess.core.move;

import esben.chess.core.model.*;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static esben.chess.core.model.Move.*;
import static esben.chess.core.model.Square.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class PawnMoveGeneratorTest {
    Board board = new Board();
    PawnMoveGenerator moveGenerator = new PawnMoveGenerator();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGenerateMoves() throws Exception {
        Square b2 = getSquareFor("b2");
        Square b3 = getSquareFor("b3");
        Square b4 = getSquareFor("c4");
        Square c3 = getSquareFor("c3");
        board.setPieceAt(b2, Piece.WHITE_PAWN);
        List<Move> moves = moveGenerator.generateMoves(b2, board);
        System.out.println(moves);
        assertThat(moves, hasItems(createMove(b2, b3),createMove(b2, b4)));
    }
}
