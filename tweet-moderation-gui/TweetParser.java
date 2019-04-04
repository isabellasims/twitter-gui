import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

public class TweetParser{
  /**
   * Takes the name of a comma-separated value (.csv) file in the local directory and parse the contents for tweets. The tweets have an expected structure of "Topic", "Sentiment", "TweetId", "TweetDate", "TweetText"
   * @param  filename the name of a comma-separated value (.csv) file in the local directory
   * @return          An array of parsed Message objects
   */
  public static ArrayList<Tweet> parseTweets(String filename, int num) throws Exception {
    ArrayList<Tweet> tweets = new ArrayList<Tweet>();
    Scanner scanner = new Scanner(new File(filename), "UTF-8");
    String line = scanner.nextLine();//the first line is field headers, we do not want that.
    line = scanner.nextLine();
    System.out.println(line);
    int i = 0;
    while(scanner.hasNextLine()){ 
      line = scanner.nextLine();
      String[] fields = line.split("\",\"");
      fields[0] = fields[0].substring(1);
      try{
        long l = Long.parseLong(fields[0]);
        tweets.add(new Tweet(l, fields[1], fields[2], fields[3], fields[10], fields[12], fields[13],
                fields[23], fields[24], fields[25], fields[26], fields[16], fields[18]));        
        i++;       
      }
      catch(Exception e){
        System.out.println("file error: "+ e.getClass().getCanonicalName());
            System.out.println(e.getMessage());
      }
    }
    return tweets;
  }
}
