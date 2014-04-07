package esben.chess.core.model;

import esben.chess.core.StandardInitializer;
import esben.chess.core.view.CommandlineChessBoardPrinter;
import org.junit.Test;

import static esben.chess.core.model.Line.*;
import static esben.chess.core.model.Row.*;
import static esben.chess.core.model.Square.createSquare;

public class GameTest {

    @Test
    public void testNewStandardGame() throws Exception {
        Game game = new Game();

        new StandardInitializer().initialize(game.getBoard());
        CommandlineChessBoardPrinter.print(game.getBoard());
        System.out.println();
        game.getBoard().movePiece(Move.createMove(createSquare(LINE_B, ROW_1), createSquare(LINE_A, ROW_3)));

        CommandlineChessBoardPrinter.print(game.getBoard());
    }
}
