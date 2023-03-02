package BinaryTree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class RecursiveTraversal {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }
    public static void preOrderRecursive(Node head){
        if (head==null){
            return;
        }
        HashSet<Character> temp=new HashSet();
        System.out.print(head.value);
        preOrderRecursive(head.left);
        preOrderRecursive(head.right);
    }
    public static void inOrderRecursive(Node head){
        if (head==null){
            return;
        }
        inOrderRecursive(head.left);
        System.out.print(head.value);
        inOrderRecursive(head.right);
    }
    public static void posOrderRecursive(Node head){
        if (head==null){
            return;
        }
        posOrderRecursive(head.left);
        posOrderRecursive(head.right);
        System.out.print(head.value);
    }
    public static void preOrderUnRecursive(Node head){
        if (head!=null){
            Stack<Node> stack=new Stack<Node>();
            stack.add(head);
            while (!stack.empty()){
                head=stack.pop();
                System.out.print(head);
                if (head.right!=null){
                    stack.push(head.right);
                }
                if (head.left!=null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }
    public static void inOrderUnRecursive(Node head){
        if (head!=null){
            Stack<Node> stack=new Stack<Node>();
            while (!stack.empty()||head!=null){
                if (head!=null){
                    stack.push(head);
                    head=head.left;
                }else {
                    head=stack.pop();
                    System.out.print(head.value);
                    head=head.right;
                }
            }
        }
        System.out.println();
    }

}
