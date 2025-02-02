import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 최댓값 M을 골라서 모든 점수를 (점수/M)*100으로 고침
// 위와 같은 방법으로 새로운 평균 구하기

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 1. 입력  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		// 2. 계산
		// 최댓값 M 구하기
		int M = Arrays.stream(nums).max().getAsInt();
		
		// 새로운 평균 구하기
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += ((double)nums[i] / M) * 100;
		}
		double avg = sum / N;
		
		// 3. 출력
		System.out.println(avg);
		
		
		
	}
}
