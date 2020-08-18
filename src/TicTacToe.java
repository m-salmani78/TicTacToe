import java.util.ArrayList;
import java.util.List;

public class TicTacToe {
    private int blankSpace = 9;
    private final char[] players = {'X', 'O'};
    public static final int[][] winning_states = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}};
    private char[] board = {
            ' ', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', ' '};

    public TicTacToe() {

    }

    public TicTacToe(char[] board,int blankSpace) {
        System.arraycopy(board, 0, this.board, 0, 9);
        this.blankSpace=blankSpace;
    }

    public char[] getBoard() {
        return board;
    }

    public List<Integer> getMoves() {
        List<Integer> moves = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == ' ')
                moves.add(i);
        }
        return moves;
    }

    public int getBlankSpace() {
        return blankSpace;
    }

    public void showStatus() {
        System.out.printf(
                " %c ¦ %c ¦ %c \n" +
                        "---+---+--- \n" +
                        " %c ¦ %c ¦ %c \n" +
                        "---+---+--- \n" +
                        " %c ¦ %c ¦ %c \n"
                , board[0], board[1], board[2]
                , board[3], board[4], board[5]
                , board[6], board[7], board[8]
        );
    }

    public void move(char player, int point) {
        if (board[point] != ' ' || point > 8) {
//            System.out.println("Please try again...");
            return;
        }
        board[point] = player;
        blankSpace--;
//        showStatus();
//        System.out.println("");
    }

    public static boolean isWinner(char[] board, char player) {
        for (int[] winning_state : winning_states) {
            if (player == board[winning_state[0]]
                    && player == board[winning_state[1]]
                    && player == board[winning_state[2]]) {
                return true;
            }
        }
        return false;
    }

    public boolean gameOver() {
        return (blankSpace <= 0 || winner(this.board) != null);
    }

    public static String winner(char[] board) {
        if (isWinner(board, 'X'))
            return "X";
        else if (isWinner(board, 'O'))
            return "O";
        else
            return null;
    }

    public static int scoreGame(char player) {
        if (player == 'X')
            return 1;
        else if (player == 'O')
            return -1;
        else
            return 0;
    }
}