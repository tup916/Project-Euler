import java.util.LinkedList;

//Find max 24 hours time given 4  positive integers. 
public class MaxTimeGivenDigits {

	
	public static class Time{
		int hour;
		int minutes;
		int seconds;
		
		public Time(){
			//
		}
	}
	
	public static int max(LinkedList<Integer> list){
		int max = 0;
		for (int number : list){
			if (number > max){
				max = number;
			}
		}
		
		return max;
	}
	
	public static void breakToDigits(int a, LinkedList<Integer> list){
		if (a<10 && a>=0){
			list.add(a);
			return;
		}
		
		list.add(a%10);
		breakToDigits(a/10, list);
	}
	
	
	public static LinkedList<Integer> breakToDigits(int a){
		
		LinkedList<Integer> listOfDigits = new LinkedList<Integer>();
		breakToDigits(a, listOfDigits);		
		return listOfDigits;				
	}
	
	public static Time maxTime(int a, int b, int c, int d){
		
		LinkedList<Integer> listOfDigits = breakToDigits(a);
		listOfDigits.addAll(breakToDigits(b));
		listOfDigits.addAll(breakToDigits(c));
		listOfDigits.addAll(breakToDigits(d));
	
		Time toReturn = new Time();
		
		int hour = 0;
		int minutes = 0;
		int seconds = 0;
		
		for (Integer number : listOfDigits){
			if (number == 2){
				listOfDigits.removeFirstOccurrence(number);
				hour = number;
				break;
			}
		}
		
		if (hour == 0){
			for (Integer number : listOfDigits){
				if (number == 1){
					listOfDigits.removeFirstOccurrence(number);
					hour = number;
					break;
				}

			}
			hour = hour * 10;

			int max = max(listOfDigits);
			if (listOfDigits.contains(max)){
				listOfDigits.removeFirstOccurrence(max);
			}
			hour = hour+max;
		}
		else{
			hour = hour * 10;
			boolean foundhour = false;
			for (int lim4 = 3; lim4>=0; lim4--){
				for (Integer number: listOfDigits){
					if (number == lim4){
						hour = hour+number;
						foundhour = true;
						break;
					}
				}
				
				if (foundhour == true){
					listOfDigits.removeFirstOccurrence(hour%10);
					break;
				}
			}
			
		}

		

			
		//----------- done with hours
		
		boolean foundMinutes = false;
		
		for (int lim6 = 5; lim6 >=0; lim6-- ){
			
			for (Integer number : listOfDigits){
				if (number == lim6){
					minutes = number;
					listOfDigits.removeFirstOccurrence(number);
					foundMinutes = true;
					break;
				}
			}
			
			if (foundMinutes){
				break;
			}
			
		}
		
		minutes = minutes*10;
		
		int max = max(listOfDigits);
		minutes+= max;
		if (listOfDigits.contains(max)){
			listOfDigits.removeFirstOccurrence(max);
		}
		
		
		//---------done with seconds
		boolean foundseconds = false;
		
		for (int lim6 = 5; lim6 >=0; lim6-- ){
			
			for (Integer number : listOfDigits){
				if (number == lim6){
					seconds = number;
					listOfDigits.removeFirstOccurrence(number);
					foundseconds = true;
					break;
				}
			}
			
			if (foundseconds){
				break;
			}
			
		}
		
		seconds = seconds*10;
		
		max = max(listOfDigits);
		seconds+= max;
		if (listOfDigits.contains(max)){
			listOfDigits.removeFirstOccurrence(max);
		}
		
		
		toReturn.hour = hour;
		toReturn.minutes = minutes;
		toReturn.seconds = seconds;
		
		return toReturn;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Time calcTime = maxTime(0, 0, 0, 0);
		System.out.println(calcTime.hour + " : " + calcTime.minutes + " : " + calcTime.seconds);
		
		calcTime = maxTime(1, 1, 1, 1);
		System.out.println(calcTime.hour + " : " + calcTime.minutes + " : " + calcTime.seconds);
		
		calcTime = maxTime(1, 2, 3, 4);
		System.out.println(calcTime.hour + " : " + calcTime.minutes + " : " + calcTime.seconds);
		
		calcTime = maxTime(99, 99, 99, 99);
		System.out.println(calcTime.hour + " : " + calcTime.minutes + " : " + calcTime.seconds);
		
		calcTime = maxTime(22, 6, 4, 949);
		System.out.println(calcTime.hour + " : " + calcTime.minutes + " : " + calcTime.seconds);
	}

}
