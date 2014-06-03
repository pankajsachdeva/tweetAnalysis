import java.sql.*;
import java.util.Collections;
import java.util.List;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
public class GetLiveTweetsToTest {

	public List<Status> getTweets(String keyword, int count)
	{
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("***********");
        cb.setOAuthConsumerSecret("**********");
        cb.setOAuthAccessToken("***************");
        cb.setOAuthAccessTokenSecret("*************");

        //using day20 stanfrod nlp
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        Query query = new Query(keyword + " ");
        query.setCount(count);
        query.setLocale("en");
        query.setLang("en");;
        try {
            QueryResult queryResult = twitter.search(query);
            return queryResult.getTweets();
        } catch (TwitterException e) {
            // ignore
            e.printStackTrace();
        }
        return Collections.emptyList();       	  
	}
}
