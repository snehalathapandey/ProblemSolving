package DSA.ProblemSolvingSet1.Files;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CreateWrite {
    //create a file
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     System.out.println("Enter the file name: ");
     String fileName = sc.nextLine();
     try{
         File file = new File(fileName);
          if(!file.exists()){
              file.createNewFile();
          }else {
              System.out.println(file.getAbsolutePath());
              System.out.println("File already exists!");
          }
         FileWriter fw = new FileWriter(fileName);
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write("Java is a popular programming language, created in 1995.\n" +
                 "\n" +
                 "It is owned by Oracle, and more than 3 billion devices run Java.\n" +
                 "\n" +
                 "It is used for:\n" +
                 "\n" +
                 "Mobile applications (specially Android apps)\n" +
                 "Desktop applications\n" +
                 "Web applications\n" +
                 "Web servers and application servers\n" +
                 "Games\n" +
                 "Database connection\n" +
                 "And much, much more!");
         bw.close();
     }catch (IOException e){
         System.out.println("An error occurred while creating the file");
         e.printStackTrace();
     }
    }



}
