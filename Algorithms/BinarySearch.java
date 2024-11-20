package Algorithms;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int left = 0; // Start of the search range
        int right = arr.length - 1; // End of the search range

        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid; // Target found, return the index
            }

            // If target is greater, ignore the left half
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                // If target is smaller, ignore the right half
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;

        int result = binarySearch(sortedArray, target);
        if (result != -1) {
            System.out.println("Target " + target + " found at index: " + result);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}
