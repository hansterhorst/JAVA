import java.util.Scanner;

public class TicTacToe_v2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Player playerA = new Player("Hans", "X");
        Player playerB = new Player("Alex", "O");
        Player currentPlayer = playerA;

        int playerInput;
        int roundCount = 1;

        boolean hasPlayerWon = false;
        boolean boardFull = false;

        System.out.println("Welcome to the game TicTacToe 2\n");

        Field[] board = new Field[9];
        createBoard(board);

        while (!hasPlayerWon && !boardFull) {
            System.out.println("Round: " + roundCount);
            System.out.println("Player " + currentPlayer.getName() + ", type in a number from 1 t/m 9.");
            playerInput = scanner.nextInt() - 1;

            while (board[playerInput].getField() == playerA.getSymbol() || board[playerInput].getField() == playerB.getSymbol()) {
                System.out.println("\nSorry, invalid input. Try again.");
                playerInput = scanner.nextInt() - 1;
            }

            setBoard(board, playerInput, currentPlayer);
            hasPlayerWon = hasWon(board);

            if (hasPlayerWon == false) {
                currentPlayer = switchPlayer(currentPlayer, playerA, playerB);
                roundCount++;
            }
            ;

            if (roundCount - 1 == board.length) {
                boardFull = true;
                break;
            }
        }
        if (boardFull) {
            System.out.println("Sorry, board is full! The game has stopped.");
        } else {
            System.out.println("Congratulations " + currentPlayer.getName() + ". You won the game!");
        }

    }

    public static void createBoard(Field[] board) {
        for (int i = 0; i < board.length; i++) {
            board[i] = new Field(Integer.toString(i + 1));
            System.out.print(board[i].getField());

            if ((i + 1) % 3 == 0) {
                if (!(i == board.length)) {
                    System.out.println("\n---------");
                }
            } else {
                System.out.print(" | ");
            }

        }
    }

    public static void setBoard(Field[] board, int index, Player currentPlayer) {
        board[index].setField(currentPlayer.getSymbol());
        for (int i = 0; i < board.length; i++) {
            System.out.print(board[i].getField());

            if ((i + 1) % 3 == 0) {
                if (!(i == board.length)) {
                    System.out.println("\n---------");
                }
            } else {
                System.out.print(" | ");
            }
        }

    }

    public static Player switchPlayer(Player currentPlayer, Player playerA, Player playerB) {
        return currentPlayer == playerA ? playerB : playerA;
    }

    public static boolean hasWon(Field[] board) {

        // horizontal
        if ((board[0].getField() == "X" && board[1].getField() == "X" && board[2].getField() == "X") || (board[0].getField() == "O" && board[1].getField() == "O" && board[2].getField() == "O")) {
            return true;
        }

        if ((board[3].getField() == "X" && board[4].getField() == "X" && board[5].getField() == "X") || (board[3].getField() == "O" && board[4].getField() == "O" && board[5].getField() == "O")) {
            return true;
        }
        if ((board[6].getField() == "X" && board[7].getField() == "X" && board[8].getField() == "X") || (board[6].getField() == "O" && board[7].getField() == "O" && board[8].getField() == "O")) {
            return true;
        }

        // vertical
        if ((board[0].getField() == "X" && board[3].getField() == "X" && board[6].getField() == "X") || (board[0].getField() == "O" && board[3].getField() == "O" && board[6].getField() == "O")) {
            return true;
        }

        if ((board[1].getField() == "X" && board[4].getField() == "X" && board[7].getField() == "X") || (board[1].getField() == "O" && board[4].getField() == "O" && board[7].getField() == "O")) {
            return true;
        }
        if ((board[2].getField() == "X" && board[5].getField() == "X" && board[8].getField() == "X") || (board[2].getField() == "O" && board[5].getField() == "O" && board[8].getField() == "O")) {
            return true;
        }

        // diagonal
        if ((board[0].getField() == "X" && board[4].getField() == "X" && board[8].getField() == "X") || (board[0].getField() == "O" && board[4].getField() == "O" && board[8].getField() == "O")) {
            return true;
        }

        if ((board[2].getField() == "X" && board[4].getField() == "X" && board[6].getField() == "X") || (board[2].getField() == "O" && board[4].getField() == "O" && board[6].getField() == "O")) {
            return true;
        }

        return false;
    }
}
