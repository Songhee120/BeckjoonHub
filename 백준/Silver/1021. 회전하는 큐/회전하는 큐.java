import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());



        // 2. 계산
        // (1) 변수 선언 및 초기화
        List<Integer> list = new ArrayList<>();
        int currentIndex = 0;
        int result = 0;
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        // (2) 칸 이동 수 계산하며 합 누적
        st = new StringTokenizer(br.readLine()); // M개의 위치 입력
        for (int i = 0; i < M; i++) {
            int targetIndex = list.indexOf(Integer.parseInt(st.nextToken()));

            int num1 = Math.max(targetIndex, currentIndex);
            int num2 = Math.min(targetIndex, currentIndex);

            int dist1 = num1 - num2;
            int dist2 = list.size() + num2 - num1;
            result += Math.min(dist1, dist2);

            list.remove(targetIndex);
            currentIndex = targetIndex;
        }

        // 3. 출력
        System.out.println(result);
    }
}
