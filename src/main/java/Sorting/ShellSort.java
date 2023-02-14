package Sorting;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr={7,6,9,3,1,5,2,4};
        sort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static void sort(int[] arr){
        int n=arr.length;
        for (int gap = n/2; gap >0 ; gap=gap/2) {
            for (int i = gap; i < n; i++) {
                int temp=arr[i];
                int j;
                for (j = i; j >=gap&&arr[j-gap]>temp ; j-=gap) {
                    arr[j]=arr[j-gap];
                }
                arr[j]=temp;
            }
        }
    }
}
