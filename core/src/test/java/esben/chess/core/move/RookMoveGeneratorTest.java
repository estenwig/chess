package esben.chess.core.move;

import static esben.chess.core.model.Square.getSquareFor;

import esben.chess.core.model.Board;
import esben.chess.core.model.Move;
import esben.chess.core.model.Piece;
import esben.chess.core.model.Square;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

public class RookMoveGeneratorTest extends TestCase {

    Board board = new Board();
    RookMoveGenerator moveGenerator = new RookMoveGenerator();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testGenerateMovesForCornerNoOtherPieces() throws Exception {
        Square a1 = getSquareFor("a1");
        board.setPieceAt(a1, Piece.WHITE_ROOK);
        Set<Move> moves = moveGenerator.generateMoves(a1, board);
        System.out.println(moves);
        assert(moves.size()== 14);
    }

    @Test
    public void testGenerateMovesForCornerTrappedByFriendlyPieces() throws Exception {
        Square a1 = getSquareFor("a1");
        Square a2 = getSquareFor("a2");
        Square b1 = getSquareFor("b1");
        board.setPieceAt(a1, Piece.WHITE_ROOK);
        board.setPieceAt(a2, Piece.WHITE_PAWN);
        board.setPieceAt(b1, Piece.WHITE_KNIGHT);
        Set<Move> moves = moveGenerator.generateMoves(a1, board);
        assert(moves.isEmpty());
    }

    @Test
    public void testGenerateMovesForCornerTrappedByEnemyPieces() throws Exception {
        Square a1 = getSquareFor("a1");
        Square a2 = getSquareFor("a2");
        Square b1 = getSquareFor("b1");
        board.setPieceAt(a1, Piece.WHITE_ROOK);
        board.setPieceAt(a2, Piece.BLACK_PAWN);
        board.setPieceAt(b1, Piece.BLACK_KNIGHT);
        Set<Move> moves = moveGenerator.generateMoves(a1, board);
        assert(moves.size()== 2);
    }

    @Test
    public void testGenerateMovesForCenterOfTheBoardNoOtherPieces() throws Exception {
        Square a1 = getSquareFor("d4");
        board.setPieceAt(a1, Piece.WHITE_ROOK);
        Set<Move> moves = moveGenerator.generateMoves(a1, board);
        assert(moves.size()== 14);
    }

}
