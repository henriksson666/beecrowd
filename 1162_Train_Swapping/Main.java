import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, l, num, cnt;
        n = scanner.nextInt();
        while (n-- > 0) {
            cnt = 0;
            ArrayList<Integer> v = new ArrayList<Integer>();
            l = scanner.nextInt();
            for (int i = 0; i < l; i++) {
                num = scanner.nextInt();
                v.add(num);
            }
            for (int i = 0; i < l; i++) {
                for (int j = i + 1; j < l; j++) {
                    if (v.get(i) > v.get(j)) {
                        cnt++;
                    }
                }
            }
            System.out.println("Optimal train swapping takes " + cnt + " swaps.");
        }
        scanner.close();
    }
}
