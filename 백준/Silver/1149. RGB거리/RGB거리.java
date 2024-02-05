import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {

    static int N;
    static int[][] cost;
    static int[][] result;


    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N + 1][3];
        result = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        // 2. 계산
        result[1][0] = cost[1][0];
        result[1][1] = cost[1][1];
        result[1][2] = cost[1][2];

        for (int i = 2; i <= N; i++) {
            result[i][0] = cost[i][0] + min(result[i - 1][1], result[i - 1][2]);
            result[i][1] = cost[i][1] + min(result[i - 1][0], result[i - 1][2]);
            result[i][2] = cost[i][2] + min(result[i - 1][0], result[i - 1][1]);
        }

        // 3. 출력
        int min = min(result[N][0], min(result[N][1], result[N][2]));
        System.out.println(min);
    }

}
