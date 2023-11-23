/*
 * Author: João Henrique Silva Pinto
 * Link: https://www.beecrowd.com.br/judge/en/problems/view/2675
 * beecrowd | 2675 Steal Pack
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int N = scanner.nextInt();
            long ans = 0;
            int[] n = new int[N];

            for (int i = 0; i < N; i++) {
                n[i] = scanner.nextInt();
            }

            int mesa = n[N - 1];

            for (int i = N - 2; i >= 0; i--) {
                if (n[i] < mesa) {
                    mesa = n[i];
                } else {
                    ans += n[i];
                }
            }

            System.out.println(ans);
        }

        scanner.close();
    }
}
