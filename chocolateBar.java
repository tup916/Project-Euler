import java.util.Scanner;

public class chocolateBar {
/**
 * You have a rectangular chocolate bar.
 * It consists of m×n (1≤m,n≤1000) squares. 
 * You want to break it up into 1×1 pieces (individual squares). 
 * What is the minimum number of times that you must break the chocolate bar, 
 * or pieces thereof, in order to achieve this? 
 * Note that you cannot stack pieces of the bar and break them, 
 * because the chocolate bar is thick. As an example, a 2×2 bar requires 3 breaks. 
 * First you can break it in half, then break each of the halves in half. 
 * You cannot break it in half, stack the two 1×2 pieces, 
 * and then use only one more break to achieve your goal.

Input Format
The first line contains an integer N, the number of test cases to follow.
Each of the following N lines contains two space-separated integers, 
the dimensions m and n of a chocolate bar.

Output Format
A line containing a single integer for each case given in the input: 
the answer for the corresponding case.

Sample Input
2
1 2
2 2

Sample Output
1
3
 * @param args
 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numTimes = input.nextInt();
		while (numTimes>0){
			int m = input.nextInt();
			int n = input.nextInt();
			
			int numBreak = Math.max(m, n)-1 + (Math.min(m,n)-1)*(Math.max(m,n));
			System.out.println(numBreak);
			
			numTimes--;
		}
		
		input.close();
		
	}

}
