import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import java.util.ArrayList;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.collections.FXCollections;
import javafx.scene.layout.Pane;
import javafx.scene.control.Slider;
import javafx.geometry.Orientation;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.image.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Main class with start method for GUI program to parse and display sensitive tweets
 */
public class TweetModerationGUI extends Application {
    ArrayList<Tweet> tweets;
    ArrayList<User> users;
    int numusers;
    int numtweets;
    int usertweets;

    /**
     * creates interactive pane that is called to be displayed from the parse button in loading pane
     * @param  users  
     * @param  tweets 
     * @return pane
     */
    protected BorderPane getBorderPane(ArrayList<User> users , ArrayList<Tweet> tweets) {
  
    
        BorderPane pane = new BorderPane();
        HBox userpane = new HBox();
        Text text = new Text("Loaded " + users.size() + " users " + numtweets +
        " tweets");
        ArrayList<Pane> motherpane = new ArrayList<Pane>();
        for (User user : users) {
            motherpane.add(getUserPane(user));
        }
        ListView<Pane> lv = new ListView<>(FXCollections.observableArrayList(motherpane));
        lv.setPrefSize(450, 800);
        pane.setBottom(text);
        ScrollPane userlv = new ScrollPane(lv);
        userpane.getChildren().addAll(userlv);
        pane.setLeft(userpane);


        BorderPane pane1 = new BorderPane();
        HBox userpane1 = new HBox();
        
        ArrayList<Pane> motherpane1 = new ArrayList<Pane>();
         userlv.setOnMouseClicked(e -> {
           // for ( int i = 0; i < usertweets; i ++){
                for (Tweet tweet :  tweets) {
                   
                motherpane1.add(getTweetPane(tweet));
                System.out.println("TESTING");
                
            }
        //}
           

        });

        ListView<Pane> lv1 = new ListView<>(FXCollections.observableArrayList(motherpane1));
        lv1.setPrefSize(450, 800);
       
        ScrollPane userlv1 = new ScrollPane(lv1);
        userpane1.getChildren().addAll(userlv1);
        pane.setCenter(userpane1);
  
      

        return pane;
    }



    /**
     * Parses users and tweets given two diffwerent files
     * @param numtweets 
     * @param numusers  
     */ 
    public void parseUsersAndTweets(int numtweets, int numusers){
        try{
            tweets = TweetParser.parseTweets("iranian_tweets_csv_hashed.csv",numtweets);
            users = UserParser.parseUsers("iranian_users_csv_hashed",numusers);
            System.out.println(tweets.size() + " tweets parsed");
            System.out.println(users.size() + " users parsed");
            for(Tweet tweet: tweets){
                for(User user: users)
                    if(tweet.getuserid().equals(user.getuserid())){
                        user.addTweet(tweet);
                        break;
                    }
            }
        }catch(Exception e){
            System.out.println("file error: "+ e.getClass().getCanonicalName());
            System.out.println(e.getMessage());

            System.out.println(tweets.size() + " tweets parsed");
            System.out.println(users.size() + " users parsed");
        }
    }



    /**
     * 
     * Creates a GUI display for each user and populates the user pane with new display objects when called by getborderpane 
     * @param  user 
     * @return  pane
     */
    protected BorderPane getUserPane(User user) {
        
        BorderPane pane = new BorderPane();
        Image avatar_load = new Image("default_avatar.jpg", 50.0, 50.0, true, true);
        ImageView avatar = new ImageView(avatar_load);
        pane.setLeft(avatar);

       

        // followers, following, and tweets
        HBox socialpane = new HBox(20);
        Text text1 = new Text("Followers: "                        + user.getfollowers());
        Text text2 = new Text("Following: "                        + user.getfollowing());
        Text text3 = new Text("Tweets: " + user.getTweets().size());
        socialpane.getChildren().addAll(text1,text2,text3);
        pane.setBottom(socialpane);
        int usertweets = user.getTweets().size();
    
        
        
        // Id info + description
        Text location = new Text(user.getlocation());
        pane.setRight(location);
        VBox decriptionpane = new VBox(10);
        Text displayname = new Text(user.getdisplayname());
        Text username =  new Text(user.getuserid());
        Text url = new Text(user.getuserURL());
        Text description = new Text(user.getdescription());
        decriptionpane.getChildren().addAll(displayname,username,description,url);
        pane.setCenter(decriptionpane);
        return pane;
        
        
    }


    /**
     * Layout for individual tweet pane displays 
     * @param  tweet takes a new tweet as a perameter each time it is called 
     * @return       [description]
     */
    protected BorderPane getTweetPane(Tweet tweet) {
        
        BorderPane pane = new BorderPane();
     
        Image avatar_load = new Image("default_avatar.jpg", 50.0, 50.0, true, true);
        ImageView avatar = new ImageView(avatar_load);

        Image logo_load = new Image("Twitter_Logo_Blue.png", 30.0, 30.0, true, true);
        ImageView logo = new ImageView(logo_load);
        pane.setLeft(avatar);

       

        // quotes replies likes retweets date
        HBox socialpane = new HBox(20);
        Text text1 = new Text("Quotes: " + tweet.getquotes());
        Text text2 = new Text("Replies: "  + tweet.getreplies());
        Text text3 = new Text("Likes: " + tweet.getlikes());
        Text text4 = new Text("Retweets: " + tweet.getretweets());
        socialpane.getChildren().addAll(text1,text2,text3,text4);
        pane.setBottom(socialpane);


         
        
        // display name , username, tweettext     
        VBox decriptionpane = new VBox(10);
        Text displayname = new Text(tweet.getdisplayName());
        Text username =  new Text(tweet.getscreenName());
        Text tweettext = new Text(tweet.gettweetText());
        decriptionpane.getChildren().addAll(displayname,username,tweettext);
        pane.setCenter(decriptionpane);
        return pane;         
        
    }



    /**
     * Controls entire program - sliders decide how many users and messages will be displayed to the user later on the user pane (all tweets are always parsed excepting errors and total amount prints to the console)
     * Buttons for using and closing the application
     * @return returns pane to be called / used in the start method
     */
   
    protected BorderPane getLoadingPane() {
        
    // create pane for loading screen    
    BorderPane pane = new BorderPane();
    VBox sliderpane = new VBox(10);
    VBox buttonpane = new VBox(10);

    // create sliders
    Slider tweetslider = new Slider();
    tweetslider.setShowTickLabels(true);
    tweetslider.setShowTickMarks(true);
    tweetslider.setMax(25000); // chosen max display per user
    tweetslider.setMajorTickUnit(10000);
    tweetslider.setMinorTickCount(10);
    tweetslider.setBlockIncrement(10);


    Slider userslider = new Slider();
    userslider.setMax(770);   // users in data set
    userslider.setShowTickLabels(true);
    userslider.setShowTickMarks(true);
    userslider.setMajorTickUnit(100);
    userslider.setMinorTickCount(10);
    userslider.setBlockIncrement(10);
    

    // text 
    Text text1 = new Text("Set the maximum number of tweets per user:");
    Text text2 = new Text("Set the maximum number of users to parse:");
    Text text3 = new Text("Set the maximum number of users to parse:");
    

    // create buttons
    ToggleGroup group = new ToggleGroup();
    RadioButton b1 = new RadioButton("English");
    b1.setToggleGroup(group);
    b1.setSelected(true);
    RadioButton b2 = new RadioButton("Other");
    b2.setToggleGroup(group);
    RadioButton b3 = new RadioButton("All");
    b3.setToggleGroup(group);
    Button parseb = new Button("Parse");
    parseb.setOnAction((ActionEvent e) -> {
            numtweets = (int) tweetslider.getValue();
            numusers = (int) userslider.getValue();
            parseUsersAndTweets(numtweets, numusers);
            Stage primaryStage = new Stage(); 
            HBox scene2 = new HBox();
            scene2.getChildren().add(getBorderPane(users,tweets));
            Scene scene = new Scene(scene2, 1000, 800);
         
            primaryStage.setScene(scene);
            primaryStage.setMaximized(true);
            primaryStage.show();
            ((Stage) (((Button) e.getSource()).getScene().getWindow())).close(); 
    }); 
    Button cancelb = new Button("Cancel");
    cancelb.setOnAction((ActionEvent e) -> {
            System.exit(0);
    });

    // add nodes to panes
    pane.setTop(buttonpane);
    pane.setCenter(sliderpane);
    sliderpane.getChildren().add(text1);
    sliderpane.getChildren().add(tweetslider); 
    sliderpane.getChildren().add(text2);
    sliderpane.getChildren().add(userslider);
    buttonpane.getChildren().add(text3);   
    buttonpane.getChildren().add(b1);
    buttonpane.getChildren().add(b2);
    buttonpane.getChildren().add(b3);
    buttonpane.getChildren().add(parseb);
    buttonpane.getChildren().add(cancelb);   
    return pane;      
    }


    /**
     * Kicks off the program wih the loading scene
     * @param primaryStage 
     */
    public void start(Stage primaryStage) {
        
        Scene loadingScene = new Scene(getLoadingPane(), 1000 , 1000);
        primaryStage.setScene(loadingScene);
        primaryStage.setTitle("GUI Demo"); // Set the stage title
        primaryStage.show(); // Display the stage
       

    }

}

