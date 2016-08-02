import java.util.Scanner;

public class MonkeyLanguage {

/*

The term “code monkey” is sometimes used to refer to a programmer who doesn't know much about programming. This is unfair to monkeys, because contrary to popular belief, monkeys are quite smart. They have just been misunderstood. This may be because monkeys do not speak English, but only monkey language. Your job is to help humans and monkeys understand each other by writing a monkey language dictionary. For each word that is typed in, your program must determine whether it is a valid monkey language word.

Unlike in English, spelling in monkey language is very simple. Every word in monkey language satisfies the following rules, and every word satisfying the following rules is a monkey language word.

A monkey language word is a special type of word called an A-word, which may be optionally followed by the letter N and a monkey language word.
An A-word is either only the single letter A, or the letter B followed by a monkey language word followed by the letter S.
Here are some examples:

The word “A”' is a monkey language word because it is an A-word.
The word “ANA” is a monkey language word because it is the A-word “A” followed by the letter N and the monkey language word “A”.
The word “ANANA” is a monkey language word because it is the A-word “A” followed by the letter N and the monkey language word “ANA”.
The word “BANANAS” is a monkey language word because it is an A-word, since it is the letter B followed by the monkey language word “ANANA” followed by the letter S.
Write a program which accepts words, one word on each line, and for each word prints YES if the word is a monkey language word, and NO if the word is not a monkey language word. The input word “X” indicates the program should terminate, and there is no output for word “X” (even though it is not a monkey word).

Sample Input

A
ANA
ANANA
BANANAS
BANANA
X
Sample Output

YES
YES
YES
YES
NO

 */
	
	public static boolean isLanguage(String word, boolean firstTime){
		
		if (firstTime && (word.charAt(0)=='B' && word.charAt(word.length()-1) == 'S'))
				return isLanguage(word.substring(1, word.length()-1), false);
		
		if (word.length() == 1){
			if (word.equals("A")) 	return true;
			else					return false;
		}
		
		if (word.charAt(word.length()-2)== 'N' &&  word.charAt(word.length()-1)== 'A'){
			word = word.substring(0, word.length()-2);
			return isLanguage(word, false);
		}
		else return false;
		
	}
	
	public static void main(String []args){
		Scanner input = new Scanner(System.in);
		
		String in = input.nextLine();
		while (!in.equals("X")){
			if (isLanguage(in, true)){
				System.out.println("YES");
			}
			else
				System.out.println("NO");
			in = input.nextLine();
		}
		
		input.close();
	}
}
