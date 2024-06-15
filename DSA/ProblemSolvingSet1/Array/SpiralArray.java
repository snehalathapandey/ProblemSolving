package DSA.ProblemSolvingSet1.Array;

import java.util.Scanner;

public class SpiralArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        spiralArray(n);
    }
    public static void spiralArray(int n) {
        int[][] matrix = new int[n][n];
        int row = 0,rowEnd = n-1; int col = 0,colEnd = n-1;
        int count=1;
        while (row<=rowEnd && col<=colEnd) {
            for (int i = col; i <=colEnd; i++) {
                matrix[row][i] = count++;
            }
            row+=1;
            for (int i = row; i <= rowEnd; i++) {
                matrix[i][colEnd] = count++;
            }
            colEnd-=1;
            for (int i=colEnd; i>=col; i--) {
                matrix[rowEnd][i] = count++;
            }
            rowEnd-=1;
            for (int i=rowEnd; i>=row; i--) {
                matrix[i][col] = count++;
            }
            col+=1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }

    }
}
