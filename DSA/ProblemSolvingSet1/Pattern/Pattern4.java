package DSA.ProblemSolvingSet1.Pattern;

import java.util.Scanner;

public class Pattern4 {
    /* *
                1
              1 2 1
            1 2 3 2 1
          1 2 3 4 3 2 1
        1 2 3 4 5 4 3 2 1
      1 2 3 4 5 6 5 4 3 2 1
    1 2 3 4 5 6 7 6 5 4 3 2 1
  1 2 3 4 5 6 7 8 7 6 5 4 3 2 1
1 2 3 4 5 6 7 8 9 8 7 6 5 4 3 2 1

    * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int row = 1; row<=n; row++) {

            for (int col = n; col> row; col--) {
                System.out.print("  ");
            }

            for (int col = 1; col<=row; col++) {
                System.out.print(col + " ");
            }
            for (int col = row-1; col>=1; col--) {
             System.out.print(col+" ");
         }
            System.out.println();
        }
    }
}
