public class removehashtagclass {
	String removehashtag(String str_received)
	{
		String[] statusarray=str_received.split(" ");
		String str_tosend=new String();
		String temp=new String();
		for(int i=0;i<statusarray.length;i++)
		{
			if(statusarray[i].startsWith("#"))
			{
				temp=statusarray[i];
				temp=temp.substring(1);
				str_tosend+=temp;
				str_tosend+=" ";
			}
			else{	
				str_tosend+=statusarray[i].toLowerCase();
				str_tosend+=" ";
			}
	}
		return str_tosend;

	}
}
