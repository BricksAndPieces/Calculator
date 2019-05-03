import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        System.out.println("Calculator created in Java by BricksAndPieces");
        final Scanner in = new Scanner(System.in);

        boolean again;
        do {
            System.out.println("\nEquation:");

            String solution;
            try { solution = Calculator.solve(in.nextLine()) + ""; }
            catch(final IllegalArgumentException e) { // Invalid input
                solution = e.getMessage();
            }

            System.out.println("\nSolution:\n" + solution + "\n\nAgain? (y/n)");
            again = in.nextLine().equalsIgnoreCase("y");

        }while(again);

        System.out.println("\nExiting calculation...");
    }
}