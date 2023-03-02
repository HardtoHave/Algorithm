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
    public static class ReturnData{
        public boolean isBST;
        public int min;
        public int max;

        public ReturnData(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public static ReturnData process(Node x){
        if (x==null){
            return null;
        }
        ReturnData leftData=process(x.left);
        ReturnData rightData=process(x.right);
        boolean isBST=true;
        int min=x.value;
        int max=x.value;
        if (leftData!=null){
            min=Math.min(min, leftData.min);
            max=Math.max(max, leftData.max);
        }
        if (rightData!=null){
            min=Math.min(min, rightData.min);
            max=Math.max(max, rightData.max);
        }
        if (leftData!=null && (!leftData.isBST || leftData.max<x.value)){
            isBST=false;
        }
        if (rightData!=null && (!rightData.isBST || rightData.min>x.value)){
            isBST=false;
        }
        return new ReturnData(isBST,min,max);
    }
    public static boolean isCBT(Node head){
        if (head==null){
            return true;
        }
        LinkedList<Node> queue=new LinkedList<>();
        boolean leaf=false;
        Node l;
        Node r;
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
