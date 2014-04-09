package esben.chess.core.model;

import com.google.common.collect.Collections2;

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

    public static Row getRowForIndex(int i) {
        return values()[i];
    }
}
