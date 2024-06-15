package DSA.ProblemSolvingSet1.String;

import org.junit.Test;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseString {
    //1) How to reverse a string in Java?
    @Test
    public void test() {
   String s="I am crazy";
   System.out.println(reverseString8(s));
    }

    public String reverseString(String str) {
        String rev = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }
      return rev;
    }
    public String reverseString8(String str) {
        String rev = "";
       rev = Stream.of(str.split(" ")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
        System.out.println(rev +" reverse individual string");
       String s= IntStream.rangeClosed(1,str.length()).mapToObj(i->str.charAt(str.length()-i)).map(String::valueOf).collect(Collectors.joining());
      return s;
    }
}
