package esben.chess.core.model;

import com.google.common.collect.Multimaps;

import java.util.*;

import static com.google.common.base.Objects.toStringHelper;

public class Square {

    private Row row;
    private Line line;
    private static final HashMap<String, Square> ALL_SQUARES_MAP;

    static {
        ALL_SQUARES_MAP = new HashMap<>();
        for (Row row : Row.values()) {
            for (Line line : Line.values()) {
                Square square = createSquare(line, row);
                ALL_SQUARES_MAP.put(square.getSimpleNotation().toLowerCase(), square);
            }
        }
    }

    private Square(Row row, Line line) {
        this.row = row;
        this.line = line;
    }

    public static Square createSquare(Line line, Row row) {
        return new Square(row, line);
    }

    public String getSimpleNotation() {
        return line.toString() + row;
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .addValue(""+line+row)
                .toString();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null || getClass() != otherObject.getClass()) return false;

        Square otherSquare = (Square) otherObject;

        if (this.line != otherSquare.line) return false;
        if (this.row != otherSquare.row) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = row != null ? row.hashCode() : 0;
        result = 31 * result + (line != null ? line.hashCode() : 0);
        return result;
    }

    public static Set<Square> allSquares() {
        return new HashSet(ALL_SQUARES_MAP.values());
    }

    public static Square getSquareFor(String s) {
        if (ALL_SQUARES_MAP.containsKey(s.toLowerCase())) {
            return ALL_SQUARES_MAP.get(s);
        } else throw new IllegalArgumentException(String.format("Not a valid square %s.", s));
    }

    public static List<Square> getSquaresFor(String s) {
        String[] strings = s.split(",");
        List<Square> squares = new LinkedList<>();
        for (String string : strings) {
            squares.add(getSquareFor(string));
        }
        return squares;
    }

    public Row getRow() {
        return row;
    }

    public Line getLine() {
        return line;
    }
}
