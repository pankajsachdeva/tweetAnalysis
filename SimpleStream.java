import java.sql.*;
import twitter4j.FilterQuery;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.conf.ConfigurationBuilder;

public class SimpleStream {
    Connection conn;
	
	public static void main(String[] args) {
    	
	final	SimpleStream obj=new SimpleStream();
		
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("***********");
        cb.setOAuthConsumerSecret("******************************");
        cb.setOAuthAccessToken("***********************");
        cb.setOAuthAccessTokenSecret("********************");

        
        
     //   final SentimentClassifier sentClassifier=new SentimentClassifier(); 
 //creating database conncetivity
        
        String  passwd="pankaj14";
    	
 
        try{
    	           Class.forName("com.mysql.jdbc.Driver");
    	           obj.conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tweetset2","root",passwd);
        } catch(Exception ex)
    	   {
    	        System.out.println(ex);      
    	    }
    	
        System.out.println("connection successful");
        //database connection made
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

        StatusListener listener = new StatusListener() {

            @Override
            public void onException(Exception arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onStatus(Status status) {
                User user = status.getUser();
                
                // gets Username
                String username = status.getUser().getScreenName();
                System.out.println(username);
                String profileLocation = user.getLocation();
                System.out.println(profileLocation);
                long tweetId = status.getId(); 
                System.out.println(tweetId);
                String content = status.getText();
                System.out.println(content +"\n");

          
                PreparedStatement pst = null;
                try{
                pst=obj.conn.prepareStatement("insert into tweetCollection2 (username,profileLocation,tweetId,status) values(?,?,?,?)");
                pst.setString(1,username);
                pst.setString(2,profileLocation );
                pst.setLong(3,tweetId);
                pst.setString(4,content);
                pst.executeUpdate();
               
                }
                catch(SQLException e)
                {
                	e.printStackTrace();
                }
            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
                // TODO Auto-generated method stub

            }

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub
				
			}

        };
        FilterQuery fq = new FilterQuery();
    
        String keywords[] = {"#bjp","#aap","#cong","namo","rahul gandhi","kejriwal"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);  

    }
}
