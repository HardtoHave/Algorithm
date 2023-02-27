package Search;

public class DichotomousSearch {
    public static int dichotomousSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // target not found
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int result = dichotomousSearch(arr, target);

        if (result == -1) {
            System.out.println("Target not found");
        } else {
            System.out.println("Target found at index " + result);
        }
    }
}
