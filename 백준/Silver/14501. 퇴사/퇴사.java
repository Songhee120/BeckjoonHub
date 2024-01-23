import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] schedule;
    static int MAX;

    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        schedule = new int [N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken());  // 소요 기간
            schedule[i][1] = Integer.parseInt(st.nextToken());  // 지급 금액
        }

        // 2. bfs
        MAX = Integer.MIN_VALUE;
        bfs(0, 0);


        // 3. 결과 출력
        System.out.println(MAX);
    }

    // day: 며칠째인지
    // pay: 지금까지 얼마의 금액을 받았는지
    static void bfs(int day, int pay) {
        // 종료 조건
        if(day >= N) {
            MAX = Math.max(MAX, pay);
            return;
        }

        // 상황 1) 이번 상담을 이행할 수 있다면 한다.
        if(day + schedule[day][0] <= N) {
            bfs(day + schedule[day][0], pay + schedule[day][1]);
        } else {  // 상황 2) 이번 상담의 소요 기간이 길어 이번 스케줄을 이행할 수 없다.
            bfs(day + schedule[day][0], pay);
        }

        // 상황 3) 이번 상담을 건너뛰고 탐색해본다.
        bfs(day + 1, pay);
    }
}
