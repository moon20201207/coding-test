package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토
public class _7569 {

    static final int[] dh = {-1, 1, 0, 0, 0, 0}; // 높이
    static final int[] dx = {0, 0, -1, 1, 0, 0}; // 세로
    static final int[] dy = {0, 0, 0, 0, -1, 1}; // 가로

    static class Node {
        int h;
        int x;
        int y;
        int days;

        Node(int h, int x, int y, int days) {
            this.h = h;
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
        int H = Integer.parseInt(st.nextToken()); // 높이

        int[][][] map = new int[H][N][M];
        Queue<Node> queue = new LinkedList<>();

        for (int i=0; i<H; i++) {
            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) {
                        queue.add(new Node(i, j, k, 0));
                    }
                }
            }
        }

        boolean hasUnripe = hasUnripeTomato(map);
        if (!hasUnripe) {
            // 모든 토마토가 익었을 경우
            System.out.println(0);
        } else {
            int result = bfs(map, queue);

            // 익었는지 확인
            for (int i=0; i<H; i++) {
                for (int j=0; j<N; j++) {
                    for (int k=0; k<M; k++) {
                        if (map[i][j][k] == 0) {
                            System.out.println(-1);
                            return;
                        }
                    }
                }
            }

            System.out.println(result);
        }
    }

    private static int bfs(int[][][] map, Queue<Node> queue) {
        int H = map.length; // 높이 (z축)
        int N = map[0].length; // 세로 (x축)
        int M = map[0][0].length; // 가로 (y축)

        int maxDays = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int ch = current.h;
            int cx = current.x;
            int cy = current.y;
            int days = current.days;
            maxDays = Math.max(days, maxDays);

            for (int i=0; i<6; i++) {
                int nh = ch + dh[i];
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nh >= 0 && nh < H && nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nh][nx][ny] == 0) {
                        map[nh][nx][ny] = 1;
                        queue.add(new Node(nh, nx, ny, days + 1));
                    }
                }
            }
        }

        return maxDays;
    }

    private static boolean hasUnripeTomato(int[][][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                for (int k = 0; k < map[0][0].length; k++) {
                    if (map[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
