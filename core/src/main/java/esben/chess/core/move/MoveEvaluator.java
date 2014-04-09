package esben.chess.core.move;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import esben.chess.core.model.Move;

import java.util.*;

public class MoveEvaluator {
    public static Set<Move> evaluate(Optional<Move> possibleMove, Predicate<Move> predicate) {
        if (possibleMove.isPresent() && predicate.apply(possibleMove.get())) {
            return Sets.newHashSet(possibleMove.get());
        }
        return Collections.emptySet();
    }

    public static Set<Move> evaluate(HashSet<Optional<Move>> possibleMoves, Predicate<Move> predicate) {
        LinkedHashSet<Move> moves = Sets.newLinkedHashSet();
        for (Optional<Move> possibleMove : possibleMoves) {
            moves.addAll(evaluate(possibleMove, predicate));
        }
        return moves;
    }
}
