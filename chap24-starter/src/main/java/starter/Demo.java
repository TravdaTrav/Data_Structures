package starter;

import java.util.Arrays;

public class Demo {

  /**
   * Sorts the input arr.
   * @param arr an array of integers.
   */
  public static void mergesort(int[] arr) {
    mergesort(arr, 0, arr.length);
  }

  // Pre: left and right are valid indices such that
  //        0 <= left <= right <= arr.length;
  // Post: arr[left] ... arr[right-1] is sorted.
  private static void mergesort(int[] arr, int left, int right) {
    if (right - left >= 2) {
      int mid = (left + right) / 2;
      mergesort(arr, left, mid);
      mergesort(arr, mid, right);
      merge(arr, left, mid, right);
    }
  }

  // Pre:
  //  1) left, mid and right are valid indices such that
  //        0 <= left <= mid < right <= arr.length;
  //  2) arr[left] ... arr[mid-1] is sorted
  //  3) arr[mid] ... arr[right-1] is sorted
  // Post: arr[left] ... arr[right-1] is sorted.
  private static void merge(int[] arr, int left, int mid, int right) {
    int[] c = new int[right - left];
    int l = left;
    int r = mid;

    for (int i = 0; i < right - left; i++) {
      if (r == right) {
        c[i] = arr[l++];
      } else if (l == mid) {
        c[i] = arr[r++];
      } else {
        if (arr[l] < arr[r]) {
          c[i] = arr[l++];
        } else {
          c[i] = arr[r++];
        }
      }
    }

    System.arraycopy(c, 0, arr, left, right - left);
  }

  /**
   * Demo starts here.
   * @param args command-line arguments.
   */
  public static void main(String[] args) {
    int[] arr = {5, 1, 3, 0, 8, 2, 4, 9};
    System.out.println("Input: " + Arrays.toString(arr));
    mergesort(arr);
    System.out.println("Output: " + Arrays.toString(arr));
  }
}