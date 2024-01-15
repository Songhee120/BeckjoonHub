import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        
        // 1. 단어 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int  cnt = word.length();

        // 2. 크로아티 알파벳 찾기 ( =,-,j 찾기 )
        for (int i = 1; i < word.length(); i++) {

            if(word.charAt(i) == '=') {
                if(word.charAt(i - 1) == 'c' || word.charAt(i - 1) == 's' || word.charAt(i - 1) == 'z') {
                    cnt--;

                    // 'dz='의 경우 확인
                    if(i - 1 > 0 && word.charAt(i - 1) == 'z' && word.charAt(i - 2) == 'd') {
                        cnt--;
                    }
                    i++;
                }
            } else if (word.charAt(i) == '-') {
                if(word.charAt(i - 1) == 'c' || word.charAt(i - 1) == 'd') {
                    cnt--;
                    i++;
                }
            } else if (word.charAt(i) == 'j') {
                if(word.charAt(i - 1) == 'l' || word.charAt(i - 1) == 'n') {
                    cnt--;
                    i++;
                }
            }
        }
        
        System.out.println(cnt);
    }
}
