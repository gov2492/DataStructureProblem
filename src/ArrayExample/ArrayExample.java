package ArrayExample;

import java.util.ArrayList;
import java.util.List;

public class ArrayExample {

    public static void main(String[] args) {
        int[] a = {1, 30, 2, 10, 5};
        int[] b = {10, 10, 20, 30, 40, 50, 60, 60};

        //  System.out.println(largestNumber(a));
        //System.out.println(secondLargest(a));
        //reverseArray(a);
//        System.out.println(removeDuplicateFromSortedArray(a));
//        System.out.println(removeDuplicateFromSortedArray1(a));
        // moveZeroAtEnd1(a);
        // rotateByD1(a, 3);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + ",");
//        }
        // rotateLeft(4, Arrays.stream(a).boxed().collect(Collectors.toList())).forEach(System.out::println);
        // System.out.println(BinarySearch1(b, 100, 0, b.length - 1));
//        System.out.println(firstOccurance(b, 10));
//        System.out.println(lastOccurance(b,60));
       // System.out.println(countOccurance(b, 60));
        int[] c = {4,5,6,7,0,1,2};
        System.out.println(search(c,0));
    }
    public static int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;

        while(start<end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[start]<nums[mid]){
                if(target>=nums[start] && target<nums[mid]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else {
                if(target>nums[mid]&&target<=nums[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
    public static int sqrt(int x) {
        int low = 1;
        int high = x;
        int ans=-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int sqrt = mid * mid;
            if (sqrt == x) {
                return mid;
            } else if (sqrt > x) {
                high = mid - 1;
            } else {
                low = mid+1;
                ans=mid;
            }
        }
        return ans;
    }

    public static int countOccurance(int a[], int x) {
        int firstOccurence = firstOccurance(a, x);
        int lastOccurance = lastOccurance(a, x);
        if (firstOccurence == -1) {
            return 0;
        }
        return (lastOccurance - firstOccurence) + 1;
    }

    public static int countoneInBinaryArray(int a[], int x) {
        int firstOccurence = firstOccurance(a, 1);
        int lastOccurance = lastOccurance(a, 1);
        if (firstOccurence == -1) {
            return 0;
        }
        return (lastOccurance - firstOccurence) + 1;
    }

    public static int firstOccurance(int a[], int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > x) {
                high = mid - 1;
            } else if (a[mid] < x) {
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid] != a[mid - 1]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int lastOccurance(int a[], int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] > x) {
                high = mid - 1;
            } else if (a[mid] < x) {
                low = mid + 1;
            } else {
                if (mid == a.length - 1 || a[mid] != a[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int largestNumber(int[] a) {
        int largest = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largest]) {
                largest = i;
            }
        }
        return largest;
    }

    public static int secondLargest(int[] a) {
        int result = -1;
        int largest = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > a[largest]) {
                result = largest;
                largest = i;
            } else if (a[i] != a[largest]) {
                if (a[i] > a[result] || result == -1) {
                    result = i;
                }
            }
        }
        return result;
    }

    public static boolean isSorted(int[] a) {
        boolean isSorted = true;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                isSorted = false;
                break;
            }
        }
        return isSorted;
    }

    public static void reverseArray(int[] a) {
        int start = 0;
        int end = a.length - 1;
        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start = start + 1;
            end = end - 1;
        }
    }

    public static int removeDuplicateFromSortedArray(int[] a) {

        int[] temp = new int[a.length];
        temp[0] = a[0];
        int size = 1;
        for (int i = 1; i < a.length; i++) {
            if (temp[size - 1] != a[i]) {
                temp[size] = a[i];
                size++;
            }
        }
        return size;
    }

    public static int removeDuplicateFromSortedArray1(int[] a) {

        int size = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[size - 1] != a[i]) {
                a[size] = a[i];
                size++;
            }
        }
        return size;
    }

    public static void moveZeroAtEnd(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                int temp = a[i];
                int j = i;
                for (; j < a.length - 1; j++) {
                    a[j] = a[j + 1];
                }
                a[j] = temp;
            }
        }
    }

    public static void moveZeroAtEnd1(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                int temp = a[i];
                a[i] = a[count];
                a[count] = temp;
                count++;
            }
        }
    }

    public static void rotateByOne(int[] a) {
        int temp = a[0];
        int i = 0;
        for (; i < a.length - 1; i++) {
            a[i] = a[i + 1];
        }
        a[i] = temp;
    }

    public static void rotateByD(int[] a, int d) {
        int[] temp = new int[d];

        for (int i = 0; i < d; i++) {
            temp[i] = a[i];
        }
        for (int i = d; i < a.length; i++) {
            a[i - d] = a[i];
        }
        for (int i = 0; i < d; i++) {
            a[a.length - d + i] = temp[i];
        }
    }

    public static void rotateByD1(int[] a, int d) {
        reverseArray(a, 0, d - 1);
        reverseArray(a, d, a.length - 1);
        reverseArray(a, 0, a.length - 1);
    }

    private static void reverseArray(int[] a, int low, int high) {
        while (low < high) {
            int temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            low++;
            high--;
        }
    }

    public static int BinarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == x) {
                return mid;
            }
            if (a[mid] > x) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int BinarySearch1(int a[], int x, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == x) {
                return mid;
            } else if (a[mid] > x) {
                return BinarySearch1(a, x, low, mid - 1);
            } else {
                return BinarySearch1(a, x, mid + 1, high);
            }
        }
        return -1;
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> temp = new ArrayList<Integer>(d);
        int n = arr.size();
        for (int i = 0; i < d; i++) {
            temp.add(arr.get(i));
        }
        for (int i = d; i < n; i++) {
            arr.add((i - d), arr.get(i));
            arr.remove(i);
        }
        for (int i = 0; i < d; i++) {
            arr.remove(n - d + i);
            arr.add((n - d + i), temp.get(i));
        }
        return arr;
    }
}