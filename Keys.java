
public class Keys {

	public static String Key(String S, int K){
		
		S = S.toUpperCase();

		String [] strings = S.split("-");
		
		S = "";
		for (int i = 0; i< strings.length; i++){
			S = S.concat(strings[i]);
		}
		
		
		//System.out.println(S);
		
		
		
		String returningString = "";
		
		returningString = returningString += S.substring(0, S.length()%K);
		int charString = returningString.length();
		
		if (S.length()%K != 0){
			returningString = returningString + "-";
		}
		int counter = S.length()%K;
		
		
		
		while (charString < S.length()){
			returningString = returningString + S.substring(counter, counter + K);
			returningString = returningString + "-";
			charString += K;
			counter = counter + K;
		}
		
		
		returningString = returningString.substring(0, returningString.length()-1);

		//System.out.println(returningString);
		
		return returningString;
		
	}


	
	
	public static void main(String [] args){
    
		
		String S = "r--dfsdfd--sdabcd-----------------rr-";
		int K = 3;
		
		System.out.println(Key(S, K));
		
	}
}
