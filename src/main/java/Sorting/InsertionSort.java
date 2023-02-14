package Sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={3,2,4,5,2,1,6};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //get number from second position
            int key=arr[i];
            //compare between key and the number front of key
            int j=i-1;
            //if previous number is bigger then latter
            while (j>=0&&arr[j]>key){
                //then switch
                arr[j+1]=arr[j];
                j--;
            }
            //else keep same
            arr[j+1]=key;
        }
    }
}
