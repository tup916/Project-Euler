import java.util.Scanner;

/**
 * Calculates the difference between the sm of squares and 
 * the square of sums of the first N natural numbers.
 * @author Tushita
 *
 */
public class SumSquareDifference {

		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("First how many natural numbers? : ");
		
		int limit = in.nextInt();
		
		in.close();
		
		long sumOfSquares = limit*(limit+1)*(2*limit+1)/6;
		long SquareofSums = (limit*(limit+1)/2) * (limit*(limit+1)/2);
		long answer = SquareofSums -sumOfSquares;
		System.out.println("The difference between the sum of squares and the square of sums is : " + SquareofSums + "-" + sumOfSquares + " = " + answer);
	}
}
