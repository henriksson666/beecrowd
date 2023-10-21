import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int soma = A * B;
        System.out.println("PROD = " + soma);

        scanner.close();
    }
}