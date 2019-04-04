import java.util.ArrayList;
 /**
   * Takes the name of a comma-separated value (.csv) file in the local directory and parse the contents for tweets. The tweets have an expected structure of "Topic", "Sentiment", "TweetId", "TweetDate", "TweetText"
   * @param  filename the name of a comma-separated value (.csv) file in the local directory
   * @return          An array of parsed Message objects
   */
public class User {
  private ArrayList<Tweet> tweets;
  private String userid;
  private String displayname;
  private String screenname;
  private String location;
  private String description;
  private String userURL;
  private long followers;
  private long following;
  private String accountdate;
  private String language;


  // constructor for all perameters needed to display User pane
  public User (String userid, String displayname, String screenname, String location, 
    String description, String userURL, long followers, long following, String accountdate, String language){

    tweets = new ArrayList<Tweet>();
    this.userid = userid;
    this.displayname=displayname;
    this.screenname=screenname;
    this.location=location;
    this.description=description;
    this.userURL=userURL;
    this.followers=followers;
    this.following=following;
    this.accountdate=accountdate;
    this.language=language;
    
  }
  /**
   * constructure used to compare User to Tweets in test class
   * @param  userid can be matched to tweet ids       
   */
  public User (String userid){
    this.userid = userid;
    tweets = new ArrayList<Tweet>();
  }

/**
 * called on user objects in test class
 * @param tweet
 */
 public void addTweet(Tweet tweet){
    tweets.add(tweet);
  }

 
/**
 * getter and setter methods
 * @return value of current line at specified index
 * @param tweet [description]
 */
  public ArrayList<Tweet> getTweets(){
    return tweets;
  }


  public void setuserid(String x){
    this.userid = x;
  }

  public String getuserid(){
    return userid;
  }

  

  public void setdisplayname(String x){
    this.displayname = x;
  }

  public String getdisplayname(){
    return displayname;
  }



   public void setscreenname(String x){
    this.screenname = x;
  }

  public String getscreenname(){
    return screenname;
  }



  public void setlocation(String x){
    this.location = x;
  }

  public String getlocation(){
    return location;
  }



  public void setdescription(String x){
    this.description = x;
  }
  public String getdescription(){
    return description;
  }


  public void setuserURL(String x){
    this.userURL = x;
  }
  public String getuserURL(){
    return userURL;
  }


  public void setfollowers(long x){
    this.followers = x;
  }

  public long getfollowers(){
    return followers;
  }


  public void setfollowing(long x){
    this.following = x;
  }

  public long getfollowing(){
    return following;
  }


  public void setaccountdate(String x){
    this.accountdate = x;
  }

  public String getaccountdate(){
    return accountdate;
  }


  public void setlanguage(String x){
    this.language = x;
  }

  public String getlanguage(){
    return language;
  }
  
}