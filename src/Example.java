import java.util.Scanner;

public class Example {

    public static void main(String[] args) {
        System.out.println("Calculator using Strings in Java by BricksAndPieces");

        final Calculator calc = new Calculator();
        final Scanner in = new Scanner(System.in);

        boolean again;
        do {
            System.out.println("\nEquation:");

            String solution;
            try { solution = calc.calculate(in.nextLine())+""; }
            catch(final IllegalArgumentException e) {
                solution = e.getMessage();
            }

            System.out.println("\nSolution:\n" + solution + "\n\nAgain? (y/n)");
            again = in.nextLine().equalsIgnoreCase("y");

        }while(again);

        System.out.println("Exiting calculation...");
    }
}