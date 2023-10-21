import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double R = scanner.nextDouble();
        double area = 3.14159 * R * R;
        System.out.printf("A=%.4f%n", area);

        scanner.close();
    }
}
