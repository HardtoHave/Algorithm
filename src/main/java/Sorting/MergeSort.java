package Sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={7,6,9,3,1,5,2,4};
        sort(arr,0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::print);
    }
    public static void sort(int[] arr,int low, int high){
        if (low<high){
            int mid=low+(high-low)/2;
            sort(arr,low,mid);
            sort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public static void merge(int[] arr,int low,int mid,int high){
        //merge into 2 parts
        int n1=mid-low+1;
        int n2=high-mid;
        //create 2 arrays which are left and right
        int[] left=new int[n1];
        int[] right=new int[n2];
        //assign the value
        for (int i = 0; i < n1; i++) {
            left[i]=arr[low+i];
        }
        for (int i = 0; i < n2; i++) {
            right[i]=arr[mid+1+i];
        }
        //sort
        int i=0,j=0;
        int k=low;
        while (i<n1&&j<n2){
            //assign value to arr
            if (left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }else {
                arr[k]=right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
