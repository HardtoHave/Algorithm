package Search;

public class DepthFirstSearch {
    public static void dfs(int[][] graph,int start,boolean[] visited){
        visited[start]=true;
        System.out.print(start+" ");
        for (int i = 0; i < graph.length; i++) {
            if (graph[start][i]==1&&!visited[i]){
                dfs(graph,i,visited);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 1, 0}
        };
        int start = 0;
        boolean[] visited = new boolean[graph.length];

        System.out.print("DFS traversal: ");
        dfs(graph, start, visited);
    }
}
