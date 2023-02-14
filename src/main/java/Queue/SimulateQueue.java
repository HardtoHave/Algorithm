package Queue;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The SimulateQueue has defect that can't really remove data from queue
 * That method just remove index
 */
public class SimulateQueue {
    public static void main(String[] args) {
        //instance
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        char k=' ';
        //output menu
        boolean loop=true;
        while (loop){
            System.out.println("s(show)");
            System.out.println("e(exit)");
            System.out.println("a(add)");
            System.out.println("g(get)");
            System.out.println("h(head)");
            k=scanner.next().charAt(0);
            switch (k){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    loop=false;
                    scanner.close();
                    break;
                case 'a':
                    System.out.println("input a number: ");
                    int value=scanner.nextInt();
                    arrayQueue.enqueue(value);
                    break;
                case 'g':
                    try {
                        int result=arrayQueue.dequeue();
                        System.out.println("the result is "+result);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int head=arrayQueue.showHead();
                        System.out.println("the result is "+head);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
class ArrayQueue{
    private int maxSize;
    private int front;//Queue head
    private int rear;//Queue tail
    private int[] arr;//array used to store data, simulate queue

    //initialize
    public ArrayQueue(int arrMaxSize ){
        maxSize=arrMaxSize;
        arr=new int[maxSize];
        front=-1;
        rear=-1;
    }

    //determine whether queue is full
    public boolean isFull(){
        return rear==maxSize-1;
    }

    //determine whether queue is empty
    public boolean isEmpty(){
        return rear==front;
    }

    //add data to queue
    public void enqueue(int data){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }
        //rear move back
        rear++;
        //store data to the end of queue
        arr[rear]=data;
    }

    //remove data from queue
    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        //front move to the head
        front++;
        return arr[front];
    }

    //show all data from queue
    public void showQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

    //show head Queue
    public int showHead(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return arr[front+1];
    }
}
