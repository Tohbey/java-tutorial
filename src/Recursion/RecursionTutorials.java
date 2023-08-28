package Recursion;

public class RecursionTutorials {

    public void openRussianDoll(int doll){
        if(doll == 1){
            System.out.println("All dolls are opened");
        }else {
            openRussianDoll(doll-1);
        }
    }

    public int powerOfTwo(int n){
        if(n==0){
            return 1;
        }else{
            return 2*powerOfTwo(n-1);
        }
    }

    public int factorial(int n){
        if (n < 0){
            return  -1;
        }
        if(n == 0 || n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }

    public int fibonacci(int n){
        if( n < 0){
            return -1;
        }
        if(n == 0 || n == 1){
            return n;
        }
        return fibonacci(n-1) + factorial(n-2);
    }

    public int sumOfDigits(int n){
        if(n < 0){
            return 0;
        }

        if(n < 9){
            return n;
        }
        return n%10 + sumOfDigits(n/10);
    }

    public int power(int base, int exp){
        if(exp < 0){
            return -1;
        }

        if(exp == 1){
            return base;
        }

        return base * power(base, exp -1);
    }

    // find GCD greatest common divisor using Eclidean Algorithm
    public int gcd(int a, int b){
        if(a < 0 || b < 0){
            return -1;
        }

        if (b == 0){
            return a;
        }
        return  gcd(b, a%b);
    }

    //convert a number from decimal to binary
    public int decimalToBinary(int n){
        if(n == 0){
            return 0;
        }

        return n%2 + 10*decimalToBinary(n / 2);
    }

    public int productOfArray(int A[], int N){
        if(N < 0){
            return -1;
        }
        if(N == 0){
            return A[N];
        }
        return A[N-1] * productOfArray(A, N-1);
    }

    public  int recursiveRange(int num){
        if(num < 0){
            return 0;
        }

        return num + recursiveRange(num-1);
    }

    public String reverse(String str) {
        if (str.isEmpty()){
            return str;
        }
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public  boolean isPalindrome(String s) {
        // if length is 0 or 1 then String is palindrome
        if(s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
            return isPalindrome(s.substring(1, s.length()-1));
        return false;
    }

    public static char first(String str) {
        if(str.isEmpty()) {
            return ' ';
        }
        if (Character.isUpperCase(str.charAt(0))) {
            return str.charAt(0);
        }else {
            return first(str.substring(1, str.length()));
        }
    }

}
