package esben.chess.core.view;

import esben.chess.core.model.Board;
import esben.chess.core.model.Line;
import esben.chess.core.model.Piece;
import esben.chess.core.model.Row;

import static com.google.common.collect.Lists.reverse;
import static esben.chess.core.model.Square.createSquare;
import static java.util.Arrays.asList;

public class CommandlineChessBoardPrinter {
    public static void  print(Board board){
        ChessSymbols symbols = new ChessSymbols();
        StringBuilder builder = new StringBuilder();

        builder.append(" +---------------+\n");
        for (Row row : reverse(asList(Row.values()))) {
            builder.append(row).append("|");
            for (Line line : Line.values()) {
                Piece piece = board.getPieceAt(createSquare(line, row));
                builder.append(symbols.retrieveSymbolFor(piece));
                if (line.getIndex()<7) builder.append(" ");
            }builder.append("|\n");
        }
        builder.append(" +---------------+\n");
        builder.append("  ");
        for (Line line : Line.values()) {
            builder.append(line).append(" ");
        }
        System.out.println(builder.toString());
    }
}
