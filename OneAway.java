

public class OneAway {
	// There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character.
	// Given two strings, write a function to check if they are one edit (or zero edits) away.
	// Example
	// pale, ple  -> true
	// pales, pale  -> true
	// pale, bale  -> true
	// pale, bake  -> false
	
	
	public static boolean oneAway(String firstWord, String secondWord){
		if ( Math.abs(firstWord.length() - secondWord.length()) >= 2){
			System.out.println("False");
			return false;
		}
		else { //potential insert or delete or replace
			String longer, shorter;
			if (firstWord.length() > secondWord.length()){
				longer = firstWord;
				shorter = secondWord;
			}
			else {
				shorter = firstWord;
				longer = secondWord;
			}

			int StartPointerLong = 0;
			int StartPointerShort = 0;
			int numAwayStart = 0;
			while (numAwayStart < 1 && StartPointerShort !=  shorter.length()){
				// if the words are the same
				if (longer.charAt(StartPointerLong) == shorter.charAt(StartPointerShort)){
					StartPointerLong ++;
					StartPointerShort ++;
				}
				else {
					numAwayStart ++;
				}
			}

			int EndPointerLong = longer.length()-1;
			int EndPointerShort = shorter.length() -1;
			int numAwayEnd = 0;

			while (numAwayEnd < 1 && EndPointerShort >= 0){
				if (longer.charAt(EndPointerLong) == shorter.charAt(EndPointerShort)){
					EndPointerLong --;
					EndPointerShort --;
				}
				else {
					numAwayEnd ++;
				}
			}

			if (StartPointerShort == EndPointerShort || StartPointerLong == EndPointerLong){
				System.out.println("True");
				return true;
			}
			else {
				System.out.println("False");
				return false;
			}
			
		}
		

	}
	
	public static void main(String [] args){
		
		String firstWord = "pale";
		String secondWord = "pales";
		oneAway(firstWord, secondWord);
	}
}
