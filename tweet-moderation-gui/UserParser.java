import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class UserParser{
  public static ArrayList<User> parseUsers (String filename,int num) throws Exception{
    ArrayList<User> users = new ArrayList<User>();
    Scanner scanner = new Scanner(new File(filename), "UTF-8");
    String line = scanner.nextLine();
    line = scanner.nextLine();
    int i = 0;
    while(scanner.hasNextLine() && i < num){ 
      line = scanner.nextLine();
      String[] fields = line.split("\",\"");
      fields[0] = fields[0].substring(1);   
      try{
        // added indexing 
        users.add(new User(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5],
        Long.parseLong(fields[6]), Long.parseLong(fields[7]), fields[8], fields[9]));
        i++;
      }
      catch(Exception e){
        System.out.println("file error: "+ e.getClass().getCanonicalName());
        System.out.println(e.getMessage());
      }
    }

    return users;
  }
}

