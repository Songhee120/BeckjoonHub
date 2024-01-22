import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;           // 수의 개수
    static int[] nums;      // 수열
    static int[] operator;  // 연산자
    static int MAX;         // 최댓값
    static int MIN;         // 최솟값


    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());    // 수의 개수

        nums = new int[N];      // 수열
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];  // 연산자
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 2. bfs
        MAX = Integer.MIN_VALUE;
        MIN = Integer.MAX_VALUE;
        bfs(nums[0], 0);

        // 3. 결과 출력
        System.out.println(MAX);
        System.out.println(MIN);
    }


    static void bfs(int result, int cnt) {  // result는 현재까지 계산된 값, cnt는 호출 횟수
        // 1) 마지막 재귀일 시 MAX, MIN 업데이트
        if(cnt == N - 1) {
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }

        // 2) 연산자 하나씩 사용하기위한 for문
        for (int i = 0; i < 4; i++) {
            // 3) 아직 사용할 연산자 남아있으면 해당 인덱스 -1하고 result값 계산, bfs 호출
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0: bfs(result + nums[cnt + 1], cnt + 1); break;
                    case 1: bfs(result - nums[cnt + 1], cnt + 1); break;
                    case 2: bfs(result * nums[cnt + 1], cnt + 1); break;
                    case 3: bfs(result / nums[cnt + 1], cnt + 1); break;
                }

                operator[i]++;
            }
        }
    }


}
