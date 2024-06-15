package DSA.Student;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class practice {

    @Test
    public void emplist(){
        List<Employee> employees=new ArrayList<Employee>();
        employees.add(new Employee(1,30,2020,"Sneha","female","Developer",35000.0));
        employees.add(new Employee(2,31,2021,"rauk","male","Tester",45000.0));
        employees.add(new Employee(3,32,2014,"rahul","male","Developer",34000.0));
        employees.add(new Employee(4,33,2018,"aashish","male","Developer",45000.0));
        employees.add(new Employee(5,34,2013,"anju","female","Writer",55000.0));
        employees.add(new Employee(6,35,2012,"neelam","female","CA",90000.0));
        employees.add(new Employee(7,36,2015,"avi","male","Artist",45000.0));
      // countGender(employees);
       //getDepartment(employees);
      // avgAGE(employees);
      // joinedEmp(employees);
      //  numofemp(employees);
      //  avgDep(employees);
      //  youngAge(employees);
        mostExp(employees);
      //  salesCount(employees);
      //  oldestEmp(employees);
      //  partionID(employees);
    }



    //Query 3.1 : How many male and female employees are there in the organization?
    public void countGender(List<Employee> employees){
        Map<String,Long> list=employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println("list :: "+list);
        int st= list.entrySet().stream().filter(i->i.getKey().equals("female")).map(Map.Entry::getValue).collect(Collectors.toList()).get(0).intValue();
        System.out.println(st);
        int gen=list.entrySet().stream().filter(i->i.getKey().equals("male")).map(Map.Entry::getValue).collect(Collectors.toList()).get(0).intValue();
       System.out.println(gen);
    }

    //Query 3.2 : Print the name of all departments in the organization?
    public void getDepartment(List<Employee> employees){
        employees.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
    }

    //Query 3.3 : What is the average age of male and female employees?
    //Query 3.4 : Get the details of highest paid employee in the organization?
    public void avgAGE(List<Employee> employees){
       Map<String,Double> avg=employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
       System.out.println("avg :: "+avg);
       double max=employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get().getSalary();
        System.out.println("max :: "+max);
        double anomax=employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).get().getSalary();
        System.out.println("another max :: "+anomax);
    }
    //Query 3.5 : Get the names of all employees who have joined after 2015?

    public void joinedEmp(List<Employee> employees){
       List<Employee> st= employees.stream().filter(i->i.yearOfJoining>2015).collect(Collectors.toList());
        st.stream().forEach(System.out::println);
    }
   //Query 3.6 : Count the number of employees in each department?

    public void numofemp(List<Employee> employees){
        Map<String,Long> count=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
       Set<Map.Entry<String,Long>> unique=count.entrySet();
       for (Map.Entry<String,Long> st:unique){
           System.out.println(st.getKey()+" "+st.getValue());
       }
    }
    //Query 3.7 : What is the average salary of each department?

    public void avgDep(List<Employee> employees){
     Map<String,Double> avg= employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
        Set<Map.Entry<String,Double>> unique=avg.entrySet();
        for (Map.Entry<String,Double> entry:unique){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    //3.8.Get the details of youngest male employee in the product development department?
    public void youngAge(List<Employee> employees){
      Employee stud=  employees.stream().filter(i->i.gender=="male"&& i.department=="Developer").min(Comparator.comparing(Employee::getAge)).get();
        System.out.print(stud.name+ " "+stud.department+" "+stud.age);
        System.out.println();
    }
    //Query 3.9 : Who has the most working experience in the organization?
    public void mostExp(List<Employee> employees){
        Employee emp=employees.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst().get();
        System.out.println(emp.name+" "+emp.age+" "+emp.gender);
        Employee emp1=employees.stream().max(Comparator.comparingInt(Employee::getYearOfJoining)).get();
        System.out.println(emp1.name+" "+emp1.age+" "+emp1.gender);
    }

    //Query 3.10 : How many male and female employees are there in the sales and marketing team?
   // Query 3.11 : What is the average salary of male and female employees?

//Query 3.12 : List down the names of all employees in each department?
    //Query 3.13 : What is the average salary and total salary of the whole organization?

    public void salesCount(List<Employee> employees){
       Map<String,Long> emp= employees.stream().filter(i->i.department=="Developer").collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
        System.out.println(emp);
       Map<String,Double> emp1=employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("avg "+emp1);
        Map<String,List<Employee>> st=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        Set<Map.Entry<String,List<Employee>>> se=st.entrySet();
        for (Map.Entry<String,List<Employee>> entry:se){
            System.out.println("Employee IN "+entry.getKey());
            List<Employee> stu=entry.getValue();
            for (Employee e:stu){
                System.out.println(e.name+" "+e.department+" "+e.gender);
            }

        }
    DoubleSummaryStatistics summaryStatistics=employees.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary "+summaryStatistics.getAverage());
        System.out.println("total Salary "+summaryStatistics.getSum());

    }

    //Query 3.14 : Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
    public void partionID(List<Employee> employees){
        Map<Boolean,List<Employee>> part=employees.stream().collect(Collectors.partitioningBy(i->i.age>25));
        Set<Map.Entry<Boolean, List<Employee>>> list=part.entrySet();
        for (Map.Entry<Boolean,List<Employee>> entry:list){
            if(entry.getKey()){
                System.out.println("Employee is greater than 25");
            }else {
                System.out.println("Employee is less than 25");
            }
            List<Employee> values=entry.getValue();
            for (Employee e:values){
                System.out.println(e.name+" "+e.department);
            }
        }
    }

    //Query 3.15 : Who is the oldest employee in the organization? What is his age and which department he belongs to?
    public void oldestEmp(List<Employee> employees){
        Employee emp=employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
        System.out.println("oldest emp "+emp.name+" "+emp.department+" "+emp.gender);
    }




}
