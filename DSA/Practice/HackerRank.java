package DSA.Practice;

import org.junit.Test;

import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class HackerRank {

    @Test
    public  void plusMinus() {

        List<Integer> arr= Arrays.asList(0,0,-1,1,1);
        double positive=arr.stream().filter(i->i>0).count();
        double negative=arr.stream().filter(i->i<0).count();
        double zeros=arr.stream().filter(i->i==0).count();
        System.out.println(positive/arr.size());
        System.out.println(negative/arr.size());
        System.out.println(zeros/arr.size());

    }
@Test
    public  void miniMaxSum() {
        List<Integer> arr=Arrays.asList(1,2,3,4,5);
        BigInteger sum= BigInteger.valueOf(arr.stream().mapToLong(Integer::intValue).sum());

        BigInteger min=BigInteger.valueOf(arr.stream().min(Comparator.naturalOrder()).get());
        BigInteger max=BigInteger.valueOf(arr.stream().max(Comparator.naturalOrder()).get());
        System.out.println((sum.subtract(max))+" "+(sum.subtract(min)));

    }

    @Test
    public void  lonelyinteger() {
        List<Integer> a=Arrays.asList(1,1,2);
        List<Integer> unique=a.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(x->x.getValue()<2).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(unique.get(0));
    }
    @Test
    public  void diagonalDifference() {
        Integer[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        List<List<Integer>> arr= Arrays.asList(matrix).stream().map(
                                                      row->Arrays.asList(row).stream().collect(Collectors.toList())
        ).collect(Collectors.toList());

        int first=0,second=0;
        for(int i=0;i<arr.size();i++){
            first+=arr.get(i).get(i);
            second+=arr.get(i).get(arr.size()-1-i);
        }
        System.out.println( Math.abs(first-second));
    }

    @Test
    public void countingSort() {
        List<Integer> arr=Arrays.asList(1,1,3,2,2,1);
        int val=arr.stream().max(Comparator.naturalOrder()).orElse(0);
        System.out.println("max "+val);
        Map<Integer,Long> list= arr.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
        System.out.println(list+" "+list.size());
        List<Integer> ls=new ArrayList<>();

        for(int i=0;i<=(val);i++){

            Long l= list.getOrDefault(i, 0L);

            ls.add(l.intValue());
        }
        System.out.println(ls+" "+ls.size());


    }
}

