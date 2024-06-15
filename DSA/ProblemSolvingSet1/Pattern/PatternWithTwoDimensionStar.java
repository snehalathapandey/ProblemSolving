package DSA.ProblemSolvingSet1.Pattern;

import java.util.Scanner;

public class PatternWithTwoDimensionStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        pattern(n);
        pattern1(n);
        pattern2(n);
    }
    /*
                       *
                     *   *
                   *   *   *
                 *   *   *   *
                   *   *   *
                     *   *
                       *
     */
    private static void pattern(int n) {


        for (int i=1;i<=2*n-1;i++) {
            int space= i<=n?n-i:i-n;
            int star= i<=n ?i:n-(i-n);
            for (int j=1;j<=space;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=star;j++){
                System.out.print("*"+" ");
            }
            System.out.println();

        }
    }
    /*
                    1
                   2 2
                  3 3 3
                   2 2
                    1
     */
    private static void pattern1(int n) {

        for (int i=1;i<=2*n-1;i++) {
            int space= i<=n?n-i:i-n;
            int number= i<=n ?i:n-(i-n);
            for (int j=1;j<=space;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=number;j++){
                System.out.print(number+" ");
            }
            System.out.println();

        }
    }
    /*
                   1
                  1 2
                 1 2 3
                  1 2
                   1
     */
    private static void pattern2(int n) {

        for (int i=1;i<=2*n-1;i++) {
            int space= i<=n?n-i:i-n;
            int number= i<=n ?i:n-(i-n);
            for (int j=1;j<=space;j++){
                System.out.print(" ");
            }
            for (int j=1;j<=number;j++){
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }
}
