package Recursion;

public class RecursionExample {
    public static void main(String[] args) {
        //    printBinary(13);
//        printPrimeNumerFromNTo1(5);
//        printPrimeNumerFrom1Ton(5);
//        System.out.println(fact(5));
//        System.out.println(fabinaco(3));
        //  System.out.println(sumOfNaturalNumber(3));
        //System.out.println(isPalidrome("ababa", 0, "ababa".length() - 1));
        //System.out.println(sumOfDigit(9987));
        // System.out.println(digitalRoot(27640));
        //System.out.println(maxPieces(5,2,1,5));
        printSubsetString("ABC","",0);

    }

    public static void printBinary(int n) {
        if (n == 0) {
            return;
        }
        printBinary(n / 2);
        System.out.print(n % 2);

    }

    public static void printPrimeNumerFromNTo1(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printPrimeNumerFromNTo1(n - 1);
    }

    public static void printPrimeNumerFrom1Ton(int n) {
        if (n == 0) {
            return;
        }
        printPrimeNumerFrom1Ton(n - 1);
        System.out.println(n);
    }

    public static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static int fabinaco(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fabinaco(n - 1) + fabinaco(n - 2);
    }

    public static int sumOfNaturalNumber(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumOfNaturalNumber(n - 1);
    }

    public static boolean isPalidrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        return (s.charAt(start) == s.charAt(end)) && isPalidrome(s, start + 1, end - 1);
    }

    public static int sumOfDigit(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigit(n / 10);

    }

    public static int digitalRoot(int n) {
        int digitsum = sumOfDigit(n);
        // add your code here
        while (digitsum / 10 != 0) {
            digitsum = sumOfDigit(digitsum);
        }
        return digitsum;
    }

    public static int maxPieces(int n, int a, int b, int c) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return -1;
        }
        int res = Math.max(maxPieces(n - a, a, b, c), Math.max(maxPieces(n - b, a, b, c), maxPieces(n - c, a, b, c)));
        if (res == -1) {
            return -1;
        }
        return res + 1;
    }

    public static void printSubsetString(String s, String current, int i) {

        if(i==s.length()){
            System.out.println(current);
            return;
        }
        printSubsetString(s, current, i + 1);
        printSubsetString(s, current + s.charAt(i), i + 1);
    }

    public static void TOH(int n){

    }
}
