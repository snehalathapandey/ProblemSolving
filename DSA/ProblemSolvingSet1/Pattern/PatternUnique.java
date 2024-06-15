package DSA.ProblemSolvingSet1.Pattern;

import java.util.Scanner;

public class PatternUnique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
      //  uniquePattern(n);
        //uniquePattern2(n);
        uniquePattern3(n);
    }
    /*
                       *
                    *     *
                 *           *
                    *     *
                       *
     */
    public static void uniquePattern(int n) {
        for (int i = 1; i <= 2*n-1; i++) {
            int space=i<n?n-i:i-n;
            int star=i<n?i:n-(i-n);
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=star; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    /*
             * * * * *
              * * * *
               * * *
                * *
                 *
                * *
               * * *
              * * * *
             * * * * *
     */
    public static void uniquePattern2(int n) {
        for (int i = 1; i <= 2*n-1; i++) {
            int space=i<=n?i-1:n-(i-n+1);
            int star=i<=n?n-i+1:i-n+1;
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <=star; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    /*
                                1
                               1 1
                             1  2  1
                           1   3  3  1
                         1   4  6   4  1
                        1  5  10  10  4  1

     */
    public static void uniquePattern3(int n) {
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
              int mid=1;
            if(i>1){
                mid=(i+1)/2;
            }
            int j=1;
            for (j=1 ;j<=mid;j++){
                int x= j;
                x= factorial(x);
                System.out.print(x+" ");
            }
            for ( j=mid ;j>0;j--){
                int x= j;
                x= factorial(x);
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    public static int factorial(int j){
        int fac=1;
        while (j>1) {
            fac*=j--;

        }
        return fac;
    }
}
