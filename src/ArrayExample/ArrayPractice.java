package ArrayExample;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayPractice {

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        int[] c=b;
        //Arrays.stream(twoSum(a, 6)).forEach(System.out::println);
      //  System.out.println(findMedianSortedArrays(a,b));
     //   System.out.println(reverse(1534236469));
        c[0]=1;
        Arrays.stream(b).forEach(System.out::println);
        Arrays.stream(c).forEach(System.out::println);

    }

    public static int reverse(int x) {
        int max=(int)Math.pow(2,31)-1;
        int min=-(int)Math.pow(2,31);
        long reverse=(int)reverseInt(Math.abs(x));
        int sign=1;
        if(x<0){
            sign=-1;
        }

        if(reverse>max ||reverse<min){
            return 0;
        }
        return (int) reverse*sign;
    }

    public static long reverseInt(int x){
        long reverse=0;
        while(x>0){
            reverse=reverse*10+x%10;
            x=x/10;
        }
        return reverse;
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=mergeTwoSortedArray(nums1,nums2);
        double median=0;
        if(arr.length%2!=0){
            median=arr[arr.length/2];
            return median;
        }
        median=(double) (arr[(arr.length/2)-1]+arr[arr.length/2])/2;
        return median;
    }

    public static int[] mergeTwoSortedArray(int[] nums1,int[] nums2){
        int[] arr=new int[nums1.length+nums2.length];
        int i=0,j=0;
        int m1=nums1.length;
        int m2=nums2.length;
        int k=0;

        while(i<m1 && j<m2){
            if(nums1[i]<nums2[j]){
                arr[k++]=nums1[i];
                i++;
            }
            else{
                arr[k++]=nums2[j];
                j++;
            }
        }

        while(i<m1){
            arr[k++]=nums1[i];
            i++;
        }
        while(j<m2){
            arr[k++]=nums2[j];
            j++;
        }
        return arr;
    }
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        int a = 0, b = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            a = i;
            arr[0] = a;
            map.remove(nums[i]);
            if (map.containsKey(target - nums[i])) {
                b = map.get(target - nums[i]);
                arr[1] = b;
                break;
            }
            continue;
        }

        return arr;
    }
}
