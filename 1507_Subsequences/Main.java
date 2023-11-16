import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N, Q, offset;
            boolean found;

            N = scanner.nextInt();

            for (; N > 0; N--) {

                String seq = scanner.next();
                Q = scanner.nextInt();

                for (; Q > 0; Q--) {
                    String sub = scanner.next();
                    offset = 0;
                    found = false;

                    for (char c : seq.toCharArray())
                        if (c == sub.charAt(offset) && ++offset == sub.length()) {
                            found = true;
                            break;
                        }

                    if (found)
                        System.out.println("Yes");
                    else
                        System.out.println("No");
                }
            }

            scanner.close();
        }
    }
}