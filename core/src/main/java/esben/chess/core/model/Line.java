package esben.chess.core.model;

public enum Line {
    LINE_A(0), LINE_B(1), LINE_C(2), LINE_D(3), LINE_E(4), LINE_F(5), LINE_G(6), LINE_H(7);
    public static final int NOF_LINES = values().length;
    private final int index;

    Line(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return this.name().substring(5);
    }
}
