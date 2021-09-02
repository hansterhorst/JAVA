import java.util.Scanner;

public class TicTacToe {
    public static boolean hasWon;

    public static void main(String[] args) {

        // variables
        Scanner scanner = new Scanner(System.in);
        String[] board = new String[9];
        String currentPlayer = "X";
        int roundCount = 1;
        hasWon = false;

        System.out.println("Welcome to the game Tic Tac Toe.\n");

        // create the board
        for (int i = 0; i < board.length; i++) {
            board[i] = Integer.toString(i + 1);
        }

        // print board on the screen
        createBoard(board);

        // next round
        while (!hasWon) {

            // check if all board input option are fulled,
            if ((roundCount > board.length)) {
                break;
            }

            // print the game round and wich player is playing
            System.out.println("Round " + roundCount);
            System.out.println("Player " + currentPlayer + ", type in the number 1 t/m 9.");
            int playerInput = scanner.nextInt() - 1;

            // check if the board position is fulled
            while ((board[playerInput] == "X") || (board[playerInput] == "O")) {
                System.out.println("Sorry, invalid input. Try Again.");
                System.out.println("Player " + currentPlayer + ", type in a number 1 t/m 9.");
                playerInput = scanner.nextInt() - 1;
            }

            // set the board position by the player input
            board[playerInput] = currentPlayer;
            createBoard(board);

            // set the boolean by checking if the player won
            hasWon = hasPlayerWon(board, currentPlayer);

            // set the values for the next round
            if (!hasWon) {
                currentPlayer = currentPlayer == "X" ? "O" : "X";
                roundCount++;
            }


        }

        // print a message if the player has won or not
        if (hasWon) {
            System.out.println("Player " + currentPlayer + ". You won the game! ");
        } else {
            System.out.println("All board inputs are full. Thank you for playing.");
        }

    }

    // methode for create the board
    public static void createBoard(String[] board) {

        for (int i = 0; i < board.length; i++) {
            boolean endOfColumn = (i + 1) % 3 == 0;

            if (!endOfColumn) {
                System.out.print(board[i] + " | ");
            } else {
                System.out.print(board[i]);
            }

            if (endOfColumn) {
                System.out.println("\n---------");
            }
        }

    }

    // methode for checking if the player has won
    public static boolean hasPlayerWon(String[] board, String currentPlayer) {
        // horizontal checking
        if (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer) {
            return true;
        }

        if (board[3] == currentPlayer && board[4] == currentPlayer && board[5] == currentPlayer) {
            return true;
        }

        if (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }

        // vertical checking
        if (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer) {
            return true;
        }

        if (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer) {
            return true;
        }

        if (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }

        // Diagonal checking
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer) {
            return true;
        }

        if (board[2] == currentPlayer && board[4] == currentPlayer && board[6] == currentPlayer) {
            return true;
        }

        return false;
    }

}
