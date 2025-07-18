package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// DFS와 BFS
public class _1260 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>(); // graph 초기화
        for(int i=0; i<=N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        br.close();

        // 정점 번호가 작은 것을 먼저 방문
        for(int i=1; i<=N; i++) {
            Collections.sort(graph.get(i)); // 오름차순 정렬
        }

        boolean[] visited = new boolean[N+1];
        List<Integer> dfsResult = new ArrayList<>();
        dfs(V, graph, visited, dfsResult);
        dfsResult.forEach(num -> System.out.print(num + " "));

        System.out.println();

        Arrays.fill(visited, false); // visited 초기화
        List<Integer> bfsResult = bfs(V, graph, visited);
        bfsResult.forEach(num -> System.out.print(num + " "));
    }

    private static void dfs(int current, List<List<Integer>> graph, boolean[] visited, List<Integer> result) {
        visited[current] = true;
        result.add(current);

        for(int next: graph.get(current)) {
            if (!visited[next]) {
                dfs(next, graph, visited, result);
            }
        }
    }

    private static List<Integer> bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            result.add(current);

            for(int next: graph.get(current)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return result;
    }
}
