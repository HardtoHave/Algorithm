package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    public static HashMap<Node,Integer> dijkstra(Node head){
        HashMap<Node,Integer> distanceMap= new HashMap<>();
        distanceMap.put(head,0);
        HashSet<Node> selectNodes=new HashSet<>();
        Node minNode=getMinDistanceAndUnselectedNode(distanceMap,selectNodes);
        while (minNode!=null){
            int distance=distanceMap.get(minNode);
            for (Edge edge: minNode.edges){
                Node toNode=edge.to;
                if (!distanceMap.containsKey(toNode)){
                    distanceMap.put(toNode,distance+edge.weight);
                }
                distanceMap.put(edge.to,Math.min(distanceMap.get(toNode),distance+edge.weight));
            }
            selectNodes.add(minNode);
            minNode=getMinDistanceAndUnselectedNode(distanceMap,selectNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(HashMap<Node, Integer> distanceMap, HashSet<Node> selectNodes) {
        Node minNode=null;
        int minDistance=Integer.MAX_VALUE;
        for (Map.Entry<Node,Integer> entry:distanceMap.entrySet()){
            Node node=entry.getKey();
            int distance=entry.getValue();
            if (!selectNodes.contains(node)&&distance<minDistance){
                minNode=node;
                minDistance=distance;
            }
        }

        return minNode;
    }
}
