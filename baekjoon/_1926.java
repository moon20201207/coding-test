package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 그림
public class _1926 {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] canvas = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                canvas[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int paintCount = 0;
        int maxSize = 0;

        // 완전 탐색
        for (int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if (isPaint(i, j, canvas, visited)) {
                    paintCount++;
                    maxSize = Math.max(maxSize, bfs(i, j, canvas, visited));
                }
            }
        }
        System.out.println(paintCount);
        System.out.println(maxSize);
    }

    private static int bfs(int x, int y, int[][] canvas, boolean[][] visited) {
        int n = canvas.length;
        int m = canvas[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int size = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (isInRange(nx, ny, n, m) && isPaint(nx, ny, canvas, visited)) {
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    size++;
                }
            }
        }

        return size;
    }

    private static boolean isPaint(int x, int y, int[][] canvas, boolean[][] visited) {
        return canvas[x][y] == 1 && !visited[x][y];
    }

    private static boolean isInRange(int x, int y, int n, int m) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
