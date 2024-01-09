import java.util.Arrays;

public class Main {

    static boolean[] isSelfNum;

    public static void main(String[] args) {
        // 1. 배열 생성
        isSelfNum = new boolean[10001];
        Arrays.fill(isSelfNum, true);

        // 2. 셀프넘버 아닌 수 지우기
        for (int i = 1; i <= 10000; i++) {
            if(isSelfNum[i])
                markNonSelfNum(i);
        }

        // 3. 셀프넘버 출력
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if(isSelfNum[i])
                result.append(i + "\n");
        }
        System.out.println(result);
        
    }

    // 생성자를 받아 수열을 만들며 배열에 false 표시 해주는 메소드
    static void markNonSelfNum(int i) {
        int sum;
        int j;

        while(true){    // i값 업데이트
            sum = i;
            j = i;

            while(j > 0){       // j값 업데이트
                sum += j % 10;
                j /= 10;
            }

            if(sum > 10000)
                break;

            isSelfNum[sum] = false;
            i = sum;
        }
    }
}
