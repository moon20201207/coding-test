package programmers;

public class _43162 {
    public void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;
        for(int i=0; i<computers.length; i++) {
            if(computers[current][i]==1 && !visited[i]) {
                dfs(i, computers, visited);
            }
        }
    }

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers, visited);
            }
        }
        return answer;
    }

}
