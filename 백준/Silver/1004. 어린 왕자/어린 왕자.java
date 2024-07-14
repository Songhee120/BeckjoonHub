import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());    // 테스트 케이스 개수
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            
            int n = Integer.parseInt(br.readLine());    // 행성계의 개수
            int cnt = 0;    // 거쳐야 되는 원의 개수 카운트
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                Circle circle = new Circle(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

                boolean startIsInside = start.isInside(circle);
                boolean endIsInside = end.isInside(circle);

                if(startIsInside && endIsInside) { // 명시적
                    continue;
                } else {
                    cnt = startIsInside? cnt + 1 : cnt;
                    cnt = endIsInside? cnt + 1 : cnt;
                }
            }
            result.append(cnt + "\n");
        }
        System.out.println(result);

    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isInside(Circle circle) {
        int a = Math.abs(this.x - circle.x);
        int b = Math.abs(this.y - circle.y);
        int c = circle.radius;
        return (a * a + b * b) < (c * c);
    }
}

class Circle extends Point {
    int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }
}
