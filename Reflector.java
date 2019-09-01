
public class Reflector extends Translator{
	final String symPermutation="YRUHQSLDPXNGOKMIEBFZCWVJAT";
	//reflectors function
	char reflect(char letter)
	{
		int index=ConvertLetter(letter);
		return symPermutation.toCharArray()[index];
	}
}
