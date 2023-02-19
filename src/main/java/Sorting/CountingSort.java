package Sorting;

public class CountingSort {
    public static void countingSort(int[] arr,int maxVal){
        int n= arr.length;
        int[] counts=new int[maxVal+1];
        // Count the occurrences of each value in the input array
        for (int i = 0; i < n; i++) {
            counts[arr[i]]++;
        }

        // Compute the prefix sum of the counts array
        for (int i = 1; i <= maxVal; i++) {
            counts[i] += counts[i - 1];
        }

        // Allocate a new array to hold the sorted output
        int[] sorted = new int[n];

        // Build the sorted output array by reading the input array in reverse order
        for (int i = n - 1; i >= 0; i--) {
            int val = arr[i];
            int index = counts[val] - 1;
            sorted[index] = val;
            counts[val]--;
        }

        // Copy the sorted output array back into the input array
        for (int i = 0; i < n; i++) {
            arr[i] = sorted[i];
        }
    }
}
