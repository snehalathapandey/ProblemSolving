package DSA.ProblemSolvingSet1.Pattern;

import java.util.Scanner;

public class PatternWithStar {

    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     patternWithStar(n);
     patternwithNumber(n);
        pattern(n);
        patternWithStarLeft(n);
    }
    /*
                 *
                * *
               * * *
              * * * *
             * * * * *
    * */
    public static void patternWithStar(int n) {
        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

     /*
                 1
               1   2
             1   2   3
           1   2   3    4
      */
        public static void patternwithNumber(int n){
            for (int i= 1;i<=n;i++){
                for(int j=1;j<=n - i;j++){
                    System.out.print(" ");
                }
                for(int j=1; j<= i; j++){
                    System.out.print(j+" ");
                }
                System.out.println();
            }
        }
        /*
                  1
                2    2
              3   3    3
            4   4    4    4

         */
    public static void pattern(int n){

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

   /*
           *
           * *
           * * *
           * * * *
    */

 public static void patternWithStarLeft(int n){
     for(int i=1;i<=n;i++){
         for(int j=1;j<=i;j++){
             System.out.print("*"+" ");
         }
         System.out.println();
     }
 }
 /*
                 *
               * *
             * * *
  */
    public static void patternWithStarRight(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
        }
    }
}
