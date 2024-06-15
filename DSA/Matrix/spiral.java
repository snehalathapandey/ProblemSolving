package DSA.Matrix;

import org.junit.Test;

public class spiral {
    @Test
    public void test1(){
        int[][] a={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int row=a[0].length;
        int col=a.length;
        System.out.println(row+" "+col);
        spiral(row,col,a);
    }

    public void spiral(int row,int col,int[][] a){
        int rowstart=0,rowend=row;
        int colstart=0,colend=col;
        while (rowstart<row && colstart<col){
            for (int i=0;i<row;i++){
                
            }
        }
    }
}
