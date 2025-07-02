package topk;

import java.util.*;

public class QuickSelect {

    private static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }
        int pivot = partition(nums, left, right);
        if (pivot == k) {
            return nums[pivot];
        }
        if (k < pivot) {
            return quickSelect(nums, left, pivot - 1, k);
        }
        return quickSelect(nums, pivot + 1, right, k);
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;
        for (int j = left; j < right; ++j) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                ++i;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Phan tu lon thu " + k + " la: " + findKthLargest(arr, k));
    }
}