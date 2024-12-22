import java.util.Scanner;
import java.util.Arrays;

public class Mastermind {
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // Makes the answer array
        int[] answer = new int[4];
        for (int x = 0; x < 4; x++) {
            answer[x] = rand();
        }
        System.out.println("Colours: Blue(1), Green(2), Orange(3), Purple(4), Red(5), Yellow(6)\n");
        System.out.println("Welcome to Mastermind\n");

        // Makes the user input array
        int[][] userIn = new int[10][4];
        String[][] board = new String[10][2];

        for (int r = 0; r < 10; r++) {
            System.out.println("Enter Code");
            String temp = in.nextLine().toLowerCase();
            System.out.println("-------------");

            // Fill in userIn array
            for (int c = 0; c < 4; c++) {
                userIn[r][c] = toNum(temp.substring(c, c + 1));
            }

            // Change the string to numbers
            int inputCode = arrayToInt(userIn[r]);

            // Fill in board
            board[r][0] = temp;
            board[r][1] = simdif(answer, userIn[r]);

            // Compare
            if (inputCode == arrayToInt(answer)) {
                System.out.println("YOU WIN!");
                break; // End the game if the answer is correct
            } else {
                // Printing the board
                System.out.println("Current Board:");

                for (int b = 0; b <= r; b++) {
                    System.out.println(board[b][0] + " | " + board[b][1]);
                }
                System.out.println("-------------\n");
            }
        }
        System.out.println(Arrays.toString(answer));
    }

    // Generate a random number between 1 and 6
    public static int rand() {
        return (int) (Math.random() * 6) + 1;
    }

    // Convert color code string to number
    public static int toNum(String code) {
        switch (code) {
            case "b":
                return 1; // Blue
            case "g":
                return 2; // Green
            case "o":
                return 3; // Orange
            case "p":
                return 4; // Purple
            case "r":
                return 5; // Red
            case "y":
                return 6; // Yellow
            default:
                return -1; // Invalid input
        }
    }

    // Convert an array of integers to a single integer
    public static int arrayToInt(int[] array) {
        int result = 0;
        for (int num : array) {
            result = result * 10 + num;
        }
        return result;
    }

    // Convert int array to string line
    public static String stringifyInt(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
        }
        return sb.toString();
    }

    public static String simdif(int[] answe, int[] userI) {
        String xo = "";
        String answer = stringifyInt(answe);
        String userIn = stringifyInt(userI);

        for (int n = 0; n < 4; n++) {
            if (answer.substring(n, n + 1).equals(userIn.substring(n, n + 1))) {
                xo += "x";
            } else if (userIn.contains(answer.substring(n, n + 1))) {
                xo += "o";
            } else {
                xo += "";
            }
        }

        return xo;
    }
}
