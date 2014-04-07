package esben.chess.core.model;

public enum Row {
    ROW_1(0), ROW_2(1), ROW_3(2), ROW_4(3), ROW_5(4), ROW_6(5), ROW_7(6), ROW_8(7);
    public static final int NOF_ROWS = values().length;
    private final int index;

    Row(int i) {
        index = i;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "" + (index+1);
    }
}
