package baekjoon;

import java.util.*;

public class _2667 {
    static int N;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;
    static List<Integer> results;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];
        results = new ArrayList<>();

        // 지도
        for (int i=0; i<N; i++) {
            String line = sc.next();
            for(int j=0; j<N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // 연산 시작
        for (int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    results.add(count);
                }
            }
        }

        Collections.sort(results);
        System.out.println(results.size());
        for (int r : results) {
            System.out.println(r);
        }
    }

    public static void dfs (int x, int y) {
        visited[x][y] = true;
        count++;

        // 상하좌우
        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}
