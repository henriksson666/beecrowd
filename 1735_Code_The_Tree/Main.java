import java.util.*;
import java.io.*;

public class Main {
    static final int MAXV = 105;
    static final int INF = 0x3F3F3F3F;
    static final int mod = 1000000007;
    static int[] grau = new int[MAXV];
    static int[][] edg = new int[MAXV][MAXV];
    static int[] vet = new int[MAXV];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        
        while((s = br.readLine()) != null) {
            if(s.isEmpty()) break;
            
            Arrays.fill(grau, 0);
            for(int[] row : edg)
                Arrays.fill(row, 0);
            
            int p = 0, i = 0, n = 0;
            while(i < s.length()) {
                if(Character.isDigit(s.charAt(i))) {
                    vet[p] = 0;
                    while(i < s.length() && Character.isDigit(s.charAt(i))) {
                        vet[p] = vet[p] * 10 + (s.charAt(i) - '0');
                        i++;
                    }
                    edg[vet[p]][vet[p - 1]] = edg[vet[p - 1]][vet[p]] = 1;
                    grau[vet[p - 1]]++;
                    grau[vet[p]]++;
                    n = Math.max(n, vet[p]);
                }
                while(i < s.length() && s.charAt(i) == ' ') i++;
                
                if(i < s.length() && s.charAt(i) == '(') {
                    p++;
                    i++;
                    continue;
                }
                if(i < s.length() && s.charAt(i) == ')') {
                    p--;
                    i++;
                    continue;
                }
            }
            grau[vet[1]]--;
            
            if(n == 1) {
                System.out.println();
                continue;
            }
            
            List<Integer> out = new ArrayList<>();
            while(out.size() < n - 2) {
                boolean yep = false;
                for(i = 1; i <= n; i++) {
                    if(grau[i] == 1) {
                        for(int j = 1; j <= n; j++) {
                            if(edg[j][i] != 0) {
                                out.add(j);
                                edg[i][j] = edg[j][i] = 0;
                                grau[j]--;
                                grau[i] = -1;
                                break;
                            }
                        }
                        yep = true;
                        break;
                    }
                }
                if(!yep) break;
            }
            
            for(i = 0; i < out.size(); i++) System.out.print(out.get(i) + " ");
            System.out.println(n);
        }
    }
}
