package esben.chess.core.model;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class MoveTest {

    @Test(expected = RuntimeException.class)
    public void shouldNotHandleEmptyArgs() throws Exception {
        Move.createMove();
        fail();
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotHandleOneArgs() throws Exception {
        Square a1 = Square.getSquareFor("a1");
        Move.createMove(a1);
        fail();
    }

    @Test
    public void shouldHandleTwoArgs() throws Exception {
        Square a1 = Square.getSquareFor("a1");
        Square a2 = Square.getSquareFor("a2");
        Move move = Move.createMove(a1, a2);
        assertThat(move.getFrom(), is(a1));
        assertThat(move.getTo(), is(a2));
    }

    @Test
    public void shouldHandleThreeArgs() throws Exception {
        Square a1 = Square.getSquareFor("a1");
        Square a2 = Square.getSquareFor("a2");
        Square a3 = Square.getSquareFor("a3");
        Move move = Move.createMove(a1, a2, a3);
        assertThat(move.getFrom(), is(a1));
        assertThat(move.getTo(), is(a3));

        List<Square> allSquares = move.allSquares();
        List<Square> intermediateSquares = move.intermediateSquares();

        assertThat(allSquares.size(), is(3));
        assertThat(intermediateSquares.size(), is(1));
        assertThat(intermediateSquares.get(0), is(a2));
    }
}
