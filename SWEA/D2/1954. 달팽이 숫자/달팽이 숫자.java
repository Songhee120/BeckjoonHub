/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            // 방향
			int direction = 0;
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            
            // 좌표
            int x = 0;
            int y = 0;
            
            // 입력과 결과 변수
            int N = sc.nextInt();
            int[][] result = new int[N][N];
            
            for(int i = 1; i <= N * N; i++)
            {
                result[x][y] = i;
                int tempX = x + dx[direction];
                int tempY = y + dy[direction];
                
                // 이동하려는 x,y 값이 0~(N-1) 범위를 벗어나거나 이미 값이 채워져 있으면 방향 변경
                if(tempX < 0 || tempX >= N || tempY < 0 || tempY >= N || result[tempX][tempY] != 0) 
                {
                    direction = (direction + 1) % 4;
                    tempX = x + dx[direction];
                    tempY = y + dy[direction];
                }
                
                x = tempX;
                y = tempY;
            
            }
            
            System.out.println("#" + test_case);
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < N; j++) 
                {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }

		}
	}
}