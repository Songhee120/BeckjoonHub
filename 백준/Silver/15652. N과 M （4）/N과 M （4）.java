import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 연산
        result = new StringBuilder();
        dfs(0, N, M, new int[M]);

        // 3. 출력
        System.out.println(result);
    }

    static void dfs(int depth, int N, int M, int[] arr) {

        if(depth == M) {
            for(int num : arr)
                result.append(num + " ");
            result.append("\n");
            return;
        }

        for (int i = depth == 0? 1 : arr[depth - 1]; i <= N; i++) {
            arr[depth] = i;
            dfs(depth + 1, N, M, arr);
        }
    }
}
