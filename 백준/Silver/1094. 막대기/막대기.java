import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int cnt = 0;
        String binaryString = Integer.toBinaryString(x);
        for (int i = 0; i < binaryString.length(); i++) {
            if(binaryString.charAt(i) == '1')
                cnt++;
        }

        System.out.println(cnt);
    }
}
