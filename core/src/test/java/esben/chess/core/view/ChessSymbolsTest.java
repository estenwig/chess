package esben.chess.core.view;

import esben.chess.core.model.Piece;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ChessSymbolsTest {
    private ChessSymbols chessSymbols = new ChessSymbols();

    @Test
    public void testRetrieveSymbolForWhitePawn() throws Exception {
        assertThat(chessSymbols.retrieveSymbolFor(Piece.WHITE_PAWN), is("\u2659"));
    }
    @Test
    public void testRetrieveSymbolForWhiteQueen() throws Exception {
        assertThat(chessSymbols.retrieveSymbolFor(Piece.WHITE_QUEEN), is("\u2654"));
    }
    @Test
    public void testRetrieveSymbolForBlackPawn() throws Exception {
        assertThat(chessSymbols.retrieveSymbolFor(Piece.BLACK_PAWN), is("\u265F"));
    }
    @Test
    public void testRetrieveSymbolForBlackKnight() throws Exception {
        assertThat(chessSymbols.retrieveSymbolFor(Piece.BLACK_KNIGHT), is("\u265E"));
    }
}
