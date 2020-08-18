import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class MiniMaxBot {

    static Dictionary<String, Integer> dictionary;
    public static final String BEST_SCORE = "best_score";
    public static final String MOVE = "move";

    public static Dictionary<String, Integer> minimax(TicTacToe game, char player) {
        dictionary = new Hashtable<>();
        int bestMove = -1;
        int bestScore;
        if (TicTacToe.winner(game.getBoard())!=null) {
            bestScore = -1 * TicTacToe.scoreGame(player);
//            System.out.println("########" + bestScore + "########");
        }else if(game.getBlankSpace()==0){
            bestScore=0;
        } else if (player == 'X') {
            bestScore = -2;
            List<Integer> moves = game.getMoves();
            for (int move : moves) {
                TicTacToe subGame = new TicTacToe(game.getBoard(),game.getBlankSpace());
                subGame.move('X', move);
                int score = minimax(subGame, 'O').get(BEST_SCORE);
//                System.out.println("<<<<<<<" + score + ">>>>>>>");
                if (score == -1 && subGame.getBlankSpace() > 0)
                    continue;
                if (score >= bestScore) {
                    bestMove = move;
                    bestScore = score;
                }
                if (score == 1)
                    break;
            }
        } else {
            bestScore = 2;
            List<Integer> moves = game.getMoves();
            for (int move : moves) {
                TicTacToe subGame = new TicTacToe(game.getBoard(),game.getBlankSpace());
                subGame.move('O', move);
                int score = minimax(subGame, 'X').get(BEST_SCORE);
//                System.out.println("(((((((" + score + ")))))))");
                if (score == 1 && subGame.getBlankSpace() > 0)
                    continue;
                if (score <= bestScore) {
                    bestMove = move;
                    bestScore = score;
                }
                if (score == -1)
                    break;
            }
        }
        dictionary.put(MOVE, bestMove);
        dictionary.put(BEST_SCORE, bestScore);
        return dictionary;
    }
}
