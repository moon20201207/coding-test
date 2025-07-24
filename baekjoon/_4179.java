package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 불
public class _4179 {

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static class Node {
        int x;
        int y;
        int time;

        Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken()); // 행
        int C = Integer.parseInt(st.nextToken()); // 열
        char[][] maze = new char[R][C];
        Queue<Node> jihunQueue = new LinkedList<>();
        Queue<Node> fireQueue = new LinkedList<>();

        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j=0; j<C; j++) {
                char n = line.charAt(j);
                maze[i][j] = n;
                if (n == 'J') {
                    jihunQueue.add(new Node(i, j, 0));
                } else if (n == 'F') {
                    fireQueue.add(new Node(i, j, 0));
                }
            }
        }

        System.out.println(bfs(jihunQueue, fireQueue, maze));

    }

    private static String bfs(Queue<Node> jihunQueue, Queue<Node> fireQueue, char[][] maze) {
        int R = maze.length; // 행
        int C = maze[0].length; // 열

        while (!jihunQueue.isEmpty()) {
            int fSize = fireQueue.size();
            for (int i=0; i<fSize; i++) {
                Node fire = fireQueue.poll();
                for (int j=0; j<4; j++) { // 4방향 퍼짐
                    int nx = fire.x + dx[j];
                    int ny = fire.y + dy[j];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && maze[nx][ny] == '.') {
                        maze[nx][ny] = 'F';
                        fireQueue.add(new Node(nx, ny, fire.time+1));
                    }
                }
            }

            int jSize = jihunQueue.size();
            for (int i=0; i<jSize; i++) {
                Node jihun = jihunQueue.poll();
                int cx = jihun.x;
                int cy = jihun.y;
                int time = jihun.time;
                if (cx == 0 || cx == R - 1 || cy == 0 || cy == C - 1) {
                    return String.valueOf(time + 1); // 탈출
                }

                for (int j=0; j<4; j++) {
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && maze[nx][ny] == '.') {
                        maze[nx][ny] = 'J';
                        jihunQueue.add(new Node(nx, ny, time+1));
                    }

                }
            }
        }

        return "IMPOSSIBLE";
    }
}
