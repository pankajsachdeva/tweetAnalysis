import java.io.FileWriter;
import java.io.IOException;


public class writeToFolderclass {
	  void writeToFolder(String folderName,String content,int startpos,int startneg) {
			// TODO Auto-generated method stub
		
				
		//		System.out.println("inside writeToFolder");
		//		System.out.println("content: "+content);
			String location="/path to store test files to traing folder/";
			location+=folderName;
			location=location+"/";
			
		//	System.out.println("folderName: "+folderName);
		//	System.out.println("location till now is"+location);
			
			if(folderName.equals("Pos"))
			{
				location=location+String.valueOf(startpos);
			}	
			
			if(folderName.equals("Neg"))
			{
				location=location+String.valueOf(startneg);
			}	
			
			location=location+".txt";
			
		//	System.out.println("location till now is"+location);
			try{
			FileWriter writer=new FileWriter(location);
			writer.write(content);
			writer.close();
			
			}
			catch(IOException e)
			{System.out.println(e);}
			
			
		}

}
