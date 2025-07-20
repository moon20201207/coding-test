package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질
public class _1697 {

    static class Node {
        int position;
        int time;

        Node(int position, int time) {
            this.position = position;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈
        int K = Integer.parseInt(st.nextToken()); // 동생

        int MAX = 100000;
        boolean[] visited = new boolean[MAX + 1];
        System.out.println(bfs(N, K, visited));
    }

    private static int bfs(int start, int end, boolean[] visited) {

        visited[start] = true;
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(start, 0));

        while(!queue.isEmpty()) {
            Node now = queue.poll();

            if (now.position == end) {
                return now.time; // 종료
            }

            int[] nextArr = {now.position-1, now.position+1, now.position*2};

            for(int next : nextArr) {
                if(next>=0 && next<visited.length && !visited[next]) {
                    visited[next] = true;
                    queue.add(new Node(next, now.time + 1));
                }
            }
        }

        return -1; // 도달 불가능
    }
}
