package DSA.Euler;

import org.junit.Test;

import java.util.stream.IntStream;

public class Problem1 {
    @Test
    public void sumOf3or5(){
       
        int n=10;
        int Left=0;
        int Right=n-1;
        int sum=0;
        while (Left<Right){
            if(Left%5==0 || Left%3==0){
               sum+=Left;
            }
            if(Right%5==0 || Left%3==0){
                sum+=Right;
            }
            Left++;Right--;
        }
        System.out.println(sum);
    }
}
