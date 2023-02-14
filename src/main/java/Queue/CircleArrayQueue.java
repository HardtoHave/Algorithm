package Queue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        //instance
        CircleQueue circleQueue = new CircleQueue(3);
        Scanner scanner = new Scanner(System.in);
        char k;
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
                    circleQueue.showQueue();
                    break;
                case 'e':
                    loop=false;
                    scanner.close();
                    break;
                case 'a':
                    System.out.println("input a number: ");
                    int value=scanner.nextInt();
                    circleQueue.enqueue(value);
                    break;
                case 'g':
                    try {
                        int result=circleQueue.dequeue();
                        System.out.println("the result is "+result);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        int head=circleQueue.showHead();
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
class CircleQueue{
    private int front;//Queue head
    private int rear;//Queue tail
    private final int[] arr;//array used to store data, simulate queue
    private int size;//current queue size

    //initialize
    public CircleQueue(int arrMaxSize ){
        arr=new int[arrMaxSize];
        front=0;
        rear=-1;
        size=0;
    }

    //determine whether queue is full
    public boolean isFull(){
        return size==arr.length;
    }

    //determine whether queue is empty
    public boolean isEmpty(){
        return size==0;
    }

    //add data to queue
    public void enqueue(int data){
        if (isFull()){
            System.out.println("Queue is full");
            return;
        }
        //rear move back
        rear=(rear+1)%arr.length;
        //add data
        arr[rear]=data;
        size++;
    }


    //remove data from queue
    public int dequeue(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        int value=arr[front];
        front=(front+1)%arr.length;
        size--;
        return value;
    }

    //show all data from queue
    public void showQueue(){
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        for (int i = front; i <=rear ; i++) {
            System.out.print(arr[i]+"");
        }
        System.out.println();
    }

    //show head Queue
    public int showHead(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }
}