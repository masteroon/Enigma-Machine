
public class Plugboard extends Translator{
	//configures plugboard
	String configurePlugboard(String couples)
	{
		if(couples=="")
			return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String abc="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int i=0,index1=0,index2=0;
		char letter1,letter2;
		char[] tempABC=abc.toCharArray();
		char[] tempCouples=couples.toCharArray();
		while(i<couples.length()-1)
		{
			letter1=tempCouples[i];
			letter2=tempCouples[i+1];
			index1=ConvertLetter(letter1);
			index2=ConvertLetter(letter2);
			tempABC[index1]=letter2;
			tempABC[index2]=letter1;
			i=i+2;
		}
		
		return String.valueOf(tempABC).toUpperCase();
	}
}
