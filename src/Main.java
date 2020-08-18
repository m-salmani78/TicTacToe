import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        firstDescription();
        char player = 'X';
        int i = 1;
        while (!game.gameOver()) {
            if (player == 'X') {
                game.move(player, sc.nextInt());
                player = 'O';
            } else {
                game.move(player, MiniMaxBot.minimax(game, player).get(MiniMaxBot.MOVE));
                player = 'X';
            }
            game.showStatus();
            System.out.println("************ turn " + (i++) + " ************");
        }
        System.out.println("GAME OVER");
        System.out.print("The winner is: " + TicTacToe.winner(game.getBoard()));
    }

    private static void firstDescription(){
        System.out.println("************ TicTacToe ************");
        System.out.println(
                " 0 ¦ 1 ¦ 2 \n" +
                "---+---+--- \n" +
                " 3 ¦ 4 ¦ 5 \n" +
                "---+---+--- \n" +
                " 6 ¦ 7 ¦ 8 \n"
        );
        System.out.print("Enter a number in range 0 to 8: ");
    }
}

