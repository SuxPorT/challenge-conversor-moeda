package alura.challenges;

import java.util.Scanner;

public class LeitorEntrada {
    private static final Scanner scanner = new Scanner(System.in);

    public static int lerInteiro() {
        return scanner.nextInt();
    }

    public static double lerDouble() {
        return scanner.nextDouble();
    }

    public static void limparBuffer() {
        scanner.nextLine();
    }
}
