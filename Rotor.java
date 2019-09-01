
public class Rotor extends Translator{
	private char Notch;
	private char ringSetting;
	private char ringOffset;
	private int rotorNumber;
	
	//constructor
	Rotor()
	{
		rotorNumber=-1;
	}
	
	//constructor
	Rotor(int rotNum,char set,char off)
	{
		this.rotorNumber=rotNum;
		this.ringSetting=set;
		this.ringOffset=off;
	}
	
	//constructor
	Rotor(int rotNum)
	{
		if(rotNum>0&&rotNum<6)
			rotorNumber=rotNum;
	}
	
	//rotor offset getter
	char getRotorOffset()
	{
		return ringOffset;
	}
	
	//rotor setting getter
	char getRotorSetting()
	{
		return this.ringSetting;
	}
	
	//rotor number getter
	int getRotorNumber()
	{
		return rotorNumber;
	}
	
	//rotor setting setter
	void SetSettings(char setting)
	{
		if(inputCheck(setting))
			ringSetting=Character.toUpperCase(setting);
		
	}
	
	//rotor offset setter
	void SetOffset(char offset)
	{
		if(inputCheck(offset))
			ringOffset=Character.toUpperCase(offset);
	}
	
	//advances offsets
	void advanceOffset(char offset)
	{
		int offsetNum=ConvertLetter(offset);
		if(offsetNum<25)
		{
			offsetNum+=1;
		}
		else
			offsetNum=0;
		offset=ConvertNum(offsetNum);
		SetOffset(offset);
	}
	
	//switches rotors
	char SwitchRotor(char letter,String direction)
	{
		int letterIndex=ConvertLetter(letter);
		letterIndex+=ConvertLetter(this.ringOffset);
		if(letterIndex>25)
			letterIndex=letterIndex-26;
		return ConvertNum(letterIndex);
	}
	
	//rotors permutation
	char TranslateRotor(char letter,String direction)
	{
		
		int A=ConvertLetter(letter),B=ConvertLetter(ringOffset),C=ConvertLetter(ringSetting);
	
		int perm=(A+B-C+26)%26;
	
		char BC=ConvertNum((-B+C+26)%26);
		char permute;
		if(direction=="forward")
		{
			permute=ForwardPermutation(rotorNumber,ConvertNum(perm));

		}
		else
		{
			permute=ReversePermutation(rotorNumber,ConvertNum(perm));
		}
		perm=(ConvertLetter(permute)+ConvertLetter(BC)+26)%26;
		permute=ConvertNum(perm);
		return permute;
	}
	
	//sets notch
	void setNotch()
	{
		switch(rotorNumber)
		{
		case 1:Notch='Q';
		break;
		case 2:Notch='E';
		break;
		case 3:Notch='V';
		break;
		case 4:Notch='J';
		break;
		case 5:Notch='Z';
		break;
		}
	}
	
	//gets notch
	char getNotch()
	{
		switch(rotorNumber)
		{
		case 1:return 'Q';
		case 2:return 'E';
		case 3:return 'V';
		case 4:return 'J';
		case 5:return 'Z';
		}
		return 'A';
	}
}
