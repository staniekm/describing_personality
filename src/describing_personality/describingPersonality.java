package describing_personality;

import javax.swing.JOptionPane;

public class DescribingPersonality {
	public static void main(String[] args) {

		//test();
	
		String dialogTitle = "Describing Personality";
		
		String firstName = getStringDialog("Name", dialogTitle);
		String lastName = getStringDialog("Last Name", dialogTitle);
		String personality = description(descriptionNumber(addTwoStrings(firstName, lastName).toLowerCase()));

		String nickname = getStringDialog("Nickname", dialogTitle);
		String perceivedPersonality = description(descriptionNumber(nickname.toLowerCase()));

		String dateOfBirthday = getStringDialog("Birthday", dialogTitle);
		String destiny = description(sumOfDigits(Integer.parseInt(dateOfBirthday)));	
		
		outputDialog(finalDialog(personality, perceivedPersonality, destiny), dialogTitle);		
	}

	public static String getStringDialog(String info, String title) {
		String string = JOptionPane.showInputDialog(null, info, title, JOptionPane.PLAIN_MESSAGE);
		return string;
	}
	
	public static void outputDialog(String content, String title) {
		JOptionPane.showMessageDialog(null, content, title, JOptionPane.PLAIN_MESSAGE);
	}
	
	public static String finalDialog(String personality, String perceivedPersonality, String destiny) {//create personal descriptions....
		String finalDialog = "You're " + personality + "\n" +
				"You're perceived as " + perceivedPersonality + "\n" +
				"Your destiny is to be "+ destiny;
		return finalDialog;
	}

	public static String description(int descriptionNumber) {//list of descriptions
		
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
				
		return description[descriptionNumber-1];
	}
	
	public static int descriptionNumber(String str) {//description number from string
		int counter = 0;//counter for destiny number
		
		for (int i =0; i < str.length(); i++) { //letters to numbers
			
			char c = str.charAt(i); //char from string
			
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
	
	public static int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0){
            sum = sum + num % 10;
            num = num / 10;
        }
        sum = (sum <10) ? sum : sumOfDigits(sum);
        return sum;
    }
	
	public static String addTwoStrings(String str1, String str2) {
		String str = str1 + str2;
		return str;
	}
	
	public static void test() {
		
		String nameTest = "Marcin";
		String lastNameTest = "Staniek";
		String nicknameTest = "Stanik";
		String dateOfBirthdayTest = "3111997";
		
		System.out.println("Testing program...\n" + "Name: " + nameTest + "\nLast Name: " + lastNameTest + 
				"\nNickname: " + nicknameTest + "\nBirthday: " + dateOfBirthdayTest);
		
		String personality = description(descriptionNumber(addTwoStrings(nameTest, lastNameTest).toLowerCase()));
		String perceivedPersonality = description(descriptionNumber(nicknameTest.toLowerCase()));
		String destiny = description(sumOfDigits(Integer.parseInt(dateOfBirthdayTest)));
			
		if(personality == description(1))
			System.out.println("personality is 1");
		else
			System.out.println("personality is not ok");
	
		if(perceivedPersonality == description(7))
			System.out.println("perceived personality is 7");
		else
			System.out.println("perceived personality is not ok");
		if(destiny == description(4))
			System.out.println("destiny is 4");
		else
			System.out.println("destiny is not ok");
		
		System.out.println("Descriptions: ");
		for(int i=1;i<10;i++)//printing all descriptions
			System.out.println(i + ". " + description(i));
	}
}
	