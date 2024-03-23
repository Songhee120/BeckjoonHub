import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        if(n == 1) {
            arr[0] = 1;
        } else if (n == 2) {
            arr[1] = 1;
        } else {
            fibo(n - 1, arr);
        }

        System.out.println(arr[n - 1]);
    }

    static long fibo(int n, long[] arr) {
        if(n == 0 || n == 1) {
            return 1;
        } else if (arr[n] != 0) {
            return arr[n];
        } else {
            arr[n] = fibo(n - 1, arr) + fibo(n - 2, arr);
            return arr[n];
        }
    }


}
