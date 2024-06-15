package DSA.Practice;

import DSA.Practice.Notes;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class java8set {
    //1.Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
    @Test
    public void listEvenOdd(){
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
        list.stream().filter(i->i%2==0).forEach(i->{
            System.out.print(i+" ");
        });

        Map<Boolean,List<Integer>> sorted=list.stream().collect(Collectors.partitioningBy(i->i%2==0));
        Set<Map.Entry<Boolean,List<Integer>>> sort=sorted.entrySet();
        for (Map.Entry<Boolean,List<Integer>> entry:sort){
            boolean flag=entry.getKey();
            if(flag==true){
                System.out.println("Even Element ");
            }else {
                System.out.println("Odd Element ");
            }
            List<Integer> st=entry.getValue();
            for (int i:st){
                System.out.print(i+" ");
            }
        }

    }

    @Test
    public void startWith(){
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,32);
        List<Integer> myList1 = Arrays.asList(10,15,8,49,25,98,98,32,15);
        //2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?

        myList.stream().map(i->i+" ").filter(i->i.startsWith("1")).forEach(System.out::println);

        //3. How to find duplicate elements in a given integers list in java using Stream functions?
        Set<Integer> st=new HashSet<>();
        myList1.stream().filter(i->!st.add(i)).forEach(System.out::println);
        //4. Given the list of integers, find the first element of the list using Stream functions?
        myList1.stream().findFirst().ifPresent(System.out::println);
        //  5. Given a list of integers, find the total number of elements present in the list using Stream functions?
        long cnt=myList1.stream().count();
        System.out.println(cnt);
        //
        Integer max=myList1.stream().max(Integer::compareTo).get().intValue();
        System.out.println(max);
    }

    @Test
    public void nonRepeat(){
        //7. Given a String, find the first non-repeated character in it using Stream functions?
        String s="java is object oriented";
        List<Character> c=s.chars()
                .mapToObj(i->Character.toLowerCase(Character.valueOf((char)i)))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i->i.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("non repeat::"+c.stream().findFirst());

        Character cq=s.chars()
                .mapToObj(i->Character.toLowerCase(Character.valueOf((char)i)))
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i->i.getValue()>1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList()).get(1);
        System.out.println("first repeated "+cq);
    }
    //9. Given a list of integers, sort all the values present in it using Stream functions?
    @Test
    public void sorted(){
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        myList.stream().distinct().sorted().forEach(i->System.out.print(i+" "));
        System.out.println();
        //10. Given a list of integers, sort all the values present in it in descending order using Stream functions?
        myList.stream().distinct().sorted(Comparator.reverseOrder()).forEach(i-> System.out.print(i+" "));
    }
    //11. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
    @Test
    public void twiceArray(){
        List<Integer> myList = Arrays.asList(1,2,3,4,1);
        List<Integer> list=myList.stream().collect(Collectors.toList());
        Set<Integer> st=new HashSet<>(list);
        if(st.size()!=list.size()){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
    //12. How will you get the current date and time using Java 8 Date and Time API?
    @Test
    public void DateTime(){
        System.out.println("local date  "+java.time.LocalDate.now());
        System.out.println("local time  "+java.time.LocalTime.now());
        System.out.println("local date and time  "+java.time.LocalDateTime.now());
    }
    //13. Write a Java 8 program to concatenate two Streams?
    @Test
    public void concat(){
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");
        Stream.concat(list1.stream(),list2.stream()).forEach(i-> System.out.print(i+" "));
    }
   //15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
    @Test
    public void convert(){
        int arr[] = { 99, 55, 203, 99, 4, 91 };
         Arrays.parallelSort(arr);
         Arrays.stream(arr).forEach(n-> System.out.print(n+" "));
    }
    //16. How to use map to convert object into Uppercase in Java 8?
    @Test
    public void covertUpper(){
        List<String> list2 = Arrays.asList("explained", "through", "programs");
        list2.stream().map(String::toUpperCase).forEach(i-> System.out.print(i+" "));
    }

    //22. Write a program to print the count of each character in a String?
    @Test
    public void uniqueChar() {
        String s = "string data to count each character";
        Map<Character, Long> col = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(col);
    }

    //21. Write a Program to find the Maximum element in an array?
    @Test
    public void maxValue() {
        int[] a = {12, 19, 20, 88, 00, 9};
        OptionalInt max = Arrays.stream(a).max();
        System.out.println(max);
    }
    //20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?

    @Test
    public void emptyv() {
        int[] a = {1, 2, 3};
      /*  Optional.of(Arrays.asList(a)).orElseGet(Collections::emptyList).stream().
                                                                        filter(Objects::nonNull)
                                                                        .map(note -> Notes::getTagName)
                                                                       .forEach(System.out::println);
    */
    }

    //19. How to find only duplicate elements with its count from the String ArrayList in Java8?
    @Test
    public void duplicateList() {
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        List<String> col = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(i -> i.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(col);
    }

    //17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
    @Test
    public void dupKey() {
        List<Notes> notes = new ArrayList<>();
        notes.add(new Notes(1, "Sneha", 11));
        notes.add(new Notes(2, "Rahul", 22));
        notes.add(new Notes(3, "Latha", 33));
        notes.add(new Notes(4, "Pandey", 44));
        notes.add(new Notes(5, "Aashish", 55));
        notes.add(new Notes(6, "Pandey1", 44));

       /* Map<String, Long> notesRecords = notes.stream()
                .sorted(Comparator
                        .comparingLong(Notes::getTag)
                        .reversed()) // sorting is based on TagId 55,44,33,22,11
                .collect(Collectors.toMap
                        (Notes::getName, Notes::getTag,
                                (oldValue, newValue) -> oldValue,LinkedHashMap::new));*/

    }

    @Test
    public void upperA(){
        //16. How to use map to convert object into Uppercase in Java 8?
        List<String> cha=Arrays.asList("aa","bb","cc");
        List<String> upp=cha.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upp);

    }

    //14. Java 8 program to perform cube on list elements and filter numbers greater than 50.

    @Test
    public void  cube(){
        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
         integerList.stream().map(i->i*i*i).filter(i->i>50).forEach(System.out::println);

         //13. Write a Java 8 program to concatenate two Streams?
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream.concat(list1.stream(),list2.stream()).forEach(i-> System.out.print(i+" "));
    }
}
