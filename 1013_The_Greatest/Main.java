import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        
        int maior = A;
        
        if (B > maior) {
            maior = B;
        }
        
        if (C > maior) {
            maior = C;
        }
        
        System.out.println(maior + " eh o maior");

        scanner.close();
    }
}