package BasicAlgorithm;

public class DivideAndConquer {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,11};
        int result=findMax(arr);
        System.out.println(result);
    }
    public static int findMax(int[] arr) {
        return findMaxHelper(arr, 0, arr.length-1);
    }

    private static int findMaxHelper(int[] arr, int start, int end) {
        if (start == end) {
            return arr[start];  // base case: one element in array
        } else {
            int mid = (start + end) / 2;  // divide the array into two halves
            int leftMax = findMaxHelper(arr, start, mid);  // find the maximum element in the left half
            int rightMax = findMaxHelper(arr, mid+1, end);  // find the maximum element in the right half
            return Math.max(leftMax, rightMax);  // take the larger of the two maximum elements
        }
    }

}
