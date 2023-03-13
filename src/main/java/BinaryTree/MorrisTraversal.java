package BinaryTree;

public class MorrisTraversal {
    private static class Node{
        public int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void process(Node head){
        if (head==null){
            return;
        }
        //1
        process(head.left);
        //2
        process(head.right);
        //3
    }
    public static void morris(Node head){
        if (head==null){
            return;
        }
        Node cur=head;
        Node mostRight;
        while (cur!=null){
            mostRight=cur.left;
            if (mostRight!=null){
                while (mostRight.right!=null&&mostRight.right!=cur){
                    mostRight=mostRight.right;
                }
                if (mostRight.right==null){
                    mostRight.right=cur;
                    cur=cur.left;
                    continue;
                }else {
                    mostRight.right=null;
                }
            }
            cur=cur.right;
        }
    }
}
