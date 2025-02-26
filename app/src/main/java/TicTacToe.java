import java.util.Scanner;

public class TicTacToe {
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    private char currentPlayer = 'X';
    private Scanner scanner = new Scanner(System.in);
    
    public void printBoard() {
        System.out.println("    A   B   C");
        for (int i = 0; i < 3; i++) {
            System.out.println("  -------------");
            System.out.print((i + 1) + "");
            for (int j = 0; j < 3; j++) {
                System.out.print(" | " + board[i][j]);
            }
            System.out.println(" |");
        }
        System.out.println("  -------------");
    }
    
    public boolean isGameOver() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) return true;
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) return true;
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) return true;
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) return true;
        return false;
    }
    
    public boolean isDraw() {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    public void takeTurn() {
        int row = -1, col = -1;
        boolean validMove = false;
        
        while (!validMove) {
            System.out.println("Player " + currentPlayer + ", enter move (e.g A1): ");
            String move = scanner.next().toUpperCase();
            
            if (move.length() == 2 && move.charAt(0) >= 'A' && move.charAt(0) <= 'C' && move.charAt(1) >= '1' && move.charAt(1) <= '3') {
                col = move.charAt(0) - 'A';
                row = move.charAt(1) - '1';
                
                if (board[row][col] == ' ') {
                    validMove = true;
                } else {
                    System.out.println("Spot taken. Try again.");
                }
            } else {
                System.out.println("Invalid. Use this format A1.");
            }
        }
        board[row][col] = currentPlayer;
    }
    
    public void playGame() {
        printBoard();
        while (true) {
            takeTurn();
            printBoard();
            
            if (isGameOver()) {
                System.out.println("Game over! Player " + currentPlayer + " wins!");
                return;
            }
            
            if (isDraw()) {
                System.out.println("It's a draw!");
                return;
            }
            
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
    }
    
    public static void main(String[] args) {
        new TicTacToe().playGame();
    }
}
