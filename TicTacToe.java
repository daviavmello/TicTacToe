import java.util.Random;
import java.util.Scanner;
import java.util.*;

public class TicTacToe {
    
    static ArrayList<Integer> userPlacements = new ArrayList<Integer>();
    static ArrayList<Integer> compPlacements = new ArrayList<Integer>();
    public static void main (String[] args) {
        System.out.println("***** Welcome to Tic Tac Toe! *****\nWould you like to play a game? (y/n).\n\n");

        Scanner scnr = new Scanner(System.in);
        char userInput = scnr.next().charAt(0);
        
            while ((userInput != 'y') && (userInput != 'n')) {
                System.out.print("Please press 'y' to continue or 'n' to leave.\n");
                userInput = scnr.next().charAt(0);
            }
            
            if (userInput == 'y') {
                board ();
            }
            else {
                System.out.print("Oh no! It's a shame to see you go. Come back soon!\n");
            }
    }

    public static void board () {
        char [][] gameBoard = {
            { ' ', '|', ' ', '|', ' ' },
            { '-', '+', ' ', '+', '-' },
            { ' ', '|', ' ', '|', ' ' },
            { '-', '+', ' ', '+', '-' },
            { ' ', '|', ' ', '|', ' ' },
        };

        boolean userTurn = true;
        
        userPlay(gameBoard, userTurn);
        // String result = gameOver();
        // System.out.println(result);
    }

    public static void userPlay (char gameBoard[][], boolean userTurn) {
        while(true) {
        System.out.print("\nChoose your placement (1-9):\n\n");

        char symbol;
        int input;

        Scanner scnr = new Scanner(System.in);
        Random random = new Random();

        if (!userTurn) {
            input = random.nextInt(9) + 1;
            userPlacements.add(input);
            symbol = 'x';
            userTurn = true;
            }
        else {
            input = scnr.nextInt();
            compPlacements.add(input);
            symbol = 'o';
            userTurn = false;
            }
                switch (input) {
                    case 1: gameBoard[0][0] = symbol; break;
                    case 2: gameBoard[0][2] = symbol; break;
                    case 3: gameBoard[0][4] = symbol; break;
                    case 4: gameBoard[2][0] = symbol; break;
                    case 5: gameBoard[2][2] = symbol; break;
                    case 6: gameBoard[2][4] = symbol; break;
                    case 7: gameBoard[4][0] = symbol; break;
                    case 8: gameBoard[4][2] = symbol; break;
                    case 9: gameBoard[4][4] = symbol; break;
                    default: break;

                }
                printArray(gameBoard);
                String result = gameOver();
                System.out.println(result);
            }
        }
            //     System.out.println("\nToo bad! This spot is taken! Select a different one:\n");
            //     userArray[i] = scnr.nextInt();
            // }

    public static void printArray (char gameBoard[][]) {
        // Since this is a 2D array 'for each' loops are a good idea. However, I'll stay with the traditional 'for' loop for now.
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                System.out.print(gameBoard[i][j]);
            }
            System.out.println();
        }
    }

    public static String gameOver() {
        List topRow = Arrays.asList (1, 2, 3);
        List midRow = Arrays.asList (4, 5, 6);
        List botRow = Arrays.asList (7, 8, 9);
        List leftCol = Arrays.asList (1, 4, 7);
        List midCol = Arrays.asList (2, 5, 8);
        List rightCol = Arrays.asList (3, 6, 9);
        List leftDiag = Arrays.asList (1, 5, 9);
        List rightDiag = Arrays.asList (3, 5, 7);

        List<List> win = new ArrayList<List>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(rightCol);
        win.add(leftDiag);
        win.add(rightDiag);

        for(List l : win) {
            if (compPlacements.containsAll(l)){
                return "\nOh wow! You did it!\n\n";
            }

            else if (userPlacements.containsAll(l)) {
                return "\nMuahaha! Better luck next time!\n\n";
            }

            else if (compPlacements.size() + userPlacements.size() == 9) {
                return "\nOh no! It's a draw!\n\n";
            }
        }
        return " ";
    }

}