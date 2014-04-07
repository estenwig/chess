package esben.chess.core.model;

import org.junit.Test;

import static esben.chess.core.model.Line.*;
import static esben.chess.core.model.Move.createMove;
import static esben.chess.core.model.Piece.*;
import static esben.chess.core.model.Row.*;
import static esben.chess.core.model.Square.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void shouldGetPieceAt() throws Exception {
        Board board = new Board();
        Piece whiteKing = WHITE_KING;
        board.setPieceAt(createSquare(LINE_B, ROW_1), whiteKing);
        Piece pieceAt = board.getPieceAt(createSquare(LINE_B, ROW_1));
        assertThat(pieceAt, is(whiteKing));
    }

    @Test
    public void shouldNotMovePieceInCopy() throws Exception {
        Board board = new Board();
        Square originalSquare = createSquare(LINE_B, ROW_1);
        Square destinationSquare = createSquare(LINE_B, ROW_2);
        board.setPieceAt(originalSquare, WHITE_KING);
        Board boardCopy = board.copy();
        boardCopy.movePiece(createMove(originalSquare, destinationSquare));

        assertThat(board.isFree(originalSquare), is(Boolean.FALSE));
        assertThat(board.isFree(destinationSquare), is(Boolean.TRUE));
        assertThat(boardCopy.isFree(originalSquare), is(Boolean.TRUE));
        assertThat(boardCopy.isFree(destinationSquare), is(Boolean.FALSE));

    }
}
