package esben.chess.core.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static com.google.common.base.Objects.toStringHelper;

public class Move {
    public static Move createMove(Square... squares) {
        return new Move(squares);
    }

//    public static Move createMove(Square from, Square to) {
//        return new Move(from, to);
//    }
//    private Square from;
//    private Square to;

    private List<Square> squares;

//    public Move(Square from, Square to) {
//        this.squares = Lists.newArrayList(from, to);
//    }

    public Move(Square... squares) {
        Preconditions.checkState(squares.length >= 2, "Must contain at least two squares!");
        this.squares = Lists.newArrayList(squares);
        int lastIndex = this.squares.size() - 1;
        this.squares.subList(1, lastIndex);
    }

    public Move(List<Square> squares) {
        Preconditions.checkState(squares.size() >= 2, "Must contain at least two squares!");
        this.squares = squares;
        int lastIndex = this.squares.size() - 1;
        this.squares.subList(1, lastIndex);
    }


    public Square getFrom() {
        return this.squares.get(0);
    }

    public Square getTo() {
        return this.squares.get(squares.size()-1);
    }

    public List<Square> allSquares() {
        return this.squares;
    }

    public List<Square> intermediateSquares() {
        return this.squares.subList(1, this.squares.size() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Move)) return false;

        Move move = (Move) o;

        if (!squares.equals(move.squares)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return squares.hashCode();
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("squares", squares)
                .toString();
    }
}
