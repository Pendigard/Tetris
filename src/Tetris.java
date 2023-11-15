import model.game.Game;
import model.piece.Piece;

public class Tetris {
    public static void main(String[] args) {
        Game game = new Game();
        Piece p = game.getCurrentPiece();
        p.print();
        p.rotate();
        p.print();
    }
}