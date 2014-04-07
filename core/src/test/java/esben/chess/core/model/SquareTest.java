package esben.chess.core.model;

import org.junit.Ignore;
import org.junit.Test;

import static esben.chess.core.model.Line.*;
import static esben.chess.core.model.Row.*;
import static esben.chess.core.model.Square.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

public class SquareTest {
    @Test
    @Ignore
    public void testToString() throws Exception {
        assertThat(createSquare(LINE_A, ROW_1).toString(), is(equalTo("Square{ROW_1, LINE_A}")));
    }

    @Test
    public void shouldEqual() throws Exception {
        assertThat(createSquare(LINE_B, ROW_1), is(equalTo(createSquare(LINE_B, ROW_1))));
    }

    @Test
    public void shouldNotEqual() throws Exception {
        assertThat(createSquare(LINE_B, ROW_2), is(not(equalTo(createSquare(LINE_B, ROW_1)))));
    }

    @Test
    public void shouldRetrieveASquare() throws Exception {
        assertThat(getSquareFor("b2"), is(equalTo(createSquare(LINE_B, ROW_2))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionIfNotValidText() throws Exception {
        getSquareFor("q0");
    }

}
