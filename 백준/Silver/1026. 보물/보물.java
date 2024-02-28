import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { A[i] = Integer.parseInt(st.nextToken());}

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) { B[i] = Integer.parseInt(st.nextToken());}

        // 2. 정렬 및 계산
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A[i] * B[N - i - 1];
        }

        // 3. 출력
        System.out.println(sum);
    }
}