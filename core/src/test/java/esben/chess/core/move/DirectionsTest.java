package esben.chess.core.move;

import esben.chess.core.model.Move;
import esben.chess.core.model.Square;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static esben.chess.core.model.Move.*;
import static esben.chess.core.model.Square.*;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by stenwesb on 08.04.14.
 */
public class DirectionsTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void shouldMoveTwoForward() throws Exception {
        Square b2 = getSquareFor("b2");
        Square b3 = getSquareFor("b3");
        Square b4 = getSquareFor("b4");
        Set<Move> moves = Directions.movesForward(b2, 2);
        assertThat(moves, hasItems(createMove(b2, b3), createMove(b2, b4)));
    }
    @Test
    public void shouldMoveOneForwardToEdgeOfBoard() throws Exception {
        Square b7 = getSquareFor("b7");
        Square b8 = getSquareFor("b8");
        Set<Move> moves = Directions.movesForward(b7, 3);
        assertThat(moves, hasItems(createMove(b7, b8)));
    }
}
