import java.util.Arrays;

public class magicIndex {

	
	public static int magicInd(int[] array){
		
		Arrays.sort(array);
		int current = 0;
		
		while (current < array.length){
			if (array[current] == current){
				return current;
			}
			current = Math.max(current+1 , array[current]);
			
		}
		return -1;
	}
	public static void main(String[] args) {
		int [] potentialMagicArray = {1, 2, 3, 7, 11, 13};
		System.out.println(magicInd(potentialMagicArray));
				
	}

}
