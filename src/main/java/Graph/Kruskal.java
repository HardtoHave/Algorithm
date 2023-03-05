package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Kruskal {
    public static class MySets{
        public HashMap<Node, List<Node>> setMap;
        public MySets(List<Node> nodes){
            for (Node cur:nodes){
                List<Node> set=new ArrayList<Node>();
                set.add(cur);
                setMap.put(cur,set);
            }
        }
        public boolean isSameSet(Node from,Node to){
            List<Node> fromSet=setMap.get(from);
            List<Node> toSet=setMap.get(to);
            return fromSet==toSet;
        }
        public void union(Node from,Node to){
            List<Node> fromSet=setMap.get(from);
            List<Node> toSet=setMap.get(to);
            for (Node toNode:toSet){
                fromSet.add(toNode);
                setMap.put(toNode,fromSet);
            }
        }
    }
}
