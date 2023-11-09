import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            long maxi = 1, x, ans = 0;
            ArrayList<ArrayList<Long>> levels = new ArrayList<>();
            long[] nodes = new long[51];
            for(int i = 0; i < 51; i++) {
                levels.add(new ArrayList<Long>());
            }

            for(int i = 0; i < n; i++) {
                x = scanner.nextLong();
                nodes[(int)x]++;
            }
            for(int i = 50; i >= 1; i--) {
                for(int j = 0; j < nodes[i]; j++) {
                    ans += maxi;
                    levels.get(i).add(maxi);
                }
                Collections.sort(levels.get(i));
                for(int j = 0; j < levels.get(i).size(); j += 2) {
                    if(j + 1 < levels.get(i).size()) {
                        maxi = Math.max(maxi, Math.max(levels.get(i).get(j), levels.get(i).get(j+1)));
                        levels.get(i-1).add(levels.get(i).get(j) + levels.get(i).get(j+1));
                    }
                }
            }
            System.out.println(ans);
        }
        scanner.close();
    }
}
