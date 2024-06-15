package DSA.ProblemSolvingSet1.Pattern;

import java.util.Scanner;

public class Pattern1 {
    /*
    Write java program to create pyramid of numbers like
    in Pattern1
        ****************************
        *                          *
        *                          *
        *                          *
        *                          *
        *                          *
        *                          *
        *                          *
        *                          *
        *                          *
        ****************************

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("How Many Rows You Want in Your Pyramid?");

        int n = sc.nextInt();
        System.out.println("How Many Columns You Want in Your Pyramid?");
        int m = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if((i==1 ||i==n)&& j<=m) {
                    System.out.print("*");
                }
                if((j==1 ||(j==m))&&i<=n) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }




    }

}
