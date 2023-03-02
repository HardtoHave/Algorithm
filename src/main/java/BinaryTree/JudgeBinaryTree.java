package BinaryTree;

import java.util.LinkedList;

public class JudgeBinaryTree {
    private static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static boolean isCBT(Node head){
        if (head==null){
            return true;
        }
        LinkedList<Node> queue=new LinkedList<>();
        boolean leaf=false;
        Node l=null;
        Node r=null;
        queue.add(head);
        while (!queue.isEmpty()){
            head=queue.poll();
            l=head.left;
            r=head.right;
            if ((l==null&&r!=null)||(leaf&&(l!=null||r!=null))){
                return false;
            }
            if (l!=null){
                queue.add(l);
            }
            if (r!=null){
                queue.add(r);
            }
            if (l==null||r==null){
                leaf=true;
            }
        }
        return true;
    }
}
