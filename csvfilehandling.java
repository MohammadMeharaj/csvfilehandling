import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Students{
    String Name;
    int Age;
    int Marks;
    String Grade;
    public Students(String Name,int Age,int Marks,String Grade)
    {
        this.Name=Name;
        this.Age=Age;
        this.Marks=Marks;
        this.Grade=Grade;
    }
    
}

public class CSV {
    public static void main(String[] args)  {
        //create a file
        File filename=new File("Meharaj.csv");
        try {
            System.out.println(filename.createNewFile());
        } catch (IOException e) {
         
           System.out.println("Error");
        }
        System.out.println("File created");
        List<Students>listofdata=new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you wanna add elements? :");
        String choice = scan.nextLine();
        while(!choice.equalsIgnoreCase("no")){
            System.out.println("Enter Name: ");
            String Name = scan.nextLine();

            System.out.println("Enter Age: ");
            int Age = scan.nextInt();
            System.out.println("Enter Marks:");
            int Marks= scan.nextInt();
            scan.nextLine();
            System.out.println("Enter Grade: ");
            String Grade = scan.nextLine();
            listofdata.add(new Students(Name,Age,Marks,Grade));
            scan.nextLine();
            System.out.println("Do you wanna add elements? ");
            choice = scan.nextLine();
    }
    //write data to file
    try{
       FileWriter fileWriter=new FileWriter("Meharaj.csv");
       BufferedWriter bw = new BufferedWriter(fileWriter);
        for(Students s:listofdata){
            bw.write("Name:"+s.Name+","+" Age:"+s.Age+","+" Marks:"+s.Marks+","+" Grade: "+s.Grade+"\n");
        }
        bw.flush();
        System.out.println("Data has been written to the file");
    }
    catch(Exception e){
        System.out.println("Error");

    }
    //read csv data 
    try{
        FileReader filereader=new FileReader("Meharaj.csv");
        BufferedReader br=new BufferedReader(filereader);
        while ((choice = br.readLine()) != null) 
        {
            System.out.println(choice);
        }
    }
    catch(Exception e)
    {
        System.out.println("Error");
    }
}

   
}

