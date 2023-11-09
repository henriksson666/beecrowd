import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static long[] tree, lazy;

    static long query_tree(int node, int a, int b, int i, int j) {
        if (a > b || a > j || b < i) return 0;
        
        if (lazy[node] != 0) {
            tree[node] += (b - a + 1) * lazy[node];
            
            if (a != b) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            
            lazy[node] = 0;
        }
        
        if (a >= i && b <= j) return tree[node];
        
        long q1 = query_tree(node * 2, a, (a + b) / 2, i, j);
        long q2 = query_tree(1 + node * 2, 1 + (a + b) / 2, b, i, j);
        
        return q1 + q2;
    }

    static void update_tree(int node, int a, int b, int i, int j, long value) {
        if (lazy[node] != 0) {
            tree[node] += (b - a + 1) * lazy[node];
            
            if (a != b) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            
            lazy[node] = 0;
        }
        
        if (a > b || a > j || b < i) return;
        
        if (a >= i && b <= j) {
            tree[node] += (b - a + 1) * value;
            
            if (a != b) {
                lazy[node * 2] += value;
                lazy[node * 2 + 1] += value;
            }
            
            return;
        }
        
        update_tree(node * 2, a, (a + b) / 2, i, j, value);
        update_tree(1 + node * 2, 1 + (a + b) / 2, b, i, j, value);
        
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            tree = new long[N * 4];
            lazy = new long[N * 4];
            
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                if (op == 1) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    out.println(query_tree(1, 1, N, a, b));
                } else {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    long v = Long.parseLong(st.nextToken());
                    update_tree(1, 1, N, a, b, v);
                }
            }
        }
        out.flush();
        out.close();
    }
}
