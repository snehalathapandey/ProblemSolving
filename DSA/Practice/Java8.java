package DSA.Practice;

import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8 {
    @Test
    public void Evenodd(){
        //1) Given a list of integers, separate odd and even numbers?
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        Set<Map.Entry<Boolean,List<Integer>>> list= listOfIntegers.stream().collect(Collectors.partitioningBy(s->s%2==0)).entrySet();
        for (Map.Entry<Boolean,List<Integer>> entry:list){
            boolean flag=entry.getKey();
            if(flag==true){
                System.out.print("Even ");
            }else {
                System.out.print("Odd ");
            }
            List<Integer> value=entry.getValue();
            for (int i:value){
                System.out.print(i+" ");
            }
        }
        Set<Map.Entry<Boolean,List<Integer>>> list1=listOfIntegers.stream().collect(Collectors.partitioningBy(i->i%2==0)).entrySet();
    }
    @Test
    public void Evenodd1(){
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);
        IntStream.rangeClosed(0,listOfIntegers.size()).filter(i->i%2==0).forEach(System.out::print);
        System.out.println(" ");
        IntStream.rangeClosed(0,listOfIntegers.size()).filter(i->i%2!=0).forEach(System.out::print);
    }
    @Test
    public void removeDup(){
        //2) How do you remove duplicate elements from a list using Java 8 streams?
        //4) How do you find frequency of each element in an array or a list?
        List<String> list=Arrays.asList("Java", "Python", "C#", "Java", "Kotlin", "Python");
        Map<String,Long> ls=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(ls);
        Map.Entry<String,Long> col=list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(i->i.getValue()>1).max(Map.Entry.comparingByKey()).get();
        System.out.println("MAX "+col.getValue()+" key "+col.getKey());

        //15) Given a list of strings, sort them according to increasing order of their length?
        List<String> st=list.stream().distinct().toList().stream().sorted().toList();
        //6) Given a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?
        String sjoin=st.stream().collect(Collectors.joining(",","[","]"));
        st.stream().forEach(i-> System.out.print(i+" "));
        System.out.println(sjoin);
    }
    @Test
    public void freqString(){
        //3) How do you find frequency of each character in a string using Java 8 streams?
        String inputString = "Java Concept Of The Day";
       Map<String,Long> freq=Arrays.stream(inputString.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(freq);
        List<Character> freqchar=inputString.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(i->i.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(freqchar);
    }

    @Test
    public void revDouble(){
        //5) How do you sort the given list of decimals in reverse order?
        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
          decimalList.stream().sorted(Comparator.reverseOrder()).forEach(i->System.out.print(i+" "));
    }

    @Test
    public void maxInt(){
        //11) How do you get three maximum numbers and three minimum numbers from the given list of integers?
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);
        //8) Given a list of integers, find maximum and minimum of those numbers?
        System.out.println("min::");
        listOfIntegers.stream().sorted().limit(3).forEach(i-> System.out.print(i+" "));
        int min=listOfIntegers.stream().min(Comparator.naturalOrder()).get();
        System.out.println("max::");
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(i->System.out.print(i+" "));
        System.out.println("::");
        //7) From the given list of integers, print the numbers which are multiples of 5?
        listOfIntegers.stream().filter(i->i%5==0).sorted().forEach(i->System.out.print(i+" "));
    }

    @Test
    public void joinArray(){
        //10) How do you merge two unsorted arrays into single sorted array without duplicates?
        //9) How do you merge two unsorted arrays into single sorted array using Java 8 streams?
        int[] a=new int[]{1,4,3,5};
        int[] b=new int[]{7,6,3,9};
        int[] c=IntStream.concat(Arrays.stream(a),Arrays.stream(b)).distinct().sorted().toArray();

        //14) Find second largest number in an integer array?
        Integer secmax= Arrays.stream(c).sorted().skip(Math.max(0,c.length-2)).findFirst().orElseThrow();
        Integer secmin= Arrays.stream(c).sorted().skip(1).findFirst().orElseThrow();
        System.out.println(secmax+" "+secmin);
        System.out.println(Arrays.toString(c));
    }
    @Test
    public void anagram(){
        //12) Java 8 program to check if two strings are anagrams or not?
        String s1="Racecar";
        String s2="carRace";
        s1= Stream.of(s1.split(" ")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        s2= Stream.of(s2.split(" ")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        if(s1.equals(s2)){
            System.out.println("String are anagram");
        }else {
            System.out.println("String is not anagram");
        }
    }
    @Test
    public void sumOfDigit(){
        //13) Find sum of all digits of a number in Java 8?
        int i= 156789;
        //Integer sum=Stream.of(String.valueOf(i).split("")).collect(Collectors.summingInt(Integer::parseInt));
       Integer sum=Arrays.asList(String.valueOf(i).split("")).stream().collect(Collectors.summingInt(Integer::parseInt));
        System.out.println(sum);
    }
    @Test
    public void sumAvg(){
        //16) Given an integer array, find sum and average of all elements?
        int[] a = new int[] {45, 12, 56, 15, 24, 75, 31, 89};
        int sum=Arrays.stream(a).sum();
        System.out.println(sum);

        double avg=Arrays.stream(a).average().getAsDouble();
        System.out.println(avg);

        //17) How do you find common elements between two arrays?
        List<Integer> list1 = Arrays.asList(71, 21, 34, 89, 56, 28);
        List<Integer> list2 = Arrays.asList(12, 56, 17, 21, 94, 34);
        //list1.stream().filter(list2::contains).forEach(System.out::println);
        list1.stream().filter(i->list2.contains(i)).forEach(System.out::println);
        //19) How do you find sum of first 10 natural numbers?
        int sumNatural=IntStream.rangeClosed(1,11).sum();
        System.out.println("natural "+sumNatural);

        //20) Reverse an integer array
        int[] rev=IntStream.rangeClosed(1,a.length).map(i->a[a.length-i]).toArray();
        System.out.println(Arrays.toString(rev));

        //21) Print first 10 even numbers
        IntStream.rangeClosed(1,10).map(i->i*2).forEach(System.out::print);
    }

    @Test
    public void average(){
        //18) Reverse each word of a string using Java 8 streams?
        String str = "Java Concept Of The Day";
        String revStr=Arrays.stream(str.split(" ")).map(word->new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        System.out.println(revStr+":");

        String stre=Arrays.stream(str.split(" ")).collect(Collectors.collectingAndThen(Collectors.toList(),list ->{
            Collections.reverse(list);
            return list.stream().map(String::valueOf).collect(Collectors.joining(" "));
        }));
        System.out.println(stre+" : ");
       String s= Arrays.stream(str.split(" ")).collect(Collectors.collectingAndThen(Collectors.reducing((a,b)->a+b),Optional::get));
        System.out.println(s);
    }

    @Test
    public void fib(){
        //23) Palindrome program using Java 8 streams
        String str = "ROTATOR";
        boolean flag=IntStream.rangeClosed(1,str.length()/2).noneMatch(i->str.charAt(i)!=str.charAt(str.length()-i-1));
        System.out.println(flag);
    }

    @Test
    public void listOfNum(){
        //24) Given a list of strings, find out those strings which start with a number?
        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        listOfStrings.stream().filter(i->Character.isDigit(i.charAt(0))).forEach(System.out::println);
        //listOfStrings.stream().map(i->Character.isDigit(i.charAt(0))).collect(Collectors.toList());
    }

    @Test
    public void dupE(){
        List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
        List<Integer> list=listOfIntegers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(i->i.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList());
        list.stream().forEach(System.out::println);

        Set<Integer> unique=new HashSet<>();
        Set<Integer> st=listOfIntegers.stream().filter(i->!unique.add(i)).collect(Collectors.toSet());
        System.out.println(st);
    }

    @Test
    public void inputS(){
        String input="I Love Coding".replace("\\s","").toLowerCase();
        Set<String> st=new HashSet<>();
        Set<String> unique=Arrays.stream(input.split("")).filter(i->!st.add(i)).collect(Collectors.toSet());
        System.out.println(unique);

    }

   @Test
    public void fibi(){
        Stream.iterate(new int[]{0,1}, f-> new int[] {f[1],f[0]+f[1]}).limit(10).map(f->f[0]).forEach(i-> System.out.print(i+" "));
   }

   @Test
    public void oddnum(){
        Stream.iterate(new int[]{1,3},f->new int[] {f[1],f[1]+2}).limit(10).map(f->f[0]).forEach(i-> System.out.print(i+" "));
       System.out.println();
        Stream.iterate(new int[]{2,4},f->new int[]{f[1],f[1]+2}).limit(10).map(f->f[0]).forEach(i-> System.out.print(i+" "));
    }

    @Test
    public void lastE(){
        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");
       String val= listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get();
        System.out.println(val);
    }

    @Test
    public void findAge(){
        LocalDate DOB= LocalDate.of(1993,8,30);
        LocalDate today=LocalDate.now();
        System.out.println(ChronoUnit.YEARS.between(DOB,today));
    }

    @Test
    public  void findZigZagSequence(){
        int[] a={1,2,3,4,5,6,7};
        Arrays.sort(a);
        int temp1= a[((a.length-1)/2)];
        a[((a.length-1)/2)]=a[(a.length-1)];
        a[(a.length-1)]=temp1;

        IntStream.rangeClosed(0,((a.length/2)-2)).forEach(i->{
            if(a[i]>a[i+1]){
                int temp= a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        });

        IntStream.rangeClosed(((a.length/2)+1),(a.length-2)).forEach(i->{
            if(a[i]<a[i+1]){
                int temp= a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
            }
        });
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
            if(i<(a.length-1)){
                System.out.print(" ");
            }
        }

    }

    @Test
    public void towerBreakers() {
        int n=1,m=4;
        int a=0;
        if(((n)%2==0 || m==1)){
            a=2;
        }else{
            a=1;
        }
        System.out.println(a);
    }

    @Test
    public void caesarCipher(){
        String s="Hello_World";
        StringBuilder sb= new StringBuilder();
        int k=3;
        for(Character c:s.toCharArray()){
            if(Character.isUpperCase(c)){
             char cs=(char) ('A'+(c-'A'+k)%26);
             sb.append(cs);
            }
            else if(Character.isLowerCase(c)){
             char cs=(char)('a'+(c-'a'+k)%26);
             sb.append(cs);
            }else{
            sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
