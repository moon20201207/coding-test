package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 연결 요소의 개수
public class _11724 {

    static List<List<Integer>> network;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수

        visited = new boolean[N];
//        int[][] network = new int[N][N];
        // 초기화
        network = new ArrayList<>();
        for (int i=0; i<N; i++) {
            network.add(new ArrayList<>());
        }

        int result = 0;

        for (int i=0; i<M; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(line.nextToken());
            int v = Integer.parseInt(line.nextToken());
//            network[u-1][v-1] = 1;
//            network[v-1][u-1] = 1; // 같은 간선은 한번만 주어짐
            network.get(u-1).add(v-1);
            network.get(v-1).add(u-1); // 같은 간선은 한번만 주어짐
        }

        for (int i=0; i<N; i++) {
            if(!visited[i]) {
                dfs(i);
                result++;
            }
        }

        System.out.println(result);
    }

    public static void dfs(int current) {
        visited[current] = true;
//        for(int i=0; i<network.length; i++) {
//            if(network[current][i] == 1 && !visited[i]) {
//                dfs(i, network);
//            }
//        }
        for (int next: network.get(current)) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }
}
