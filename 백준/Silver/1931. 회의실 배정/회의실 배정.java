import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2. 계산
        // (1) 끝나는 시간 기준 오름차순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            return o1[1] != o2[1] ? o1[1] - o2[1] : o1[0] - o2[0];
//            return o1[1] - o2[1];     // 두번째 숫자 기준 정렬
        });

        // (2) 조건에 맞는 제일 빨리 끝나는 시간 찾기
        int cnt = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            // 회의의 끝나는 시간이 이전 end 보다 크고(이미 정렬 완료), 시작하는 시간이 end 보다 같거나 커야 함
            if(arr[i][0] >= end) {
                end = arr[i][1];
                cnt++;
            }
        }

        // 3. 출력
        System.out.println(cnt);
    }
}
