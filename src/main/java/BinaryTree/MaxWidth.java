package BinaryTree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void width(Node head){
        if (head==null){
            return;
        }
        Queue<Node> queue=new LinkedList<>();
        HashMap<Node,Integer> levelMap=new HashMap<>();
        levelMap.put(head,1);
        queue.add(head);
        int curLevel=1;
        int curLevelNodes=0;
        int maxLevelNodes=Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Node cur=queue.poll();
            int curNodeLevel=levelMap.get(cur);
            if (curNodeLevel==curLevel){
                curLevelNodes++;
            }else {
                maxLevelNodes= Math.max(maxLevelNodes,curLevelNodes);
                curLevel++;
                curLevelNodes=1;
            }
            //System.out.print(cur.value);
            if (cur.left!=null){
                levelMap.put(cur.left,curNodeLevel+1);
                queue.add(cur.left);
            }
            if (cur.right!=null){
                levelMap.put(cur.right,curNodeLevel+1);
                queue.add(cur.right);
            }
        }
    }
}
