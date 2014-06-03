public class removespecialcharacterclass {	
	public String remove(String str)
	{
		String to_send=str;
		to_send = to_send.replaceAll("[^a-zA-Z 0-9]+","");
		return to_send;
	}
}
