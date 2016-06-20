/**
 *  FIND THE SMALLEST MULTIPLE OF THE FIRST 20 NATURAL NUMBERS
 * @author Tushita
 *
 */
public class smallestMultiple {

	
	public static long factorial(int num){
		if (num==0 || num==1){
			return 1;
		}
		else
			return factorial(num-1) * num;
	}
	
	//Euclidean gcd algorithm
	public static int gcd(int one, int two){
		
		while (two!=0){
			int temp = two;
			two = one % two;
			one = temp;
		}
		return one;
	}
	
	//OTHER ATTEMPTS
//	public static long gcdOfAll(int start, int end){
//		long product = 1;
//		
//		for (int i=start; i<=end/2; i++){
//			for (int j = end/2+1; j<=end; j++){
////				System.out.println("current i and j are " + i+j);
//				if (gcd(i,j)!=1) System.out.println("gcd of " + i + "," + j + " is " + gcd(i, j));
//				product *= gcd(i, j);
//			}
//		}
//		
//		return product;
//	}
//	public static long whatDenomShouldBe(int start, int end){
//		int [] Arr = new int[end/2 + 1];
//		
//		for (int i=2; i<end/2 + 1; i++){
//			Arr[i] = (int) (Math.log(end)/Math.log(i));
//		}
//	
//		System.out.println(Arrays.toString(Arr));
//		long product = 1;
//		for (int i=2; i<end/2  +1; i++){
//			product *= Math.pow(i, Arr[i]);
//		}
//		return product;
//	}
//	
//	
//	public static int lcm(int n){
//		if (n==1) return 1;
//		if (n==2) return 2;
//		if (lcm(n-1)%n == 0) return lcm(n-1);
//		else
//		{
//			return (int) (factorial(n-1) + 2*lcm(n-1));
//		}
//	}
	
	
	public static void main(String[] args) {
		int SmallestMultiple = 1;
		
		//20 : for the smallest multiple of the first 20 natural numbers
		for (int i=1; i<=20; i++){
			SmallestMultiple = SmallestMultiple/gcd(SmallestMultiple, i) * (i);
		}
		System.out.println(SmallestMultiple);
	}
}
