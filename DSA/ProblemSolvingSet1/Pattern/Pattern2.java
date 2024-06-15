package DSA.ProblemSolvingSet1.Pattern;

import java.util.Scanner;

public class Pattern2 {
    /**
               1
              1 2
             1 2 3
            1 2 3 4
           1 2 3 4 5
    **/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int col=(2*n)-1;
        int row=n;
        int count=1;
        for (int i=row;i>0;i--) {

                 for (int j=1;j<=i;j++) {
                     System.out.print(" ");

                 }
                 for (int j=1;j<=count;j++) {
                     System.out.print(j+" ");
                 }
            System.out.println();
                 count++;
        }
    }
}
