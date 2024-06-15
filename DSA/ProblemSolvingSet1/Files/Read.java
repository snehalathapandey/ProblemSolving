package DSA.ProblemSolvingSet1.Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Read {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = input.nextLine();
        File file = new File(fileName);
        Scanner scanner=new Scanner(file);
        Long count= 0L;
        while(scanner.hasNext()){
            String data= scanner.nextLine();
            HashMap<String,Long> st = (HashMap<String, Long>) Arrays.asList(data.split("")).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
              long cnt=Arrays.asList(data.split("")).stream().count();

              count+=cnt;
            System.out.println(count+" count ");
            System.out.println(data+" data ");

            String sample=Arrays.asList(data.split("")).stream().collect(Collectors.collectingAndThen(Collectors.toList(),list->{
                Collections.reverse(list);
                return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
            }));
            System.out.println(count+"  Total count ");
        }
        scanner.close();
    }
}
