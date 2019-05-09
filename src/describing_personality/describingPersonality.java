package describing_personality;

import javax.swing.JOptionPane;

public class DescribingPersonality {
	public static void main(String[] args) {

	String dialogTitle = "Describing Personality";
	String firstName = JOptionPane.showInputDialog(null, "Name", dialogTitle, JOptionPane.PLAIN_MESSAGE);
	String lastName = JOptionPane.showInputDialog(null, "Lastname", dialogTitle, JOptionPane.PLAIN_MESSAGE);
	String nickname = JOptionPane.showInputDialog(null, "Nickname", dialogTitle, JOptionPane.PLAIN_MESSAGE);
	String dateOfBirthday = JOptionPane.showInputDialog(null, "Birthday", dialogTitle, JOptionPane.PLAIN_MESSAGE);

	String personality = firstName + lastName; //creating full name lastname string
	personality = descriptions(descriptionNumber(personality.toLowerCase()));//getting descriptions

	String perceivedPersonality = descriptions(descriptionNumber(nickname.toLowerCase()));
	
	String destiny = descriptions(sumOfDigits(Integer.parseInt(dateOfBirthday)));
	
	String finalDialog = "Your personality is: " + personality + "\n" +
			"You're perceived as: " + perceivedPersonality + "\n" +
			"Your destiny is to be: "+ destiny;
	
	JOptionPane.showMessageDialog(null, finalDialog, dialogTitle, JOptionPane.PLAIN_MESSAGE);
	
	//test();
	
	}

	public static void test () {
	
	String nameTest = "Marcin";
	String lastNameTest = "Staniek";
	String fullName = nameTest + lastNameTest;
	String nicknameTest = "Stanik";
	String dateOfBirthday = "3111997";
	
	String personality = descriptions(descriptionNumber(fullName.toLowerCase()));//getting descriptions
   
	String perceivedPersonality = descriptions(descriptionNumber(nicknameTest.toLowerCase()));
	
	String destiny = descriptions(sumOfDigits(Integer.parseInt(dateOfBirthday)));
	
	System.out.println("Testing program...");
	
	if(personality == descriptions(1))
		System.out.println("personality is ok");
	else
		System.out.println("personality is not ok");

	if(perceivedPersonality == descriptions(7))
		System.out.println("perceived personality is ok");
	else
		System.out.println("perceived personality is not ok");
	if(destiny == descriptions(4))
		System.out.println("destiny is ok");
	else
		System.out.println("destiny is not ok");
	
	
	}
	
	public static String descriptions(int descriptionNumber) {
		
		String[] description = new String[9];
		description[0] = "powerfull, aggresive, self-centered, ambitious, quick-tempered, lonely";
		description[1] = "passive, indecesive, shy, modest, charming, gentle";
		description[2] = "creative creative, bossy, versatile, optimistic, talkative, independent";
		description[3] = "solid, confident, steady, moody, practical, capable";
		description[4] = "nervous, attractive, impatient, lively, adventurous, irresponsible";
		description[5] = "loyal, affectionate, hard-working, friendly, balanced, self-satisfied";
		description[6] = "talented, serious, pessimistic, self-controlled, proud, sensitive";
		description[7] = "tought, efficent, materialistic, energeric, selfish, strong-minded";
		description[8] = "idealistic, romantic, impulsive, rebelious, determined, insecure";
		
		//for(int i=0;i<9;i++) System.out.println(descriptions[i]);// test for printing all descriptions
		
		return description[descriptionNumber-1];
	}
	
	public static int descriptionNumber(String str) {//creating destinySum from string
		int counter = 0;//counter for destiny number
		
		for (int i =0; i < str.length(); i++) { //converting letters to numbers
			
			char c = str.charAt(i); //making char from string
			
			//System.out.println(letter);//test for all letters

			if(c == 'a' || c == 'i' || c == 'q' || c == 'j' || c == 'y') counter += 1;
			if(c == 'b' || c == 'k' || c == 'r') counter += 2;
			if(c == 'c' || c == 'g' || c == 'l' || c == 's') counter += 3;
			if(c == 'd' || c == 'm' || c == 't') counter += 4;
			if(c == 'e' || c == 'h' || c == 'n') counter += 5;
			if(c == 'u' || c == 'v' || c == 'w' || c == 'x') counter += 6;
			if(c == 'o' || c == 'z') counter += 7;
			if(c == 'f' || c == 'p') counter += 8;
		}
		int sum = sumOfDigits(counter);
		return sum;
	}
	
	public static int sumOfDigits(int num) {//adding all numbers from int
        int sum = 0;
        while (num > 0){
            sum = sum + num % 10;
            num = num / 10;
        }
        sum = (sum <10) ? sum : sumOfDigits(sum);
        return sum;
    }
	
}
	