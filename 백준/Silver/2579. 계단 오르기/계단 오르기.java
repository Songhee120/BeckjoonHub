import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] dp;
    static int[] height;
    static int N;

    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        height = new int[N + 1];
        height[0] = 0;
        for (int i = 1; i <= N; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        // 2. DP
        dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = 0;
        }
        int max = findMax(N);

        // 3. 출력
        System.out.println(max);
    }

    static int findMax(int i) {
        if(i < 1) return 0;

        if(dp[i] == 0) {
            dp[i] = height[i] + Math.max(findMax(i - 2), findMax(i - 3) + height[i - 1]);
        }
        return dp[i];
    }
}
