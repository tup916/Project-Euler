import java.util.Scanner;

public class catScanner {
	static char[][] arr;

	public static boolean isAllZeros(int [] array){
		for (int i=0; i<array.length; i++){
			if (array[i] != 0) return false;
		}
		return true;
	}
	
	public static int maxIndex(int [] array){

		if (isAllZeros(array)) {
//			System.out.println(Arrays.toString(array));
			return -1;
		}
		int k = 0;
		for (int i=1; i<array.length; i++){
			if (array[i] > array[k]) k = i;
		}
		return k;

	}
	
	
	public static void print(int nrow, int ncol){
		for (int j=0; j<ncol; j++){
			for (int i=0; i<nrow; i++)
			{
				System.out.print(arr[i][j] + " ");
			}
			System.out.println('\n');
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int times = in.nextInt();
		in.nextLine();
		while (times>0){
			String lengths = in.nextLine();
			System.out.println(lengths);
			String [] length = lengths.split(",");
			int rownum = Integer.parseInt(length[0]);
			int colnum = Integer.parseInt(length[1]);

			arr = new char[rownum][colnum];

			String rowarr = in.nextLine();
			String [] rowArray = rowarr.split(",");
			int [] rowArr = new int[rownum];
			for (int i=0; i<rownum; i++){
				rowArr[i] = Integer.parseInt(rowArray[i]);
			}


			String colarr = in.nextLine();
			String [] colArray = colarr.split(",");
			int [] colArr = new int[colnum];
			for (int i=0; i<colnum; i++){
				colArr[i] = Integer.parseInt(colArray[i]);
			}

			for (int i=0; i<rownum; i++){
				for(int j=0; j<colnum; j++){
					arr[i][j] = '.';
				}
			}

			//	print();
			//			int [] row = {0,0,7,1,6,3,4,6,2,7,0,0};
			//			int [] col = {0,0,8,2,6,4,5,4,7,0,0};

			int [] row = rowArr;
			int [] col = colArr;

			int k = maxIndex(row);
			while (k!= -1){
				for (int j=0; j<col.length; j++){
					if ( col[j] >0 && row[k] >0){
						arr[k][j] = '*';
						col[j] --;
					}
					
				}
//				System.out.println(k);
				row[k] = 0;
				k = maxIndex(row);
			}

			//			for (int i=0; i<row.length; i++){

			//				for(int j=0; j<col.length; j++){
			//					if (row[i] >0 && col[j]>0){
			//						arr[k][j] = '*';
			//						row[i] --;
			//						col[j] --;
			//					}
			//
			//				}
			//			}

			print(row.length, col.length);
//			System.out.println(Arrays.toString(row));
//			System.out.println(Arrays.toString(col));
			times--;
		}
		in.close();

	}
}
