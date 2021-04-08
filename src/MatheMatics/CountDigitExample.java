package MatheMatics;

import java.util.ArrayList;
import java.util.List;

public class CountDigitExample {
    public static void main(String[] args) {
        int a = 1234567;
//        System.out.println(count(a));
//        System.out.println(isPalidrome(8));
//        System.out.println(fact(5));
//        System.out.println(new CountDigitExample().factRecursive(5));
//        System.out.println(findTrailingZero(10));
//        System.out.println(findTrailingZero1(10));
//        System.out.println(GCD4(100, 200));
//        System.out.println(GCD1(5, 4));
//        System.out.println(GCD2(5, 4));
//        System.out.println(GCD3(5, 4));
//        System.out.println(LCM1(2, 8));
//        System.out.println(LCM2(2, 8));
//        System.out.println(LCM3(2, 8));
//        System.out.println(isPrime1(5));
//        System.out.println(isPrime1(6));
//        System.out.println(Math.abs(34));
//        System.out.println(divisor1(100));
//        System.out.println(divisor2(100));
        System.out.println(LCMOFTHREENUMBER(3,5,6));


    }

    public static int count(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public static boolean isPalidrome(int n) {
        int rev = 0;
        int numb = n;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n = n / 10;
        }
        return rev == numb;
    }

    public static int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public int factRecursive(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factRecursive(n - 1);
    }

    public static int findTrailingZero(int n) {
        long fact = fact(n);
        int count = 0;
        while (fact % 10 == 0) {
            count++;
            fact = fact / 10;
        }
        return count;
    }

    public static int findTrailingZero1(int n) {
        long fact = fact(n);
        int count = 0;
        for (int i = 5; i <= n; i = i * 5) {
            count = count + n / i;
        }
        return count;
    }

    public static int GCD1(int a, int b) {
        int gcd = Math.min(a, b);
        while (gcd > 0) {
            if (a % gcd == 0 && b % gcd == 0) {
                break;
            }
            gcd--;
        }
        return gcd;
    }

    public static int GCD2(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int GCD3(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static int GCD4(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD4(b, a % b);
    }

    public static int LCM1(int a, int b) {
        int max = Math.max(a, b);
        int lcm = 0;
        int multiply = a * b;
        while (multiply >= max) {
            if (multiply % a == 0 && multiply % b == 0) {
                lcm = multiply;
            }
            multiply--;
        }
        return lcm;
    }

    public static int LCM2(int a, int b) {
        int max = Math.max(a, b);
        while (true) {
            if (max % a == 0 && max % b == 0) {
                break;
            }
            max++;
        }
        return max;
    }

    /* a*b=gcd(a,b)*lcm(a,b)*/
    public static int LCM3(int a, int b) {
        int gcd = GCD4(a, b);
        return (a * b) / gcd;
    }

    public static boolean isPrime1(int n) {
        boolean isPrime = true;
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    public static boolean isPrime2(int n) {
        boolean isPrime = true;
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                isPrime = false;
            }
        }
        return isPrime;
    }

    public static List<Integer> divisor1(int n) {
        List<Integer> li = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                li.add(i);
                if (i != n / i) {
                    li.add(n / i);
                }
            }
        }
        return li;
    }

    public static List<Integer> divisor2(int n) {
        List<Integer> li = new ArrayList<>();
        int i=1;
        for (i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                li.add(i);
            }
        }
        for (; i >= 1; i--) {
            if (n % i == 0) {
                li.add(n / i);
            }
        }
        return li;
    }

    public static int LCMOFTHREENUMBER(int a,int b, int c){
        int max=Math.max(a,Math.max(b,c));
        while(true){
            if(max%a==0 && max%b==0 && max%c==0){
                break;
            }
            max++;
        }
        return max;
    }

}
