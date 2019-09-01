
public abstract class Subtitutor {
	final String ABC="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int EnglishCount=26;
	
	//checks input
	static boolean inputCheck(char letter)
	{
		if((letter>64 && letter<91)||(letter>96 && letter<123))
		{	
			letter=Character.toUpperCase(letter);
			return true;
		}
		return false;	
	}
	
	//converts letters to indexes
	static int ConvertLetter(char letter)
	{
		int index=-1;
		if((letter>64 && letter<91)||(letter>96 && letter<123))
		{
			letter=Character.toUpperCase(letter);
			index=letter-65;
		}
		return index;
	}
	static char ConvertNum(int num)
	{
		return (char)(num+65);
	}
	
	//circular shift
	String CircularShift(String literate)
	{
		char[] newLiterate;
		char[] oldLiterate=literate.toCharArray();
		newLiterate=oldLiterate;
		for(int i=0;i<EnglishCount;i++)
		{
			if(i<EnglishCount-1)
			{
				newLiterate[i]=oldLiterate[i+1];
			}
			else
			{
				newLiterate[i]=oldLiterate[0];
			}
		}
		return String.valueOf(newLiterate);
	}
	abstract char ForwardPermutation(int rotorNum,char letter);
	abstract char ReversePermutation(int rotorNum,char letter);
	
}
