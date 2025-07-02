package search;

public class LinearSearch {

    public static int linearSearch(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 4, 10, 40 };
        int x = 10;
        System.out.println("index of x: " + linearSearch(arr, x));
    }
}