
public class MinReplacesToSort {

	public static class Pair<T, U>{
		T first;
		U second;
		
		public Pair(T x, U y){
			first = x;
			second = y;
		}
	}
	
	public static Pair<Integer, Integer> printUnsorted(int [] array){
		
		int increasingObstruction = 0;
		boolean found = false;
		for (int i=0; i< array.length-1; i++){
			if (array[i] > array[i+1]){
				increasingObstruction = i + 1;
				found  = true;
				break;
			}
		}
		
		if (found == false)	return null;   //The array is already sorted.
		
		int decreasingObstruction = 0;
		for (int i=array.length-1; i > 0; i--){
			if (array[i] < array[i-1]){
				decreasingObstruction = i - 1;
				break;
			}
		}
		
		
		//find max between increasingObstruction and DecreasingObstruction
		int min = increasingObstruction;
		int max = increasingObstruction;
		if (increasingObstruction < decreasingObstruction){
			for (int i=increasingObstruction; i <= decreasingObstruction; i++){

				if (array[min] > array[i]){
					min = i;
				}
				if (array[max] < array[i]){
					max = i;
				}
			}
		}
		else{
			for (int i=decreasingObstruction; i <= increasingObstruction; i++){

				if (array[min] > array[i]){
					min = i;
				}
				if (array[max] < array[i]){
					max = i;
				}
			}
		}
		
		
		int smallPos = -1;
		int largePos = -1;
		
		if (array[min] < array[0]){
			smallPos = 0;
		}
		else{
			for (int i=0; i<array.length-2; i++){
				if (array[i] <= array[min] && array[min] < array[i+1]){
					smallPos = i+1;
					break;
				}
			}
			if (smallPos == -1) smallPos = array.length-1;
		}
		
		
		if (array[max] > array[array.length-1]){
			largePos = 0;
		}
		else{
			for (int i=array.length-1; i>0; i--){
				if (array[i-1] < array[max] && array[max] <= array[i]){
					largePos = i-1;
					break;
				}
			}
			if (largePos == -1) largePos = 0;
		}
		
		
		return new Pair<Integer, Integer>(smallPos, largePos);
	}
	
	public static void main(String[] args) {
		int [] arrayArg1 = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		Pair<Integer, Integer> answer = printUnsorted(arrayArg1) ;
		System.out.println(answer.first + " " + answer.second);
		
		
		int [] arrayArg2 = {0, 1, 15, 25, 6, 7, 30, 40, 50};
		answer = printUnsorted(arrayArg2) ;
		System.out.println(answer.first + " " + answer.second);
	}
}
