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

/**
 * Created by stenwesb on 04.04.14.
 */
public class PawnMoveGeneratorTest {
    Board board = new Board();
    PawnMoveGenerator moveGenerator = new PawnMoveGenerator();
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGenerateMoves() throws Exception {
        Square b2 = getSquareFor("b2");
        Square c1 = getSquareFor("c1");
        Square c2 = getSquareFor("c2");
        Square c3 = getSquareFor("c3");
        List<Move> moves = moveGenerator.generateMoves(b2, board);
        assertThat(moves, hasItems(createMove(b2, c1),createMove(b2, c2),createMove(b2, c3)));
    }
}
