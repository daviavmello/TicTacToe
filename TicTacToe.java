import java.util.Scanner;

public class TicTacToe {
    public static void main (String[] args) {
        System.out.println("***** Welcome to Tic Tac Toe! *****\nWould you like to play a game? (y/n).\n\n");

        Scanner scnr = new Scanner(System.in);
        char userInput = scnr.next().charAt(0);
        
            while ((userInput != 'y') && (userInput != 'n')) {
                System.out.print("Please press 'y' to continue or 'n' to leave.\n");
                userInput = scnr.next().charAt(0);
            }
            
            if (userInput == 'y') {
                gameBoard();
            }
            else {
                System.out.print("Oh no! It's a shame to see you go. Come back soon!\n");
            }
    }

    public static void gameBoard() {
        char[][] gameBoard = {
            { ' ', '|', ' ', '|', ' ' },
            { ' ', '-', ' ', '-', ' ' },
            { ' ', '|', ' ', '|', ' ' }
        };

        System.out.print("\nChoose your placement (1-9):\n\n");

        // Since this is a 2D array 'for each' loops are a good idea. However, I'll stay with the traditional 'for' loop for now.
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static void userPlay(char gameBoard[][]) {
        int position = scnr.nextInt();
        

    }
}