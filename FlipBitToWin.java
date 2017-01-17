
public class FlipBitToWin {

	
	public static int flipBitToWin(int number){
		int max = 0; 
		int count = 0;
		int numSinceLast = 0;
		int num0s = 0;
		for (int altNum = number; (altNum != 0); altNum = altNum >>> 1){
			if ((altNum & 1) == 1){
				count++;
				numSinceLast++;
			}
			else{
				num0s++;
				if (num0s == 1){
					numSinceLast = 0;
					count++;
				}
				else{
					if (max < count){
						max = count;
					}
					count = numSinceLast;
					numSinceLast = 0;
					num0s = 1;
					
				}
			}
		}
		
		if (max < count){
			max = count;
			if (num0s == 0 && count < 32){
				return count+1;
			}
		}
		
		if (max > 1){
			return max;
		}
		else{
			return max+1;
		}
	}


	public static void main (String [] args){

		if (flipBitToWin(1775) != 8){
			System.out.println("Incorrect in case 1775");
		}
		if (flipBitToWin(0) != 1){
			System.out.println("Incorrect in case 0");
		}
		if (flipBitToWin(-1) != 32){
			System.out.println("Incorrect in case -1");
		}

		if (flipBitToWin(7) != 4){
			System.out.println("Incorrect in case 7");
		}
	}
}
