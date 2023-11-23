/*
 * Author: João Henrique Silva Pinto
 * Link: https://www.beecrowd.com.br/judge/en/problems/view/1282
 * beecrowd | 1282 Arranging Heaps
 */

import java.util.Scanner;

public class Main {

    static long[][] pd, cost;
    static int n, k;
    static int[] point, weight, save;

    static final long LINF = 1L << 60;

    static long solve(int i, int c) {
        if (i == n)
            return 0;
        if (pd[i][c] != -1)
            return pd[i][c];
        if (c == 1)
            return pd[i][c] = cost[i][n - 1];

        long ret = LINF;
        int ini = i, fim = n - c + 1, best = 0;
        if (i > 0 && save[i - 1] != 0)
            ini = save[i - 1];
        if (save[i] != 0)
            fim = save[i] + 1;

        for (int j = ini; j < fim; j++) {
            long aux = solve(j + 1, c - 1) + cost[i][j];
            if (ret > aux) {
                ret = aux;
                best = j;
            }
        }

        save[i] = best;

        return pd[i][c] = ret;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            n = scanner.nextInt();
            k = scanner.nextInt();

            point = new int[n];
            weight = new int[n];
            save = new int[n + 1];
            pd = new long[n +1][k + 1];
            cost = new long[n][n];

            for (int i = 0; i < n; i++) {
                point[i] = scanner.nextInt();
                weight[i] = scanner.nextInt();
                for (int j = 0; j <= k; j++) {
                    pd[i][j] = -1;
                    save[i] = 0;
                }
            }
            for (int j = 0; j <= k; j++) {
                pd[n][j] = -1;
                save[n] = 0;
            }

            for (int i = n - 1; i >= 0; i--) {
                cost[i][i] = 0;
                for (int j = i - 1; j >= 0; j--) {
                    cost[j][i] = cost[j + 1][i] + (long) weight[j] * (point[i] - point[j]);
                }
            }

            long ans = solve(0, k);

            System.out.println(ans);
        }

        scanner.close();
    }
}
