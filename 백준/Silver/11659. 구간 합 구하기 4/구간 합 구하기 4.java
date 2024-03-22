import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 2. 계산
        st = new StringTokenizer(br.readLine());
        int[] sums = new int[N + 1];
        sums[0] = 0;
        for (int i = 1; i <= N; i++) {
            sums[i] = sums[i - 1] + Integer.parseInt(st.nextToken());   // 누적합 저장
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            result.append(-sums[Integer.parseInt(st.nextToken()) - 1] + sums[Integer.parseInt(st.nextToken())] + "\n");
        }

        // 3. 출력
        System.out.println(result);
    }
}
