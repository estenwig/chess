package esben.chess.core.move;

/**
 * Created by stenwesb on 04.04.14.
 */
public enum Direction {
    N ( 1,  0),
    NE( 1,  1),
    E ( 0,  1),
    SE(-1,  1),
    S (-1,  0),
    SW(-1, -1),
    W ( 0, -1),
    NW( 1, -1),;

    private final int linjeOffset;
    private final int radOffset;

    Direction(int radOffset, int linjeOffset) {
        this.radOffset = radOffset;
        this.linjeOffset = linjeOffset;
    }

    public int getLineOffset() {
        return linjeOffset;
    }

    public int getRowOffset() {
        return radOffset;
    }
}
