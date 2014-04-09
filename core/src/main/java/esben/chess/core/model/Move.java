package esben.chess.core.model;

import java.util.Objects;

import static com.google.common.base.Objects.toStringHelper;

public class Move {
    private Square from;
    private Square to;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move)) return false;

        Move move = (Move) o;

        if (!from.equals(move.from)) return false;
        if (!to.equals(move.to)) return false;

        return true;
    }


    public Move(Square from, Square to) {
        this.from = from;
        this.to = to;
    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }

    public static Move createMove(Square from, Square to) {
        return new Move(from,to);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .add("from", from)
                .add("to", to)
                .toString();
    }
//    @Override
//    public String toString() {
//        return "Move{" +
//                "from=" + from +
//                ", to=" + to +
//                '}';
//    }
}
