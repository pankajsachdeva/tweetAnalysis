class removehttpclass {	
	 String  removehttp(String str_received)
	{
		String[] statusarray=str_received.split(" ");
		String str_tosend=new String();
		for(int i=0;i<statusarray.length;i++)
		{
			if(statusarray[i].startsWith("http://"))
				{
			System.out.println();
			System.out.println("removed http from "+(i+1)+"th  word... :) ");
				str_tosend+="";
				}
					
			else
			{
				str_tosend+=statusarray[i];
				str_tosend+=" ";
			}
			
		}
		return str_tosend;
	}
}
