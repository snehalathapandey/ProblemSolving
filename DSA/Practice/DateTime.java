package DSA.Practice;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTime {
    @Test
    public void findAge(){
        LocalDate DOB= LocalDate.of(1993,8,30);
        LocalDate today=LocalDate.now();
        System.out.println(ChronoUnit.YEARS.between(DOB,today));
    }

   @Test
    public void timeConversion() {
        String s="07:05:45PM";
        DateTimeFormatter format12hours=DateTimeFormatter.ofPattern("hh:mm:ssa");
        LocalTime lt=LocalTime.parse(s,format12hours);
        DateTimeFormatter format24hours=DateTimeFormatter.ofPattern("HH:mm:ss");
        String f1=lt.format(format24hours);
    System.out.println(f1);
    }


}
