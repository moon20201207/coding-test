package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// 유기농 배추
public class _1012 {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트케이스
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 가로
            int N = Integer.parseInt(st.nextToken()); // 세로
            int K = Integer.parseInt(st.nextToken()); // 배추 수

            // 밭
            int[][] map = new int[N][M];
            for(int j=0; j<K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken()); // (0 ≤ X ≤ M-1)
                int Y = Integer.parseInt(st.nextToken()); // (0 ≤ Y ≤ N-1)
                map[Y][X] = 1;
            }
            boolean[][] visited = new boolean[N][M];

            int count = 0;
            for(int n=0; n<N; n++) {
                for(int m=0; m<M; m++) {
                    if (isCabbage(n, m, map, visited)) {
                        bfs(n, m, map, visited);
                        count++;
                    }
                }
            }
            result.add(count);
        }

        result.forEach(num -> System.out.println(num));
    }

    private static void bfs(int x, int y, int[][] map, boolean[][] visited) {
        visited[x][y] = true; // 제일 먼저 하기
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(isInRange(nx, ny, map) && isCabbage(nx, ny, map, visited)) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean isInRange(int x, int y, int[][] map) {
        return x>=0 && y>=0 && x<map.length && y<map[0].length;
    }
    private static boolean isCabbage(int x, int y, int[][] map, boolean[][] visited) {
        return map[x][y] == 1 && !visited[x][y];
    }
}
