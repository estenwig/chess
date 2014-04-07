package esben.chess.core.view;

import esben.chess.core.StandardInitializer;
import esben.chess.core.model.Board;
import org.junit.Test;

public class CommandlineChessBoardPrinterTest {
    @Test
    public void testPrint() throws Exception {
        Board board = new Board();
        new StandardInitializer().initialize(board);
        CommandlineChessBoardPrinter.print(board);
    }
}
