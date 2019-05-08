package describing_personality;

import java.util.Scanner;
import java.lang.*;

public class describingPersonality {
	public static void main(String[] args) {

	
	String name = "Marcin";
	String lastname = "Staniek";
	//String birth = "3111997";
	System.out.println(name);
	System.out.println(lastname);
	//System.out.println(birth);
	
	String string = name + lastname; //adding strings
	string = string.toLowerCase(); //making all letters small
	System.out.println(string); //test for adding strings
		
	
	int destinyNumber = destinyNumber(string);
	System.out.println("should be 1 and there is " + destinyNumber); //test for destiny number

    //System.out.println("should be 10 and there is " + destinySum); //test for adding destiny number

	destiny();
	}
	public static void destiny() {
		
		String[] descriptions = new String[9];
		descriptions[0] = "powerfull";
		descriptions[1] = "passive";
		descriptions[2] = "creative";
		descriptions[3] = "solid";
		descriptions[4] = "nevous";
		descriptions[5] = "loyal";
		descriptions[6] = "talented";
		descriptions[7] = "tought";
		descriptions[8] = "idealistic";
		
		for(int i=0;i<9;i++) {
			System.out.println(descriptions[i]);
		}
	}
	public static int destinyNumber(String string) {
		int destinyCounter = 0;//counter for destiny number
		
		for (int i =0; i < string.length(); i++) { //converting letters to numbers
			
			char letter = string.charAt(i); //making char from string
			
			System.out.println(letter);

			if(letter == 'a' || letter == 'i' || letter == 'q' || letter == 'j' || letter == 'y') destinyCounter += 1;
			if(letter == 'b' || letter == 'k' || letter == 'r') destinyCounter += 2;
			if(letter == 'c' || letter == 'g' || letter == 'l' || letter == 's') destinyCounter += 3;
			if(letter == 'd' || letter == 'm' || letter == 't') destinyCounter += 4;
			if(letter == 'e' || letter == 'h' || letter == 'n') destinyCounter += 5;
			if(letter == 'u' || letter == 'v' || letter == 'w' || letter == 'x') destinyCounter += 6;
			if(letter == 'o' || letter == 'z') destinyCounter += 7;
			if(letter == 'f' || letter == 'p') destinyCounter += 8;
		}
		int destinySum = sumOfDigits(destinyCounter);
		return destinySum;
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
	