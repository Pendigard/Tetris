import model.game.Game;
import model.piece.Piece;

public class Tetris {
    public static void main(String[] args) {
        Game game = new Game();
        game.print();
        game.hardDrop();
        System.out.println();
        game.print();
    }
}