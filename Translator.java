
public class Translator extends Subtitutor {
	String SetForwardPermutation(int rotorNum)
	{
		switch(rotorNum)
		{
		case 1: return "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
		case 2: return "AJDKSIRUXBLHWTMCQGZNPYFVOE";
		case 3: return "BDFHJLCPRTXVZNYEIWGAKMUSQO";
		case 4: return "ESOVPZJAYQUIRHXLNFTGKDCMWB";
		case 5: return "VZBRGITYUPSDNHLXAWMJQOFECK";
		default: return "YRUHQSLDPXNGOKMIEBFZCWVJAT";
		}
	}
	String SetReversePermutation(int rotorNum)
	{
		String permutation=SetForwardPermutation(rotorNum);
		char [] cpermutation=permutation.toCharArray();
		char [] creversePermutation=new char [26];
		char c;
		for(int i=0;i<26;i++)
		{
			c=cpermutation[i];
			creversePermutation[ConvertLetter(c)]=(char)(i+65);
		}
		return String.valueOf(creversePermutation);
	}
	
	//forward permutation
	char ForwardPermutation(int rotorNum,char letter) {
		char [] permutation=SetForwardPermutation(rotorNum).toCharArray();
		int index=ConvertLetter(letter);
		return permutation[index];
	}

	//reverse permutation
	char ReversePermutation(int rotorNum,char letter) {
		char[] rpermutation=SetReversePermutation(rotorNum).toCharArray();
		int index=ConvertLetter(letter);
		return rpermutation[index];
	}

}
