import java.util.Scanner;
public class Enigma extends Subtitutor{



	public static void main(String [ ] args)
	{
		
	/*
		//task 4	
		System.out.println("TASK 4");
		System.out.println("******");
		System.out.println(EncryptMessage(1,2,3,'A','F','A','D','A','V',"","ENIGMA"));
		System.out.println(EncryptMessage(1,2,3,'A','Q','A','E','A','V',"","KAXMNF"));
		System.out.println(EncryptMessage(1,2,3,'A','X','A','E','A','Y',"","TURING"));
		System.out.println(EncryptMessage(1,2,4,'C','S','H','D','F','I',"","PEACE"));
		System.out.println(EncryptMessage(1,2,4,'C','S','H','D','F','I',"ATCERL","PEACE"));
		System.out.println(EncryptMessage(2,5,4,'S','C','I','O','X','N',"ZUHLCQWMOAPYEBTRDNVI","DOR"));
		System.out.println(EncryptMessage(2,5,4,'S','C','I','O','X','N',"ZUHLCQWMOAPYEBTRDNVI","MLD"));
		System.out.println("******");
	*/
	/*	
		//task5
		System.out.println("TASK 5");
		System.out.println("------");
		DecipherGermanCode();
		System.out.println("***********************");
	*/
		
	/*
		//task6
		for(int i=0;i<10000;i++)
			EncryptMessage(1,2,4,'C','S','H','D','F','I',"ATCERL","PEACE");
	*/	
	

		//User Input, activate to use custom settings
		UserInput(true);	  
	
		
	}
	
	//checking valid setting and offsets for user input
	static boolean CheckSettingOrOffset(String input)
	{
		if(input.length()>1)
			return false;
		char[] c=input.toCharArray();
		if(!Character.isAlphabetic(c[0]))
			return false;
		return true;
	}
	
	//user input for selecting rotor
    static Rotor RotorSelection(String rotPos,int[] rotNums,boolean checkUserInput)
    {
    	int Rot=1;	
    	char setting='A',offset='A';
		boolean check;
		String input;
		char[] translate;
		Scanner reader = new Scanner(System.in); 	
    	int i=0;
    	while(i==0)
		{
			System.out.print("Select "+rotPos +"Rotor (1-5):	");
			input=reader.nextLine();
			if(checkUserInput==true)
				check=checkRotor(input,rotNums);
			else
				check=true;
			if(check==true) 
			{
				translate=input.toCharArray();
				Rot=Character.getNumericValue(translate[0]);
				i=1;
			}
			else
				System.out.println("Invalid input, insert a number between 1 and 5, do not choose the same rotor twice");
		}	
    	i=0;
    	while(i==0)
    	{
    		System.out.print("Enter Setting for "+rotPos +" Rotor:	");
    		input=reader.nextLine();
    		if(checkUserInput==true)
    		{
    			if(CheckSettingOrOffset(input)==true)
    			{
    				translate=input.toCharArray();
    				setting=Character.toUpperCase(translate[0]);
    				i=1;
    			}
    			else
    				System.out.println("Invalid input, insert a Letter");
    		}
    		else
    		{
    			translate=input.toCharArray();
				setting=Character.toUpperCase(translate[0]);
				i=1;
    		}
    	}
    	i=0;
    	while(i==0)
    	{
    		System.out.print("Enter Offset for "+rotPos +" Rotor:	");
    		input=reader.nextLine();
    		if(checkUserInput==true)
    		{
    			if(CheckSettingOrOffset(input)==true)
    			{	
    				translate=input.toCharArray();
					offset=Character.toUpperCase(translate[0]);
					i=1;
    			}
    			else
    				System.out.println("Invalid input, insert a Letter");
    		}
    		else
    		{
    			translate=input.toCharArray();
				offset=Character.toUpperCase(translate[0]);
				i=1;
    		}
    	}
		Rotor r=new Rotor(Rot,setting,offset);
		return r;
    }
    
    //validating user input text
    static boolean CheckText(String text)
    {
    	char []ctext=text.toCharArray();
    	for(int i=0;i<ctext.length;i++)
    	{
    		Character.toUpperCase(ctext[i]);
    	}
    	for(int i=0;i<ctext.length;i++)
    	{
    		if(!Character.isAlphabetic(ctext[i]))
    			return false;
    	}
    	return true;
    }
    static String ScanText(boolean checkUserInput)
    {
    	int i=0;
    	String input="";
    	Scanner reader = new Scanner(System.in); 
    	System.out.println("Enter Text To Encrypt:");
    	while(i==0)
    	{
    		input=reader.nextLine();
    		if(checkUserInput==true)
    		{
    			if(CheckText(input)==true)
    				i=1;
    			if(i==0)
    				System.out.println("The text you entered cannot be encrypted,use text without numbers and signs");
    		}
    		else
    			i=1;
    	}	
    	return input;
    }
    
    //another user input
    static boolean yesOrNo(boolean checkUserInput)
    {
    	String input="";
    	char[] text;
    	Scanner reader = new Scanner(System.in); 
    	System.out.println("Encrypt another word? (Y/N)");
    	do
    	{
    		input=reader.nextLine();
    		text=input.toCharArray();
    		if(checkUserInput==true)
    		{
    			if(text[0]=='y' || text[0] =='Y')
    				return true;
    			else if(text[0]=='n' || text[0] =='N')
    				return false;
    			else
    				System.out.println("Invalid input,try again!");
    		}
    		else
    			input="N";
    	}while(input!="y"&&input!="Y"&&input!="n"&&input!="N");
    	System.out.println("GoodBye!");
    	return false;
    }
    
    //activating all the user input functions and calls the enigma machine
	static void UserInput(boolean checkUserInput)
	{
		Rotor L,M,R;
		int k=1;
		Plugboard P=new Plugboard();
		String plugboard,text;
		int []rotorNums=new int[3];
		do
		{plugboard=SetPlugboard(P,checkUserInput);
		for(int j=0;j<rotorNums.length;j++)
			rotorNums[j]=0;
		L=RotorSelection("Left",rotorNums,checkUserInput);
		rotorNums[0]=L.getRotorNumber();
		M=RotorSelection("Middle",rotorNums,checkUserInput);
		rotorNums[1]=M.getRotorNumber();
		R=RotorSelection("Right",rotorNums,checkUserInput);
		rotorNums[2]=R.getRotorNumber();
		text=ScanText(checkUserInput);
		text=EncryptMessage(L.getRotorNumber(),M.getRotorNumber(),R.getRotorNumber(),L.getRotorSetting(),L.getRotorOffset(),M.getRotorSetting(),M.getRotorOffset(),R.getRotorSetting(),R.getRotorOffset(),plugboard,text);
		System.out.println(text);
		if(yesOrNo(checkUserInput)==false)
			k=0;
		}while(k!=0);
	}
	
	//checks rotor validation
	static boolean checkRotor(String s,int[] chosenRotors)
	{
		int check;
		if(s.length()>1)
			return false;
		char[] input=s.toCharArray();
		if(!Character.isDigit(input[0]))
			return false;
		check=Character.getNumericValue(input[0]);
		if(check>5||check<1)
			return false;
		for(int i=0;i<chosenRotors.length;i++)
			if(chosenRotors[i]==check)
				return false;
		return true;
		
	}
	
	//enigma configuration method
	static String EncryptMessage(int Lrot,int Mrot,int Rrot,char Lset,char Loff,char Mset, char Moff,char Rset,char Roff,String plugboard,String text)
	{
		String encryptedMessage;
		Plugboard pb=new Plugboard();
		String plugboardSettings=plugboard;
		plugboardSettings=pb.configurePlugboard(plugboardSettings);
		Reflector ref=new Reflector();
		Rotor r=new Rotor(Rrot);
		r.SetSettings(Rset);
		r.SetOffset(Roff);
		Rotor m=new Rotor(Mrot);
		m.SetSettings(Mset);
		m.SetOffset(Moff);
		Rotor l=new Rotor(Lrot);
		l.SetSettings(Lset);
		l.SetOffset(Loff);
		encryptedMessage=RunText(plugboardSettings.toCharArray(),ref,r,m,l,text.toCharArray());
		return encryptedMessage;
	}

	//task 5
	static void DecipherGermanCode()
	{
		String s=EncryptMessage(2,5,4,'S','C','I','O','X','N',"ZUHLCQWMOAPYEBTRDNVI","MLD");
		char [] rings=s.toCharArray();
		s=EncryptMessage(2,5,4,'S',rings[0],'I',rings[1],'X',rings[2],"ZUHLCQWMOAPYEBTRDNVI","UMDPQCUAQNLVVSPIARKCTTRJQKCFPTOKRGOZXALDRLPUHAUZSOSZFSUGWFNFDZCUGVEXUULQYXOTCYRPSYGGZHQMAGPZDKCKGOJMMYYDDH");
		s=BeautifyCode(s);
		System.out.println(s);
	}
	
	//adding spaces to the encrypted german code
	static String BeautifyCode(String code)
	{
		String newCode="";
		char[]encrypted=code.toCharArray();
		for(int i=0;i<code.length();i++)
		{
			if(i==4||i==9||i==16||i==20||i==23||i==29||i==30||i==35||i==39||i==41||i==50||i==51||i==64||i==70||i==71||i==79||i==85||i==94)
				newCode=newCode+encrypted[i]+" ";
			else if(i==60)
				newCode=newCode+encrypted[i]+"\n";
			else
				newCode+=encrypted[i];
		}
		return newCode;
	}
	
	//enigma running method
	static String RunText(char[] pb,Reflector ref,Rotor R,Rotor M,Rotor L,char [] text)
	{
		int letterIndex;
		char currentLetter;
		char[]encryptedText=new char[text.length];
		for(int i=0;i<text.length;i++)
		{
			currentLetter=text[i];
			letterIndex=ConvertLetter(currentLetter);
			CheckNotch(R,M,L);
			currentLetter=pb[letterIndex];
			currentLetter=R.TranslateRotor(currentLetter, "forward");
			currentLetter=M.TranslateRotor(currentLetter, "forward");
			currentLetter=L.TranslateRotor(currentLetter, "forward");
			currentLetter=ref.reflect(currentLetter);
			currentLetter=L.TranslateRotor(currentLetter, "reverse");
			currentLetter=M.TranslateRotor(currentLetter, "reverse");
			currentLetter=R.TranslateRotor(currentLetter, "reverse");
			letterIndex=ConvertLetter(currentLetter);
			currentLetter=pb[letterIndex];
			encryptedText[i]=currentLetter;
			
		}
		return String.valueOf(encryptedText);
	}
	
	//rotates notches if needed
	static void CheckNotch(Rotor R,Rotor M,Rotor L)
	{
		if(R.getRotorOffset()==R.getNotch()||M.getRotorOffset()==M.getNotch())
		{
			if (M.getRotorOffset()==M.getNotch())
				{
					L.advanceOffset(L.getRotorOffset());
				}
				M.advanceOffset(M.getRotorOffset());
		}
	R.advanceOffset(R.getRotorOffset());
	}

	//sets plugboard settings
	static String SetPlugboard(Plugboard p,boolean checkUserInput)
	{
		int f=0;
		Scanner reader = new Scanner(System.in);
		char[] validation=new char[20];
		char[] temp =new char[20];
		String s;
		System.out.println("Enter Plugboard Settings (even number of letters, not more than 20):");
		while(f==0)
		{
			f=1;
			s=reader.nextLine();
			validation=s.toCharArray();
			if(checkUserInput==true)
				{
					if(s.length()>20|| s.length()%2!=0)
					{
						f=0;
					}
					temp=validation;
					for(int i=0;i<validation.length;i++)
					{
						for(int j=0;j<temp.length;j++)
						{
							if(f!=0)
							{
								if((i!=j)&&(temp[j]==validation[i]))
								{
									f=0;
									break;
								}
							}
						}
						if(!inputCheck(validation[i]))
						{
							f=0;

							break;
						}
					
					}
					if(f==0)
						System.out.println("Invalid input, try again!");
				}
			
		}
		for(int i=0;i<validation.length;i++)
		{
			validation[i]=Character.toUpperCase(validation[i]);
		}
		return String.valueOf(validation);

	
	}

	char ForwardPermutation(int rotorNum, char letter) {
		return 0;
	}


	char ReversePermutation(int rotorNum, char letter) {
		return 0;
	}

}



	
	

