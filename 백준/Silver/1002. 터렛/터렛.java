import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        // 2. 계산
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            double d = getDistance(x1, y1, x2, y2);

            if(r1 >= r2) {
                result.append(findContact(result, r2, r1, d, r1 + r2) + "\n");
            } else {
                result.append(findContact(result, r1, r2, d, r1 + r2) + "\n");
            }
        }

        // 3. 출력
        System.out.println(result);
    }

    private static int findContact(StringBuilder result, int r1, int r2, double d, int i2) {
        if(d == 0 && r1 == r2) {
            return -1;
        } else if(d < r2 - r1 || i2 < d) {
            return 0;
        } else if(i2 == d || r2 - r1 == d) {
            return 1;
        } else {
            return 2;
        }
    }

    static double getDistance(int x1, int y1, int x2, int y2) {
        double d;
        int xd, yd;
        yd = (int) Math.pow((x1 - x2), 2);
        xd = (int) Math.pow((y1 - y2), 2);
        d = Math.sqrt(yd + xd);
        return d;
    }
}
