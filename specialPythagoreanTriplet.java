/*
A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a^2 + b^2 = c^2
For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.
 */


public class specialPythagoreanTriplet {
	public static void main(String[] args) {
		for (int a=1; a<1000; a++){
			for (int b=a+1; b<1000; b++){
				if ((a*a) + (b*b) - (1000-a-b)*(1000-a-b) == 0){
					System.out.println("a = " + a + 
							"\nb = "+ b + 
							"\nc = " + (1000-b-a));
					System.out.println("The product abc is: " +(a*b*(1000-b-a)));
					break;
				}
			}
		}
	}
}
