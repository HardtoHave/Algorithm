package BinaryTree;

public class SuccessorNode {
    private static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value, Node left, Node right, Node parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        Node parent;
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
        }
        return parent;
    }
    public static Node getLeftMost(Node node){
        if (node==null){
            return null;
        }
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
}
