package Sorting;

import java.util.Arrays;

public class SortingExample {
    public static void main(String[] args) {
        int a[] = {1, 0, 4, 10};
        //int b[] = {0, 2, 3, 10};
        // int c[] = new int[a.length + b.length];
        mergeSort(a, 0, a.length - 1);
        //bubbleSort(a);
        //   selectionSort(a);
        //InsertionSort(a);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void mergeSort(int a[], int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    public static void merge(int a[], int low, int mid, int high) {

        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i = 0; i < n1; i++) {
            left[i] = a[i + low];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = a[mid + j + 1];
        }
        int k = low;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                a[k++] = left[i];
                i++;
            } else {
                a[k++] = right[j];
                j++;
            }
        }
        while (i < n1) {
            a[k++] = left[i];
            i++;
        }
        while (j < n2) {
            a[k++] = right[j];
            j++;
        }
    }

    public static void mergeTwoSortedArray(int temp[], int a[], int b[]) {
        int la = a.length;
        int lb = b.length;
        int k = -1;
        int i = 0;
        int j = 0;
        while (i < la && j < lb) {
            if (a[i] <= b[j]) {
                temp[++k] = a[i];
                i++;
            } else {
                temp[++k] = b[j];
                j++;
            }
        }
        while (i < la) {
            temp[++k] = a[i];
            i++;
        }
        while (j < lb) {
            temp[++k] = b[j];
            j++;
        }
    }

    public static void InsertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }

    public static void selectionSort(int a[]) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }

            }
            int temp = a[i];
            a[i] = a[min];
            a[min] = temp;
        }
    }

    public static void bubbleSort(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}