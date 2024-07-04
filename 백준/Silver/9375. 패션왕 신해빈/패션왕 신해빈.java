import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            // Map에 저장
            int cnt = Integer.parseInt(br.readLine());
            HashMap<String, Integer> clothes = new HashMap<>();
            for (int j = 0; j < cnt; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                if(clothes.containsKey(type)) {
                    clothes.replace(type, clothes.get(type), clothes.get(type) + 1);
                } else {
                    clothes.put(type, 2);
                }
            }

            // 계산
            int result = 1;
            Iterator<String> keys = clothes.keySet().iterator();
            while (keys.hasNext()) {
                String key = keys.next();
                result *= clothes.get(key);
            }

            System.out.println(result - 1);
        }

    }
}
