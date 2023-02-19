package Search;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
    public static void bfs(int[][] graph,int start){
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[graph.length];
        queue.offer(start);
        visited[start]=true;
        while (!queue.isEmpty()){
            int node=queue.poll();
            System.out.print(node+" ");
            for (int i = 0; i < graph.length; i++) {
                if (graph[node][i]==1&&!visited[i]){
                    queue.offer(i);
                    visited[i]=true;
                }
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

        System.out.print("BFS traversal: ");
        bfs(graph, start);
    }
}
