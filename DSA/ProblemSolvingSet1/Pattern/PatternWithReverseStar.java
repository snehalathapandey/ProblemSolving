package DSA.ProblemSolvingSet1.Pattern;

import java.util.Scanner;

public class PatternWithReverseStar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        patternInReverse(n);
        patternInReverse2(n);
        patternInReverse3(n);
        patternInReverse4(n);
        patternInReverse5(n);
    }
    /*
            * * * * *
             * * * *
              * * *
               * *
                *

    */
    private static void patternInReverse(int n) {
        for (int i=n; i>0; i--) {
            for (int j=0; j<n-i; j++) {
                System.out.print(" ");
            }
            for (int j=i; j>0; j--) {
                System.out.print("*"+" ");
            }

            System.out.println();
        }
    }
    /*
           5 5 5 5 5
            4 4 4 4
             3 3 3
              2 2
               1
     */
   private static void patternInReverse2(int n) {
       for (int i=n; i>0; i--) {
           for (int j=0; j<n-i; j++) {
               System.out.print(" ");
           }
           for (int j=i; j>0; j--) {
               System.out.print(i+" ");
           }
           System.out.println();
       }
   }
   /*
                  5 4 3 2 1
                   4 3 2 1
                    3 2 1
                     2 1
                      1
    */
   private static void patternInReverse3(int n) {
       for (int i=n; i>0; i--) {
           for (int j=0; j<n-i; j++) {
               System.out.print(" ");
           }
           for (int j=i; j>0; j--) {
               System.out.print(j+"  ");
           }
           System.out.println();
       }
   }
   /*
      * * *
      * *
      *
    */
    private static void patternInReverse4(int n) {
        for (int i=n; i>0; i--) {
            for (int j=0; j<i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    /*
        * * *
          * *
            *
     */
    private static void patternInReverse5(int n) {
        for (int i=n; i>=1; i--) {
            for (int j=n; j>i; j--) {
                System.out.print(" ");
            }
            for (int j=1; j<=i; j++) {
                System.out.print("*");

            }

            System.out.println();
        }
    }
}
