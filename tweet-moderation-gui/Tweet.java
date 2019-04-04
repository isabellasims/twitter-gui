/**
 * Tweet class to store information of individual tweets
 * Stored data specified by constructor perameters
 */

public class Tweet{

    private long tweetid;
    private String userid;
    private String displayName;
    private String screenName;
    private String tweetText;
    private String accountLang;
    private String date;
    private String quotes;
    private String replies;
    private String likes;
    private String retweets;
    private String quoteid;
    private String replyid;

/**
 * constructor of tweet class for all perameters needed to display Tweet pane / to accurately index in Tweet Parser class
 * @param  tweetid     [description]
 * @param  userid      [description]
 * @param  displayName [description]
 * @param  screenName  [description]
 * @param  accountLang [description]
 * @param  tweetText   [description]
 * @param  date        [description]
 * @param  quotes      [description]
 * @param  replies     [description]
 * @param  likes       [description]
 * @param  retweets    [description]
 * @param  quoteid     [description]
 * @param  replyid     [description]
 */
   public Tweet(long tweetid, String userid, String displayName, String screenName, String accountLang,
      String tweetText, String date, String quotes, String replies, String likes, String retweets, String quoteid, String replyid){
      this.tweetid = tweetid;
      this.userid = userid;
      this.displayName=displayName;
      this.screenName=screenName;
      this.tweetText=tweetText;
      this.accountLang = accountLang;
      this.date=date;
      this.quotes=quotes;
      this.replies=replies;
      this.likes=likes;
      this.retweets=retweets;
      this.quoteid=quoteid;
      this.replyid=replyid;
}


  // constructor used in parseUsersAndTweets from GUI class to check if usernames match
  public Tweet(long tweetid, String userid){
      this.tweetid = tweetid;
      this.userid = userid;
    }

 
    /**
     * Getters for tweets
     * this. keyword used for setters
     * @return value of current line at specified index
     */
    public long gettweetid(){
      return tweetid;
    }

    public String getuserid(){
      return userid;
    }

    public String getdisplayName(){
        return displayName;
    }

    public String getscreenName(){
      return screenName;
    }

    public String gettweetText(){
      return tweetText;
    }
      
    public String getaccountLang(){
      return accountLang;
    }

    public String getdate(){
      return date;
    }

    public String getquotes(){
      return quotes;
    }

    public String getreplies(){
     return replies;
    }

    public String getlikes(){
      return likes;
    }

    public String getretweets(){
      return retweets;
    }

    public String getquoteid(){
      return quoteid;
    }

    public String getreplyid(){
      return replyid;
    }

  }