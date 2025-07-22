package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class _7576 {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static class Node {
        int x;
        int y;
        int days;

        Node(int x, int y, int days) {
            this.x = x;
            this.y = y;
            this.days = days;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // 가로
        int N = Integer.parseInt(st.nextToken()); // 세로

        int[][] map = new int[N][M];
        Queue<Node> queue = new LinkedList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new Node(i, j, 0)); // Multi-source BFS
                }
            }
        }

        int result = bfs(map, queue);

        // 모두 익었는지 확인
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(result);
    }

    private static int bfs(int[][] map, Queue<Node> queue) {
        int maxDays = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int cx = current.x;
            int cy = current.y;
            int days = current.days;
            maxDays = Math.max(days, maxDays);

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                    if (map[nx][ny] == 0) {
                        map[nx][ny] = 1;
                        queue.add(new Node(nx, ny, days+1));
                    }
                }
            }
        }

        return maxDays;
    }
}
