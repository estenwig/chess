package esben.chess.core.move;

import com.google.common.base.Optional;
import com.google.common.collect.Sets;
import esben.chess.core.model.Line;
import esben.chess.core.model.Move;
import esben.chess.core.model.Row;
import esben.chess.core.model.Square;

import java.util.HashSet;
import java.util.Set;

import static esben.chess.core.model.Line.getLineForIndex;
import static esben.chess.core.model.Row.getRowForIndex;
import static esben.chess.core.model.Square.createSquare;

public class Directions {
    public static Set<Move> movesForward(Square square, Direction direction, int distanceInput) {
        Set<Move> moves = Sets.newHashSet();
        for (int distance = 1; distance <= distanceInput; distance++) {
            Optional<Move> move = createMove(square, direction, distance);
            if (move.isPresent()) {
                moves.add(move.get());
            }
        }
        return moves;
    }

    public static Optional<Move> createMove(Square square, Direction direction, int distance) {
        Optional<Square> squareBasedOn = getSquareBasedOn(square, direction, distance);
        if (squareBasedOn.isPresent()) {
            return Optional.of(Move.createMove(square, squareBasedOn.get()));
        } else {
            return Optional.absent();
        }
    }


    private static Optional<Square> getSquareBasedOn(Square s, Direction direction, int distance) {
        Row rowForIndex = getRowForIndex(calculateNewRowIndex(s, direction, distance));
        Line lineForIndex = getLineForIndex(calculateNewLineIndex(s, direction, distance));
        try {
            return Optional.of(createSquare(lineForIndex, rowForIndex));
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return Optional.absent();
        }
    }

    private static int calculateNewLineIndex(Square s, Direction direction, int distance) {
        return calculateIndexWithOffsetAndDistance(s.getLine().getIndex(), distance, direction.getLineOffset());
    }

    private static int calculateNewRowIndex(Square s, Direction direction, int distance) {
        return calculateIndexWithOffsetAndDistance(s.getRow().getIndex(), distance, direction.getRowOffset());
    }

    private static int calculateIndexWithOffsetAndDistance(int originalIndex, int distance, int offset) {
        return originalIndex + (offset * distance);
    }

    public static Set<Move> movesBackward(Square s, int distance) {
        HashSet<Move> moves = Sets.newHashSet();

        int lineIndex = s.getLine().getIndex();
        int rowIndex = s.getRow().getIndex();
        for (int i = 1; i <= distance; i++) {
            try {
                Row rowForIndex = getRowForIndex(rowIndex + i);
                moves.add(Move.createMove(s, createSquare(s.getLine(), rowForIndex)));
            } catch (ArrayIndexOutOfBoundsException e) {
                //okay,
                System.out.println("Skipping index that is outside the board.");
            }
        }

        return moves;
    }
}
