
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;


//import com.mysql.jdbc.Statement;


public class tweetCleaner {
	/*This class is for
	 * extracting the tweet from the database 
	 * and then removing 
	 * 		http//...
	 * 		stopwords
	 * and then inserting them back to a new table 
	 */
	static int startpos=646;
		 static int startneg=376;
		
    Connection conn;
    static removehttpclass removehttpobj=new removehttpclass();
	static removestopwordclass removestopwordobj=new removestopwordclass();
	static removehashtagclass removehashtagobj=new removehashtagclass();
	static removeAtKeyword removeAtKeywordobj=new removeAtKeyword();
	static writeToFolderclass writeToFolderobj=new writeToFolderclass();
	static removespecialcharacterclass removespecialcharacterobj=new removespecialcharacterclass();
	public static void main(String[] args) {		
		
		tweetCleaner obj=new tweetCleaner();
		
	
 //creating database conncetivity
        String  passwd="db password";
 
        try{
    	           Class.forName("com.mysql.jdbc.Driver");
    	           obj.conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tweetset2","root",passwd);
        } catch(Exception ex)
    	   {
    	        System.out.println(ex);      
    	    }
    	
        System.out.println("connection successful");
        //database connection made
        
        //reading starts
        try{
        	Statement st=obj.conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
        	
        	String sql;
        	sql=" select tweetId,status from tweetcollection2 where status like '%bjp%' or status like '%modi%' and tweetId not in (select tweetId from first1000bjp) ;";
        	ResultSet rs=st.executeQuery(sql);// query executed
        	
        	//using status one by one
        	String status;
        	long tweetId;
        	String result1;
        	String result2;
        	String result3;
        	String result4;
        	String result5;
        	while(rs.next())
        	{
        		
        		status=rs.getString("status");
        	//	tweetId=rs.getLong("tweetId");
        		//System.out.println("status is: "+status);
        		//retrieved status
        		/*now applying all the cleaning methods
        		
        		*1.result1 is to remove http
        		*2.result2 is to remove stopword
        		*3. result3 removes # if sticken to a word
        		*4. remove @ with the username
        		*5.	remove ' and other variables
        		*/
        		result1=removehttpobj.removehttp(status);
        	//	System.out.println("removed http and result1 is formed");
        		
        		result2=removehashtagobj.removehashtag(result1);
        		result3=removeAtKeywordobj.removeAt(result2);
        		result4=removespecialcharacterobj.remove(result3);
        		result5=removestopwordobj.removestopword(result4);
        		
        		
        		//as result3 is called everywhere, therefiore the below statement
        		result3=result5;
        	//	result1=LanguageGuess.langGuess(status);
        		
        		//checking the result of removehttpclass
        		
        		
        		System.out.println("result3 is : "+result3);
        		//adding this to our status modified field in mysql table
        		        		
        	/*
        		
        		PreparedStatement pst = null;
                try{
                pst=obj.conn.prepareStatement("update tweetCollection2 set statusmodified=? where tweetId=?;");
                pst.setString(1,result3);
                pst.setLong(2,tweetId);
                pst.executeUpdate();
                
                }
                catch(SQLException e)
                {
                	e.printStackTrace();
                }
            */
        		
                //using stanford 20 day
        		
        		/*
        		System.out.println("Using Stanford NLP ");
        		  SentimentAnalyzer sentimentAnalyzer = new SentimentAnalyzer();
        	        TweetWithSentiment tweetWithSentiment = sentimentAnalyzer
        	                .findSentiment(result3);
        	        System.out.println(tweetWithSentiment);		
                		
                	*/	
                //		System.out.println();
        	
               //using sentimentClassifier linpipe
        	    final SentimentClassifier sentClassifier=new SentimentClassifier(); 

        		
        	      String sent = sentClassifier.classify(result3);
  				System.out.println( sent); 
  				
  				
  				
  				writeToFolderobj.writeToFolder(sent,result3,startpos,startneg);	
  			
  				if(sent.startsWith("Pos"))
  				{  
  					startpos++;
  				//	System.out.println("increased startpos");
  				
  				}
  				if(sent.startsWith("Neg"))          	  {
          		  
          	  
           		  startneg++;
           	//	System.out.println("increased startneg");   	
          	  }	
        		
        	}
        
        }catch(Exception e)
        {
        	System.out.println(e);
        }
		
		
	}
	

}
