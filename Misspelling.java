import java.util.Scanner;

public class Misspelling {
/*
Problem code: GNY07A

Misspelling is an art form that students seem to excel at. Write a program that removes the nth character from an input string.

Input

The first line of input contains a single integer N (1 ≤ N ≤ 1000) which is the number of datasets that follow.

Each dataset consists of a single line of input containing M, a space, and a string made up of uppercase letters and spaces only. M will be less than or equal to the length of the string. The length of the string is guaranteed to be less than or equal to 80.

Output

For each dataset, you should generate one line of output with the following values: The dataset number as a decimal integer (start counting at one), a space, and the misspelled string. The misspelled string is the input string with the indicated character deleted.

Sample Input

4
4 MISSPELL
1 PROGRAMMING
7 CONTEST
3 BALLOON
Sample Output

1 MISPELL
2 ROGRAMMING
3 CONTES
4 BALOON

 */
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numTimes = input.nextInt();
		int offset;
		String word, first, last;
		while (numTimes >0){
			offset = input.nextInt();
			offset--;
			
			word = input.next();
			
			if (offset!=0)
				first = word.substring(0, offset);
			else
				first = "";
			last = word.substring(offset+1, word.length());
			
			word = first + last;
			
			System.out.println(word);
			numTimes--;
		}
		
		input.close();
	}
}
