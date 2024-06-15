package DSA.Student;

public class Employee {
    int id;
    int age;
    int yearOfJoining;
    String name;
    String gender;
    String department;
    double Salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", age=" + age +
                ", yearOfJoining=" + yearOfJoining +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", Salary=" + Salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return Salary;
    }

    public Employee(int id, int age, int yearOfJoining, String name, String gender, String department, double salary) {
        this.id = id;
        this.age = age;
        this.yearOfJoining = yearOfJoining;
        this.name = name;
        this.gender = gender;
        this.department = department;
        Salary = salary;
    }


}
