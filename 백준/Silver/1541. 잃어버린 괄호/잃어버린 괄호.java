import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1. 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "-");   // - 기준으로 수식 나눔

        // 2. 계산
        int result = calStr(st.nextToken());

        while(st.hasMoreElements()){
            result -= calStr(st.nextToken());
        }

        // 3. 출력
        System.out.println(result);
    }

    // 숫자와 '+'로 이뤄진 문자열을 계산
    static int calStr(String str) {
        int sum = 0;
        int temp = 0;

        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == '+') {
                sum += temp;
                temp = 0;
            } else {
                temp *= 10;
                temp += str.charAt(i) - '0';    // 아스키코드 이용
            }
        }
        sum += temp;

        return sum;
    }
}
