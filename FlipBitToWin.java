/**
You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to find the longest sequence of 1s you could create. 
Example:
Input : 1775  (11011101111)
Output: 8

*/
public class FlipBitToWin {

	
	public static int flipBitToWin(int number){
		int max = 0; 
		int count = 0;
		int numSinceLast = 0;
		int num0s = 0;
		for (int altNum = number; altNum != 0; altNum = altNum >>> 1){
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
		
		return max;
	}


	public static void main (String [] args){

		if (flipBitToWin(1775) != 8){
			System.out.println("Incorrect in case 1775");
		}
	if (flipBitToWin(0) != 0){
			System.out.println("Incorrect in case 0");
		}
	if (flipBitToWin(-1) != 0){
			System.out.println("Incorrect in case -1");
		}
		
	}

}
