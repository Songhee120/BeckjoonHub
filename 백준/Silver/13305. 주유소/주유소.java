import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] distArr = new int[N - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] priceArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            priceArr[i] = Integer.parseInt(st.nextToken());
        }

        int i = 0;
        long result = 0;
        while(i < N - 1) {
            // 2. 본인보다 저렴한 주유소 탐색
            int pos = i + 1;
            long dist = distArr[i];
            int cnt = 1;
            while(pos < N - 1 && priceArr[i] <= priceArr[pos]) {
                dist += distArr[pos];
                pos++;
                cnt++;
            }

            // 3. 기름값 누적합
            result += dist * priceArr[i];
            i += cnt;
        }

        System.out.println(result);

    }
}
