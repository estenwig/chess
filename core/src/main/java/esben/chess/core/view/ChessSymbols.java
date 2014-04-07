package esben.chess.core.view;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.sun.xml.internal.ws.util.StringUtils;
import esben.chess.core.model.Piece;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.apache.commons.lang3.StringUtils.defaultString;

public class ChessSymbols {
    private Map<Piece, String> pieceSymbols = new HashMap<Piece, String>();
//    public static final String CHESS_CONSOLE_PIECES_PROPERTIES = "chess_console_pieces.properties";
    public static final String CHESS_CONSOLE_PIECES_PROPERTIES = "chess_console_pieces_letters.properties";

    ChessSymbols() {
        initMap(CHESS_CONSOLE_PIECES_PROPERTIES);
    }

    private void initMap(String propFileName) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = ChessSymbols.class.getClassLoader().getResourceAsStream(propFileName);
            if (input != null) {
                prop.load(input);
                for (final String name : prop.stringPropertyNames())
                    pieceSymbols.put(Piece.valueOf(name), prop.getProperty(name));
            } else {
                System.out.println("Sorry, unable to find " + propFileName);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String retrieveSymbolFor(Piece piece) {
        if (piece == null) {
            return " ";
        } else {
            return defaultString(pieceSymbols.get(piece), " ");
        }
    }
}