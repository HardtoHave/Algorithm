package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstruct {
    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static String serialByPre(Node head){
        if (head==null){
            return "#_";
        }
        String res=head.value+"_";
        res+=serialByPre(head.left);
        res+=serialByPre(head.right);
        return res;
    }
    public static Node reconByPreString(String preStr){
        String[] values=preStr.split("_");
        Queue<String> queue=new LinkedList<>();
        for (int i = 0; i != values.length; i++) {
            queue.add(values[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value=queue.poll();
        if (value.equals("#")){
            return null;
        }
        Node head=new Node(Integer.valueOf(value));
        head.left=reconPreOrder(queue);
        head.right=reconPreOrder(queue);
        return head;
    }
}
