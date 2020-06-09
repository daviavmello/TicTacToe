import java.util.Random;
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
                play();
            }
            else {
                System.out.print("Oh no! It's a shame to see you go. Come back soon!\n");
            }
    }

    public static void play () {
        char [][] gameBoard = {
            { ' ', '|', ' ', '|', ' ' },
            { ' ', '+', ' ', '+', ' ' },
            { ' ', '|', ' ', '|', ' ' }
        };
        
        userPlay(gameBoard);
    }

    public static void userPlay (char gameBoard[][]) {
        System.out.print("\nChoose your placement (1-9):\n\n");

        Scanner scnr = new Scanner(System.in);

        int [] userArray = new int[5];

        for (int i = 0; i < userArray.length; i++) {
            userArray[i] = scnr.nextInt();
            System.out.println();
            
            switch (userArray[i]) {
                case 1: gameBoard[0][0] = 'o'; break;
                case 2: gameBoard[0][2] = 'o'; break;
                case 3: gameBoard[0][4] = 'o'; break;
                case 4: gameBoard[1][0] = 'o'; break;
                case 5: gameBoard[1][2] = 'o'; break;
                case 6: gameBoard[1][4] = 'o'; break;
                case 7: gameBoard[2][0] = 'o'; break;
                case 8: gameBoard[2][2] = 'o'; break;
                case 9: gameBoard[2][4] = 'o'; break;
                default: System.out.print("Durt! Enter a number between 1 and 9."); break;
            }
            computerPlay(gameBoard, userArray);
        }    
    }

    public static void computerPlay (char gameBoard[][], int userArray[]) {
        Random random = new Random();

        int [] computerArray = new int[4];
                
        for (int i = 0; i < computerArray.length; i++) {
            computerArray[i] = random.nextInt(8) + 1;
            if (computerArray[i] == userArray[i]) {
                computerArray[i] = random.nextInt(8) + 1;
        }
            else {
                switch (computerArray[i]) {
                    case 1: gameBoard[0][0] = 'x'; break;
                    case 2: gameBoard[0][2] = 'x'; break;
                    case 3: gameBoard[0][4] = 'x'; break;
                    case 4: gameBoard[1][0] = 'x'; break;
                    case 5: gameBoard[1][2] = 'x'; break;
                    case 6: gameBoard[1][4] = 'x'; break;
                    case 7: gameBoard[2][0] = 'x'; break;
                    case 8: gameBoard[2][2] = 'x'; break;
                    case 9: gameBoard[2][4] = 'x'; break;
                }
            }
            printArray(gameBoard);
            userPlay(gameBoard);
        }
    }

    public static void printArray (char gameBoard[][]) {
        // Since this is a 2D array 'for each' loops are a good idea. However, I'll stay with the traditional 'for' loop for now.
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }
}